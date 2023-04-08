import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Beacons implements Listener{

	private Main plugin;
	public Beacons(Main plugin) {
		this.plugin=plugin;
	}
	Items item = new Items();
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if(event.getEntity().getType().equals(EntityType.ARMOR_STAND)) {
			ArmorStand stand = (ArmorStand)event.getEntity();
			if(plugin.isInList(item.beacons, stand.getEquipment().getHelmet())) {
				event.setCancelled(true);
				if(event.getDamager().getType().equals(EntityType.PLAYER)) {
					ItemStack helmet = stand.getEquipment().getHelmet().clone();
					stand.getWorld().spawnParticle(Particle.ITEM_CRACK, stand.getLocation(), 40, 0.5, 0.5,0.5,0,helmet);
					stand.getWorld().playSound(stand.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
					stand.remove();
					stand.getWorld().dropItemNaturally(stand.getLocation(), helmet);
				}
			}
		}
	}
}