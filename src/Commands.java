import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
