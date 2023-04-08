import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Items {

	Material coal = Material.COAL;

	List<ItemStack> allItems = List.of(dirtBeacon(),hayBaleBeacon(),campfireBeacon(),chestBeacon(),ironBeacon(),
			dripStoneBeacon(),stainedGlassBeacon(),tntBeacon(),beeBeacon(),blueIceBeacon(),diamondBeacon(),enchantingBeacon(),
			bedrockBeacon());
	List<ItemStack> beacons = List.of(dirtBeacon(),hayBaleBeacon(),campfireBeacon(),chestBeacon(),ironBeacon(),
			dripStoneBeacon(),stainedGlassBeacon(),tntBeacon(),beeBeacon(),blueIceBeacon(),diamondBeacon(),enchantingBeacon(),
			bedrockBeacon());


	public ItemStack dirtBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.WHITE + "Dirt Beacon");
		itemMeta.setCustomModelData(1);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in a plains Biome");
		lore.add("Mobs around you take wither damage");
		lore.add("when standing on dirt");
		lore.add(ChatColor.YELLOW + "3X3 Dirt Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack hayBaleBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.GOLD + "Hay Bale Beacon");
		itemMeta.setCustomModelData(2);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.DARK_GREEN + "Placed on village farmland");
		lore.add("Restores food occasionally");
		lore.add(ChatColor.YELLOW + "3X3 Hay Bale Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack campfireBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.WHITE + "Campfire Beacon");
		itemMeta.setCustomModelData(3);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in a Taiga Biome");
		lore.add("Auto Smelts Held Items");
		lore.add(ChatColor.YELLOW + "3X3 Oak Log Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack chestBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.RED + "Chest Beacon");
		itemMeta.setCustomModelData(4);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in a swamp Biome");
		lore.add("Looking down let's you store items");
		lore.add(ChatColor.YELLOW + "3X3 Planks Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack ironBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.WHITE + "Iron Beacon");
		itemMeta.setCustomModelData(5);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in a mineshaft");
		lore.add(ChatColor.LIGHT_PURPLE + "Holding pickaxe's and sneaking shoots a pickaxe");
		lore.add(ChatColor.YELLOW + "3X3 Smooth Stone Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack dripStoneBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.WHITE + "Dripstone Beacon");
		itemMeta.setCustomModelData(6);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed underground");
		lore.add(ChatColor.LIGHT_PURPLE + "Occasionally drops pointed");
		lore.add(ChatColor.LIGHT_PURPLE + "dripstone on nearby mobs");
		lore.add(ChatColor.YELLOW + "3X3 Dripstone Block Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack stainedGlassBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Stained Glass Beacon");
		itemMeta.setCustomModelData(7);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in a beach biome");
		lore.add(ChatColor.LIGHT_PURPLE + "Holding glass gives an Xray effect");
		lore.add(ChatColor.YELLOW + "3X3 Stained Glass Base");
		lore.add(ChatColor.WHITE + "Right Click for More");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack tntBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.RED + "TNT Beacon");
		itemMeta.setCustomModelData(8);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed on top of a desert pyramid");
		lore.add(ChatColor.LIGHT_PURPLE + "Sneak and right clicking TNT shoots TNT");
		lore.add(ChatColor.YELLOW + "3X3 Sandstone Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack beeBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.YELLOW + "Bee Beacon");
		itemMeta.setCustomModelData(9);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in a flower forest");
		lore.add(ChatColor.LIGHT_PURPLE + "Gives healing and extra health");
		lore.add(ChatColor.YELLOW + "Circled By Flowers For Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack blueIceBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.BLUE + "Blue Ice Beacon");
		itemMeta.setCustomModelData(10);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed on a Iceberg");
		lore.add(ChatColor.LIGHT_PURPLE + "Occasionally freezes nearby mobs");
		lore.add(ChatColor.YELLOW + "3X3 Snow Block Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack diamondBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.AQUA + "Diamond Beacon");
		itemMeta.setCustomModelData(11);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed on bedrock");
		lore.add(ChatColor.LIGHT_PURPLE + "Let's you mine bedrock");
		lore.add(ChatColor.LIGHT_PURPLE + "Gives you resistance");
		lore.add(ChatColor.YELLOW + "Any Bedrock Block Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack enchantingBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.AQUA + "Enchanting Beacon");
		itemMeta.setCustomModelData(12);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in Stronghold Library");
		lore.add(ChatColor.LIGHT_PURPLE + "Enchants Held Items!");
		lore.add(ChatColor.YELLOW + "3X3 Bookshelf Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
	public ItemStack bedrockBeacon() {
		ItemStack itemstack = new ItemStack(coal);
		ItemMeta itemMeta = itemstack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.DARK_GRAY + "Becrock Beacon");
		itemMeta.setCustomModelData(12);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(ChatColor.GREEN + "Placed in the End Dimension");
		lore.add(ChatColor.LIGHT_PURPLE + "Shoot's rockets into the sky");
		lore.add(ChatColor.LIGHT_PURPLE + "that tracks the ender dragon");
		lore.add(ChatColor.YELLOW + "3X3 Diamond Block Base");
		itemMeta.setLore(lore);
		itemstack.setItemMeta(itemMeta);
		return itemstack;
	}
}

