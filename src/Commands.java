import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinBrute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor{

	private Main plugin;
	public Commands(Main plugin) {
		this.plugin=plugin;
	}
	Items item = new Items();
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(label.equalsIgnoreCase("giveitem")) {
				if(args[0].equalsIgnoreCase("all")) {
					for(ItemStack allIt : item.allItems) {
						plugin.addItem(p, allIt);
					}
				}
				else {
					try {
						plugin.addItem(p, item.allItems.get(Integer.parseInt(args[0]) - 1));
					} catch (Exception e) {
						String s = convertObjectArrayToString(args);
						for(ItemStack it : item.allItems) {
							if(it.getItemMeta().getDisplayName().equalsIgnoreCase(s)) {
								plugin.addItem(p, it);
							}
						}
					}
				}
			}
			else if(label.equals("spawn")) {
				Location loc = p.getTargetBlock(null, 100).getLocation();
				if(args[0].equals("bacon")) {
					if(args.length == 1) {
						Piglin piglin = (Piglin)loc.getWorld().spawnEntity(loc, EntityType.PIGLIN);
						piglin.setCustomName(plugin.bacon);piglin.setImmuneToZombification(true);
						piglin.setAdult();
					}
					else if(args.length == 2) {
						try {
							for(int i = 0;i<Integer.parseInt(args[1]);i++) {
								Piglin piglin = (Piglin)loc.getWorld().spawnEntity(loc, EntityType.PIGLIN);
								piglin.setCustomName(plugin.bacon);piglin.setImmuneToZombification(true);
								piglin.setAdult();
							}
						} catch (Exception e) {
						}
					}
				}
				else if(args[0].equals("baconwarrior")) {
					if(args.length == 1) {
						PiglinBrute piglin = (PiglinBrute)loc.getWorld().spawnEntity(loc, EntityType.PIGLIN_BRUTE);
						piglin.setCustomName(plugin.baconWarrior);piglin.setImmuneToZombification(true);
						piglin.setAdult();
					}
					else if(args.length == 2) {
						try {
							for(int i = 0;i<Integer.parseInt(args[1]);i++) {
								PiglinBrute piglin = (PiglinBrute)loc.getWorld().spawnEntity(loc, EntityType.PIGLIN_BRUTE);
								piglin.setCustomName(plugin.baconWarrior);piglin.setImmuneToZombification(true);
								piglin.setAdult();
							}
						} catch (Exception e) {
						}
					}
				}
			}
		}
		return false;
	}
	public String convertObjectArrayToString(String[] arr) {
		StringBuilder sb = new StringBuilder();
		for (String obj : arr)
			sb.append(obj.toString()).append(" ");
		return sb.substring(0, sb.length() - 1);
	}
}
