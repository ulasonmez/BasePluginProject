import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DirtBeacon implements Listener{

	private Main plugin;
	public DirtBeacon(Main plugin) {
		this.plugin=plugin;
	}
	Items item = new Items();
	ItemStack beacon = item.dirtBeacon();
	Material base = Material.DIRT;
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(event.getHand().equals(EquipmentSlot.HAND)) {
				if(plugin.holdsItem(p, beacon)) {
					Location loc = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation();
					plugin.decreaseItem(p);
					ArmorStand stand = plugin.placeBlockArmorStand(loc, beacon);
					if(plugin.hasBaseUnder(stand, base)) {
						spawnBeacon(stand);
					}
				}
			}
		}
	}
	public void spawnBeacon(ArmorStand stand) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if(stand.isDead()) {
					this.cancel();
				}
				for(double y = 1;y<=20;y+=0.5) {
					Location loc = plugin.addToLoc(stand.getLocation(), 0, y, 0);
					loc.getWorld().spawnParticle(Particle.ITEM_CRACK, loc, 5, 0.1,0.3,0.1,0,new ItemStack(Material.DIRT));
				}
				for(Player p : stand.getWorld().getPlayers()) {
					for(Entity ent : p.getNearbyEntities(5, 3, 5)) {
						if(ent instanceof LivingEntity) {
							LivingEntity lent = (LivingEntity)ent;
							if(!lent.getType().equals(EntityType.ARMOR_STAND)) {
								lent.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 3, 1));
							}
						}
					}
				}

			}
		}.runTaskTimer(plugin, 0, 1);
	}
}