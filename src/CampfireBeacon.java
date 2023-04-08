import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CampfireBeacon implements Listener{

	private Main plugin;
	public CampfireBeacon(Main plugin) {
		this.plugin=plugin;
	}
	Items item = new Items();
	private List<Material> smeltableItems = Arrays.asList(
			Material.IRON_ORE,Material.GOLD_ORE,
			Material.COBBLESTONE,Material.SAND,
			Material.CLAY_BALL,Material.NETHERRACK,
			Material.ANCIENT_DEBRIS,Material.RAW_IRON,
			Material.RAW_GOLD,Material.RAW_COPPER,
			Material.PORKCHOP,Material.BEEF,
			Material.CHICKEN,Material.COD,
			Material.SALMON,Material.POTATO,
			Material.RABBIT,Material.MUTTON,Material.KELP);
	private List<Material> smeltedTypes = Arrays.asList(
			Material.IRON_INGOT,Material.GOLD_INGOT,
			Material.STONE,Material.GLASS,
			Material.BRICK,Material.NETHER_BRICK,
			Material.NETHERITE_SCRAP,Material.IRON_INGOT,
			Material.GOLD_INGOT,Material.COPPER_INGOT,
			Material.COOKED_PORKCHOP,Material.COOKED_BEEF,
			Material.COOKED_CHICKEN,Material.COOKED_COD,
			Material.COOKED_SALMON,Material.BAKED_POTATO,
			Material.COOKED_RABBIT,Material.COOKED_MUTTON,Material.DRIED_KELP);
	public Material getSmeltedMaterial(Material material) {
		int index = smeltableItems.indexOf(material);
		if (index != -1) {
			return smeltedTypes.get(index);
		} else {
			return null;
		}
	}
	ItemStack beacon = item.campfireBeacon();
	Material base = Material.OAK_LOG;
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
			int timer = 0;
			@Override
			public void run() {
				if(stand.isDead()) {
					this.cancel();
				}
				for(double y = 1;y<=20;y+=0.5) {
					Location loc = plugin.addToLoc(stand.getLocation(), 0, y, 0);
					loc.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, loc, 5, 0.1,0.3,0.1,0);
				}
				timer++;
				if(timer >= 5) {
					for(Entity ent : stand.getNearbyEntities(3, 5, 3)) {
						if(ent.getType().equals(EntityType.PLAYER)) {
							Player p = (Player)ent;
							if(!plugin.isHandEmpty(p)) {
								Material mat = getSmeltedMaterial(p.getInventory().getItemInMainHand().getType());
								if(mat!=null) {
									plugin.decreaseItem(p);
									p.getWorld().playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1, 1);
									p.getWorld().spawnParticle(Particle.FLAME, plugin.addToLoc(p.getLocation(), 0, 1, 0),
											30, 1, 1, 1, 0);
									p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(mat));
								}
							}
						}
					}
				}
			}
		}.runTaskTimer(plugin, 0, 1);
	}
}