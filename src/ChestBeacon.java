import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Nameable;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ChestBeacon implements Listener{
	private Main plugin;
	public ChestBeacon(Main plugin) {
		this.plugin=plugin;
	}
	Items item = new Items();
	ItemStack beacon = item.chestBeacon();
	Material base = Material.OAK_PLANKS;
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
					loc.getWorld().spawnParticle(Particle.ITEM_CRACK, loc, 5, 0.1,0.3,0.1,0,new ItemStack(Material.OAK_PLANKS));
				}
			}
		}.runTaskTimer(plugin, 0, 1);
	}
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
	    if (event.getInventory().getHolder() instanceof Nameable) {
	        Nameable nameable = (Nameable) event.getInventory().getHolder();
	        if (nameable.getCustomName() != null && nameable.getCustomName().equals(plugin.portableChest)) {
	            Player player = (Player) event.getPlayer();
	            float currentPitch = player.getLocation().getPitch();

	            if (currentPitch == 90.0f) {
	            	Location loc = player.getLocation().clone();
	            	loc.setPitch(89.9f);
	                player.teleport(loc);
	            }

	            UUID playerUUID = player.getUniqueId();
	            Inventory closedInventory = event.getInventory();
	            Inventory savedInventory = plugin.savedInventories.get(playerUUID);
	            if (savedInventory == null) {
	                savedInventory = Bukkit.createInventory(player, 9, plugin.portableChest);
	                plugin.savedInventories.put(playerUUID, savedInventory);
	            }
	            for (int i = 0; i < closedInventory.getSize(); i++) {
	                ItemStack item = closedInventory.getItem(i);
	                savedInventory.setItem(i, item);
	            }
	        }
	    }
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (player.getLocation().getPitch() == 90.0f) {
			ArmorStand stand = plugin.getSpesificArmorStand(item.chestBeacon());
			if(stand!=null) {
				Inventory savedInventory = plugin.savedInventories.get(player.getUniqueId());
				if (savedInventory == null) {
					savedInventory = Bukkit.createInventory(player, 9, plugin.portableChest);
					plugin.savedInventories.put(player.getUniqueId(), savedInventory);
				}

				player.openInventory(savedInventory);
			}
		}
	}
}