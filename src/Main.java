import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{

	String bacon = "Bacon";
	String baconWarrior = "Bacon Warrior";
	String portableChest = "Portable Chest";
	public Map<UUID, Inventory> savedInventories = new HashMap<>();
	@Override
	public void onEnable() {

		getCommand("spawn").setExecutor(new Commands(this));
		getCommand("giveitem").setExecutor(new Commands(this));

		getServer().getPluginManager().registerEvents(this, this);
		dirtBeaconRecipe();hayBaleRecipe();
		campfireBeaconRecipe();chestBeaconRecipe();
		ironBeaconRecipe();stainedGlassBeaconRecipe();
		tntBeaconRecipe();beeBeaconRecipe();
		blueIceBeaconRecipe();diamondBeaconRecipe();
		enchantingBeacon();bedrockBeaconRecipe();
	}
	@Override
	public void onDisable() {
		for(World w : Bukkit.getWorlds()) {
			for(Entity ent : w.getEntities()) {
				if(ent.getType().equals(EntityType.ARMOR_STAND)) {
					ent.remove();
				}
			}
		}
	}
	public boolean hasBaseUnder(ArmorStand stand, Material matType) {
		for(int x = -1; x<=1;x++) {
			for(int z = -1; z<=1;z++) {
				Location loc = addToLoc(stand.getLocation(), x, -1, z);
				if(loc.getBlock().getType()!=matType) {
					return false;
				}
			}
		}
		return true;
	}
	Items item = new Items();
	NamespacedKey a,b,c,d,e,f,g,h,i,j,k,l;
	@EventHandler
	public void onJoin(PlayerJoinEvent evt) {
		Player p = evt.getPlayer();
		p.discoverRecipe(a);p.discoverRecipe(b);p.discoverRecipe(c);
		p.discoverRecipe(d);p.discoverRecipe(e);p.discoverRecipe(f);
		p.discoverRecipe(g);p.discoverRecipe(h);p.discoverRecipe(i);
		p.discoverRecipe(j);p.discoverRecipe(k);p.discoverRecipe(l);
	}

	public void dirtBeaconRecipe() {
		ItemStack result = item.dirtBeacon();
		this.a = new NamespacedKey(this, "a");
		ShapedRecipe recipe = new ShapedRecipe(a, result);
		recipe.shape("222", "212", "111");
		recipe.setIngredient('1', Material.DIRT);
		recipe.setIngredient('2', Material.GLASS);
		Bukkit.addRecipe(recipe);
	}
	public void hayBaleRecipe() {
		ItemStack result = item.hayBaleBeacon();
		this.b = new NamespacedKey(this, "b");
		ShapedRecipe recipe = new ShapedRecipe(b, result);
		recipe.shape("222", "232", "111");
		recipe.setIngredient('1', Material.OAK_PLANKS);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.HAY_BLOCK);
		Bukkit.addRecipe(recipe);
	}
	public void campfireBeaconRecipe() {
		ItemStack result = item.campfireBeacon();
		this.c = new NamespacedKey(this, "c");
		ShapedRecipe recipe = new ShapedRecipe(c, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.CAMPFIRE);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.COAL_BLOCK);
		Bukkit.addRecipe(recipe);
	}
	public void chestBeaconRecipe() {
		ItemStack result = item.chestBeacon();
		this.d = new NamespacedKey(this, "d");
		ShapedRecipe recipe = new ShapedRecipe(d, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.CHEST);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.OAK_PLANKS);
		Bukkit.addRecipe(recipe);
	}
	public void ironBeaconRecipe() {
		ItemStack result = item.ironBeacon();
		this.e = new NamespacedKey(this, "e");
		ShapedRecipe recipe = new ShapedRecipe(e, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.IRON_BLOCK);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.SMOOTH_STONE);
		Bukkit.addRecipe(recipe);
	}
	public void stainedGlassBeaconRecipe() {
		ItemStack result = item.stainedGlassBeacon();
		this.f = new NamespacedKey(this, "f");
		ShapedRecipe recipe = new ShapedRecipe(f, result);
		recipe.shape("222", "232", "111");
		recipe.setIngredient('1', Material.BROWN_STAINED_GLASS);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.EMERALD);
		Bukkit.addRecipe(recipe);
	}
	public void tntBeaconRecipe() {
		ItemStack result = item.tntBeacon();
		this.g = new NamespacedKey(this, "g");
		ShapedRecipe recipe = new ShapedRecipe(g, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.TNT);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.SAND);
		Bukkit.addRecipe(recipe);
	}
	public void beeBeaconRecipe() {
		ItemStack result = item.beeBeacon();
		this.h = new NamespacedKey(this, "h");
		ShapedRecipe recipe = new ShapedRecipe(h, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.BEE_NEST);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.OAK_PLANKS);
		Bukkit.addRecipe(recipe);
	}
	public void blueIceBeaconRecipe() {
		ItemStack result = item.blueIceBeacon();
		this.i = new NamespacedKey(this, "i");
		ShapedRecipe recipe = new ShapedRecipe(i, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.BLUE_ICE);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.SNOW_BLOCK);
		Bukkit.addRecipe(recipe);
	}
	public void diamondBeaconRecipe() {
		ItemStack result = item.diamondBeacon();
		this.j = new NamespacedKey(this, "j");
		ShapedRecipe recipe = new ShapedRecipe(j, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.DIAMOND);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.BEDROCK);
		Bukkit.addRecipe(recipe);
	}
	public void enchantingBeacon() {
		ItemStack result = item.enchantingBeacon();
		this.k = new NamespacedKey(this, "k");
		ShapedRecipe recipe = new ShapedRecipe(k, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.ENCHANTING_TABLE);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.BOOKSHELF);
		Bukkit.addRecipe(recipe);
	}
	public void bedrockBeaconRecipe() {
		ItemStack result = item.bedrockBeacon();
		this.l = new NamespacedKey(this, "l");
		ShapedRecipe recipe = new ShapedRecipe(l, result);
		recipe.shape("222", "212", "333");
		recipe.setIngredient('1', Material.BEDROCK);
		recipe.setIngredient('2', Material.GLASS);
		recipe.setIngredient('3', Material.GUNPOWDER);
		Bukkit.addRecipe(recipe);
	}
	public boolean sameName(Entity ent, String name) {
		if(ent.getCustomName()!=null && ent.getCustomName().equals(name)) {
			return true;
		}
		return false;
	}
	public boolean hasPotionEffect(Player p, PotionEffectType pet) {
		for(PotionEffect pe : p.getActivePotionEffects()) {
			if(pe.getType().equals(pet)) {
				return true;
			}
		}
		return false;
	}
	public boolean isHandEmpty(Player p) {
		if(p.getInventory().getItemInMainHand()==null) {
			return true;
		}
		else {
			if(p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
				return true;
			}
		}
		return false;
	}
	public boolean isCloseToLocations(List<Location> locations, Location loc, double radius) {
		for(Location locs : locations) {
			if(isClose(locs, loc, radius)) {
				return true;
			}
		}
		return false;
	}
	public void useAsTotem(Player p, ItemStack totemItem) {
		ItemStack it = p.getInventory().getItemInMainHand().clone();
		p.getInventory().setItemInMainHand(totemItem);
		p.damage(p.getHealth() * 2);
		new BukkitRunnable() {
			@Override
			public void run() {
				p.getInventory().setItemInMainHand(it);
			}
		}.runTaskLater(this,4);
	}
	public boolean isInList(List<ItemStack> list,ItemStack checkItem) {
		for(ItemStack it : list) {
			if(this.isSame(checkItem, it)) {
				return true;
			}
		}
		return false;
	}
	public String returnLocationMessage(Location loc) {
		return ChatColor.GREEN+"x: "+(int)loc.getX()+" y: "+(int)loc.getZ();
	}
	public boolean holdsType(Player p, Material mat) {
		if(p.getInventory().getItemInMainHand()!=null) {
			if(p.getInventory().getItemInMainHand().getType().equals(mat)) {
				return true;
			}
		}
		return false;
	}
	public void removeItem(Player p,ItemStack it) {
		for(ItemStack it2 : p.getInventory().getContents()) {
			if(isSame(it2, it)) {
				it2.setType(Material.AIR);
			}
		}
	}
	public ArmorStand getSpesificArmorStand(ItemStack it) {
		for(World w : Bukkit.getWorlds()) {
			for(Entity ent : w.getEntities()) {
				if(ent instanceof ArmorStand) {
					if(hasHelmet(ent, it)) {
						return (ArmorStand)ent;
					}
				}
			}
		}
		return null;
	}
	public void setHelmet(Player p, ItemStack helmet) {
		if(p.getEquipment().getHelmet()==null) {
			decreaseItem(p);
			p.getEquipment().setHelmet(helmet);
		}
		else {
			if(p.getEquipment().getHelmet().getType().equals(Material.AIR)) {
				decreaseItem(p);
				p.getEquipment().setHelmet(helmet);
			}
		}
	}
	public void sendDelayedMessages(String text,int delay) {
		new BukkitRunnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage(text);
			}
		}.runTaskLater(this, delay);
	}

	public LivingEntity getNearbyEntity(Location loc, double radius, Player p) {
		for(Entity ent : loc.getWorld().getNearbyEntities(loc,radius,radius,radius)) {
			if(ent instanceof LivingEntity) {
				LivingEntity lent = (LivingEntity)ent;
				if(!lent.equals(p) && !lent.getType().equals(EntityType.ARMOR_STAND)) {
					return lent;
				}
			}
		}
		return null;
	}
	public void removeActivePotionEffects(Player p) {
		for(PotionEffect pe : p.getActivePotionEffects()) {
			p.removePotionEffect(pe.getType());
		}
	}
	public int countOfEntityNamed(String s) {
		int count = 0;
		for(World w : Bukkit.getWorlds()) {
			for(Entity ent : w.getEntities()) {
				if(ent.getCustomName()!=null && ent.getCustomName().equals(s)) {
					count++;
				}
			}
		}
		return count;
	}
	public Entity getEntityByName(String name) {
		for(World w : Bukkit.getWorlds()) {
			for(Entity ent : w.getEntities()) {
				if(ent.getCustomName()!=null && ent.getCustomName().equals(name)) {
					return ent;
				}
			}
		}
		return null;
	}
	Random rand = new Random();
	public void spawnFireworks(Location loc) {
		FireworkEffect.Builder fwB = FireworkEffect.builder();
		fwB.flicker(rand.nextBoolean());
		fwB.trail(rand.nextBoolean());
		fwB.with(FireworkEffect.Type.BALL);
		fwB.withColor(Color.fromRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		fwB.withFade(Color.fromRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
		FireworkEffect fe = fwB.build();
		Firework f = (Firework) loc.getWorld().spawn(loc, Firework.class);
		FireworkMeta fm = f.getFireworkMeta();
		fm.addEffect(fe);
		f.setFireworkMeta(fm);
		f.detonate();
	}
	public boolean isClose(Location loc1, Location loc2,double radius) {
		if(loc1!=null && loc2!=null) {
			if(loc1.getWorld().equals(loc2.getWorld())) {
				if(loc1.distance(loc2)<=radius) {
					return true;
				}
			}
		}
		return false;
	}
	public ArmorStand placeBlockArmorStand(Location loc, ItemStack block) {
		loc.setX((int)loc.getX());
		loc.setZ((int)loc.getZ());
		ArmorStand stand = (ArmorStand)loc.getWorld().spawnEntity(this.addToLoc(loc, 0.5, 0, 0.5), EntityType.ARMOR_STAND);
		stand.setGravity(false);
		stand.getEquipment().setHelmet(block);
		stand.setSilent(true);
		stand.setInvisible(true);
		return stand;
	}
	public Shulker placeGlowingBlock(Location loc) {
		loc.setX((int)loc.getX());
		loc.setZ((int)loc.getZ());
		Shulker stand = (Shulker)loc.getWorld().spawnEntity(this.addToLoc(loc, 0.5, 0, 0.5), EntityType.SHULKER);
		stand.setGravity(false);
		stand.setInvisible(true);
		stand.setInvulnerable(true);
		stand.setAI(false);
		stand.setCollidable(false);
		stand.setSilent(true);
		return stand;
	}
	public double returnMaxHealth(LivingEntity lent) {
		return lent.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
	}
	public ArmorStand spawnHologram(Location loc, String text) {
		ArmorStand stand = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		stand.setVisible(false);
		stand.setCustomNameVisible(true);
		stand.setGravity(false);
		stand.setMarker(true);
		stand.setCustomName(text);
		return stand;
	}
	public ArmorStand spawnArmorStand(Location loc, ItemStack it) {
		ArmorStand stand = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		stand.setVisible(false);
		stand.setGravity(false);
		stand.setInvulnerable(true);
		stand.getEquipment().setHelmet(it);
		return stand;
	}
	public ArmorStand spawnPlayerModelStand(Location loc, ItemStack it) {
		ArmorStand stand = (ArmorStand)loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
		stand.setVisible(false);
		stand.setGravity(false);
		stand.setMarker(true);
		stand.setCollidable(false);
		stand.setInvulnerable(true);
		stand.getEquipment().setHelmet(it);
		return stand;
	}
	public void decreaseItem(Player p) {
		p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
	}
	public boolean hasHelmet(Entity lent, ItemStack hat) {
		if(lent instanceof LivingEntity) {
			LivingEntity lent2 = (LivingEntity)lent;
			if(isSame(lent2.getEquipment().getHelmet(), hat)) {
				return true;
			}
		}
		return false;
	}
	public Location addToLoc(Location loc, double x, double y, double z) {
		return new Location(loc.getWorld(), loc.getX()+x, loc.getY()+y, loc.getZ()+z);
	}
	public void addItem(Player p, ItemStack it) {
		if(p.getInventory().firstEmpty() == -1) {
			p.getWorld().dropItemNaturally(p.getLocation(), it);
		}
		else {
			p.getInventory().addItem(it);
		}
	}
	public Player getNearestPlayer(Location loc) {
		double length = Double.MAX_VALUE;
		Player nearestPlayer = null;
		for(Player p : loc.getWorld().getPlayers()) {
			if(loc.distance(p.getLocation())<length) {
				length = loc.distance(p.getLocation());
				nearestPlayer = p;
			}
		}
		return nearestPlayer;
	}
	public boolean holdsItem(Player p, ItemStack it) {
		if(isSame(p.getInventory().getItemInMainHand(), it))
			return true;
		return false;
	}
	public boolean holdsItemLeft(Player p, ItemStack it) {
		if(isSame(p.getInventory().getItemInOffHand(), it))
			return true;
		return false;
	}
	public boolean isSame(ItemStack it1, ItemStack it2) {
		if(it1!=null) {
			if(it1.getItemMeta()!=null) {
				if(it1.getItemMeta().getDisplayName().equals(it2.getItemMeta().getDisplayName())) {
					return true;
				}
			}
		}
		return false;
	}
	public int getMaxHealth(Player p) {
		return (int) p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
	}
	public void setMaxHealth(LivingEntity lent, double health,boolean shouldSetMaxHealth) {
		new BukkitRunnable() {
			@Override
			public void run() {
				lent.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
				if(shouldSetMaxHealth) {
					lent.setHealth(lent.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
				}
			}
		}.runTaskLater(this, 10);
	}
	public boolean hasItemInInventory(Player p, ItemStack it) {
		for(ItemStack pItem : p.getInventory().getContents()) {
			if(isSame(pItem, it)) {
				return true;
			}
		}
		return false;
	}
	public void sendMessage(String sender, String message) {
		Bukkit.broadcastMessage(sender+ChatColor.WHITE+": "+message);
	}
	public void launchBlocks(Location loc,List<Material> blocks, int launchBlockAmount) {
		Random rand = new Random();
		for(int i=0;i<launchBlockAmount;i++) {
			FallingBlock fb = (FallingBlock)loc.getWorld().spawnFallingBlock(loc, blocks.get(rand.nextInt(blocks.size())).createBlockData());
			fb.setVelocity(new Vector(randomDouble(-1, 1),1,randomDouble(-1, 1)));
		}
	}
	public void launchBlocksNearby(Location loc,int launchBlockAmount) {
		List<Material> blocks = new ArrayList<>();
		int r = 3;
		for(int x = -r;x<=r;x++) {
			for(int z = -r;z<=r;z++) {
				for(int y = -r; y<=r;y++) {
					Location loc2 = addToLoc(loc, x, y, z);
					if(!blocks.contains(loc2.getBlock().getType())) {
						blocks.add(loc2.getBlock().getType());
					}
				}
			}
		}
		launchBlocks(loc, blocks, launchBlockAmount);
	}
	public void launchItems(Location loc,List<Material> items, int launchBlockAmount) {
		Random rand = new Random();
		for(int i=0;i<launchBlockAmount;i++) {
			ItemStack it = new ItemStack(items.get(rand.nextInt(items.size())));
			Item fb = (Item)loc.getWorld().dropItem(loc, it);
			fb.setPickupDelay(20*2);
			fb.setVelocity(new Vector(randomDouble(-1,1),randomDouble(0, 1),randomDouble(-1,1)));
		}
	}
	public double randomDouble(double rangeMin,double rangeMax) {
		return rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
	}
}
