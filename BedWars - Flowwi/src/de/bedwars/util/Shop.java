package de.bedwars.util;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
public class Shop {

	Player p;
	  
	  public Shop(Player player)
	  {
	    this.p = player;
	  }
	  
	  public void openMainShop()
	  {
	    Inventory inv = Bukkit.createInventory(null, 36, "§8> §c§lShop §8<");
	    
	    ItemStack Glass = new ItemManager(Material.STAINED_GLASS_PANE, (short)7).setDisplayName("  ").build();
	    
	    ItemStack Blöcke = new ItemManager(Material.SANDSTONE).setDisplayName("§e§lBlöcke").build();
	    ItemStack Rüstungen = new ItemManager(Material.CHAINMAIL_CHESTPLATE).setDisplayName("§e§lRüstungen").build();
	    ItemStack Spitzhacken = new ItemManager(Material.STONE_PICKAXE).setDisplayName("§e§lSpitzhacken").build();
	    ItemStack Schwerter = new ItemManager(Material.WOOD_SWORD).setDisplayName("§e§lSchwerter").build();
	    ItemStack Bögen = new ItemManager(Material.BOW).setDisplayName("§e§lBögen").build();
	    ItemStack Essen = new ItemManager(Material.COOKED_BEEF).setDisplayName("§e§lEssen").build();
	    ItemStack Truhen = new ItemManager(Material.CHEST).setDisplayName("§e§lTruhen").build();
	    ItemStack Tränke = new ItemManager(Material.GLASS_BOTTLE).setDisplayName("§e§lTränke").build();
	    ItemStack Extras = new ItemManager(Material.GHAST_TEAR).setDisplayName("§e§lExtras").build();
	    for (int i = 0; i < 36; i++) {
	      switch (i)
	      {
	      case 0: 
	        inv.setItem(i, Blöcke);
	        break;
	      case 1: 
	        inv.setItem(i, Rüstungen);
	        break;
	      case 2: 
	        inv.setItem(i, Spitzhacken);
	        break;
	      case 3: 
	        inv.setItem(i, Schwerter);
	        break;
	      case 4: 
	        inv.setItem(i, Bögen);
	        break;
	      case 5: 
	        inv.setItem(i, Essen);
	        break;
	      case 6: 
	        inv.setItem(i, Truhen);
	        break;
	      case 7: 
	        inv.setItem(i, Tränke);
	        break;
	      case 8: 
	        inv.setItem(i, Extras);
	        break;
	      default: 
	        inv.setItem(i, Glass);
	      }
	    }
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	  }
	  
	  public void openBlöckeShop()
	  {
	    Inventory inv = getMainShop("Blöcke");
	    
	    ItemStack sandstein = new ItemManager(Material.SANDSTONE).setDisplayName("§3§lSandstein").setAmount(4).addLoreLine("§8> §72 §cBronze").setExtra("2 Bronze").build();
	    ItemStack glas = new ItemManager(Material.GLASS).setDisplayName("§3§lGlas").setAmount(2).addLoreLine("§8> §74 §cBronze").setExtra("4 Bronze").build();
	    ItemStack endstone = new ItemManager(Material.ENDER_STONE).setDisplayName("§3§lEndstein").setAmount(1).addLoreLine("§8> §74 §cBronze").setExtra("4 Bronze").build();
	    ItemStack seelaterne = new ItemManager(Material.SEA_LANTERN).setDisplayName("§3§lSeelaterne").setAmount(1).addLoreLine("§8> §78 §cBronze").setExtra("8 Bronze").build();
	    
	    
	    inv.setItem(21, sandstein);
	    inv.setItem(22, glas);
	    inv.setItem(23, endstone);
//	    inv.setItem(23, seelaterne);
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openRüstungenShop()
	  {
	    Inventory inv = getMainShop("Rüstung");
	    if (BedwarsManager.Blau.contains(p))
	    {
	      ItemStack sandstein = new ItemManager(Material.LEATHER_HELMET).addLeatherColor(Color.BLUE).setDisplayName("§3§lLeder-Helm").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §71 §cBronze").setExtra("1 Bronze").build();
	      ItemStack glas = new ItemManager(Material.LEATHER_CHESTPLATE).addLeatherColor(Color.BLUE).setDisplayName("§3§lLeder-Chestplate").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §72 §cBronze").setExtra("2 Bronze").build();
	      ItemStack endstone = new ItemManager(Material.LEATHER_LEGGINGS).addLeatherColor(Color.BLUE).setDisplayName("§3§lLeder-Hose").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §72 §cBronze").setExtra("2 Bronze").build();
	      ItemStack seelaterne = new ItemManager(Material.LEATHER_BOOTS).addLeatherColor(Color.BLUE).setDisplayName("§3§lLeder-Schuhe").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §71 §cBronze").setExtra("1 Bronze").build();
	      inv.setItem(18, sandstein);
	      inv.setItem(19, glas);
	      inv.setItem(20, endstone);
	      inv.setItem(21, seelaterne);
	    }
	    else
	    {
	      ItemStack sandstein = new ItemManager(Material.LEATHER_HELMET).addLeatherColor(Color.RED).setDisplayName("§3§lLeder-Helm").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §71 §cBronze").setExtra("1 Bronze").build();
	      ItemStack glas = new ItemManager(Material.LEATHER_CHESTPLATE).addLeatherColor(Color.RED).setDisplayName("§3§lLeder-Chestplate").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §72 §cBronze").setExtra("2 Bronze").build();
	      ItemStack endstone = new ItemManager(Material.LEATHER_LEGGINGS).addLeatherColor(Color.RED).setDisplayName("§3§lLeder-Hose").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §72 §cBronze").setExtra("2 Bronze").build();
	      ItemStack seelaterne = new ItemManager(Material.LEATHER_BOOTS).addLeatherColor(Color.RED).setDisplayName("§3§lLeder-Schuhe").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §71 §cBronze").setExtra("1 Bronze").build();
	      inv.setItem(18, sandstein);
	      inv.setItem(19, glas);
	      inv.setItem(20, endstone);
	      inv.setItem(21, seelaterne);
	    }
	    ItemStack lv1 = new ItemManager(Material.CHAINMAIL_CHESTPLATE).setDisplayName("§3§lChestplate LV. 1").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addLoreLine("§8> §71 §7Eisen").setExtra("1 Eisen").build();
	    ItemStack lv2 = new ItemManager(Material.CHAINMAIL_CHESTPLATE).setDisplayName("§3§lChestplate LV. 2").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).addLoreLine("§8> §73 §7Eisen").setExtra("3 Eisen").build();
	    ItemStack lv3 = new ItemManager(Material.CHAINMAIL_CHESTPLATE).setDisplayName("§3§lChestplate LV. 3").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addLoreLine("§8> §75 §7Eisen").setExtra("5 Eisen").build();
	    ItemStack lv4 = new ItemManager(Material.CHAINMAIL_CHESTPLATE).setDisplayName("§3§lChestplate LV. 4").setAmount(1).addEnchantment(Enchantment.DURABILITY, 1).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).addLoreLine("§8> §77 §7Eisen").setExtra("7 Eisen").build();
	    
	    inv.setItem(23, lv1);
	    inv.setItem(24, lv2);
	    inv.setItem(25, lv3);
	    inv.setItem(26, lv4);
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openSpitzhackenShop()
	  {
	    Inventory inv = getMainShop("Spitzhacken");
	    
	    inv.setItem(21, new ItemManager(Material.WOOD_PICKAXE).setDisplayName("§3§lSpitzhacke LV. 1").setAmount(1).addLoreLine("§8> §78 §cBronze").setExtra("8 Bronze").build());
	    inv.setItem(22, new ItemManager(Material.STONE_PICKAXE).setDisplayName("§3§lSpitzhacke LV. 2").setAmount(1).addLoreLine("§8> §72 §7Eisen").setExtra("2 Eisen").build());
	    inv.setItem(23, new ItemManager(Material.IRON_PICKAXE).setDisplayName("§3§lSpitzhacke LV. 3").setAmount(1).addLoreLine("§8> §71 §6Gold").setExtra("1 Gold").build());
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openSchwerterShop()
	  {
	    Inventory inv = getMainShop("Schwerter");
	    
	    inv.setItem(19, new ItemManager(Material.STICK).setDisplayName("§3§lKnockStick").addEnchantment(Enchantment.KNOCKBACK, 1).setAmount(1).addLoreLine("§8> §77 §cBronze").setExtra("7 Bronze").build());
	    
	    inv.setItem(22, new ItemManager(Material.WOOD_SWORD).setDisplayName("§3§lSchwert LV. 1").addEnchantment(Enchantment.DURABILITY, 1).setAmount(1).addLoreLine("§8> §71 §7Eisen").setExtra("1 Eisen").build());
	    inv.setItem(23, new ItemManager(Material.WOOD_SWORD).setDisplayName("§3§lSchwert LV. 2").addEnchantment(Enchantment.DURABILITY, 1).addEnchantment(Enchantment.DAMAGE_ALL, 1).setAmount(1).addLoreLine("§8> §73 §7Eisen").setExtra("3 Eisen").build());
	    inv.setItem(24, new ItemManager(Material.WOOD_SWORD).setDisplayName("§3§lSchwert LV. 3").addEnchantment(Enchantment.DURABILITY, 1).addEnchantment(Enchantment.DAMAGE_ALL, 2).setAmount(1).addLoreLine("§8> §75 §7Eisen").setExtra("5 Eisen").build());
	    inv.setItem(25, new ItemManager(Material.STONE_SWORD).setDisplayName("§3§lSchwert LV. 4").addEnchantment(Enchantment.DURABILITY, 1).addEnchantment(Enchantment.DAMAGE_ALL, 3).setAmount(1).addLoreLine("§8> §77 §7Eisen").setExtra("7 Eisen").build());
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openBögenShop()
	  {
	    Inventory inv = getMainShop("Bögen");
	    
	    inv.setItem(19, new ItemManager(Material.BOW).setDisplayName("§3§lBogen LV. 1").addEnchantment(Enchantment.ARROW_INFINITE, 1).setAmount(1).addLoreLine("§8> §73 §6Gold").setExtra("3 Gold").build());
	    inv.setItem(20, new ItemManager(Material.BOW).setDisplayName("§3§lBogen LV. 2").addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 1).setAmount(1).addLoreLine("§8> §76 §6Gold").setExtra("6 Gold").build());
	    inv.setItem(21, new ItemManager(Material.BOW).setDisplayName("§3§lBogen LV. 3").addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 2).setAmount(1).addLoreLine("§8> §78 §6Gold").setExtra("8 Gold").build());
	    inv.setItem(22, new ItemManager(Material.BOW).setDisplayName("§3§lBogen LV. 4").addEnchantment(Enchantment.ARROW_INFINITE, 1).addEnchantment(Enchantment.ARROW_DAMAGE, 3).setAmount(1).addLoreLine("§8> §712 §6Gold").setExtra("12 Gold").build());
	    
	    inv.setItem(24, new ItemManager(Material.ARROW).setDisplayName("§3§lPfeil").setAmount(1).addLoreLine("§8> §71 §6Gold").setExtra("1 Gold").build());
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openEssenShop()
	  {
	    Inventory inv = getMainShop("Essen");
	    
	    inv.setItem(20, new ItemManager(Material.APPLE).setAmount(2).setDisplayName("§3§lÄpfel").addLoreLine("§8> §72 §cBronze").setExtra("2 Bronze").build());
	    inv.setItem(21, new ItemManager(Material.COOKED_BEEF).setAmount(2).setDisplayName("§3§lSteaks").addLoreLine("§8> §74 §cBronze").setExtra("4 Bronze").build());
	    inv.setItem(22, new ItemManager(Material.getMaterial(320)).setAmount(2).setDisplayName("§3§lSchweinefillet").addLoreLine("§8> §74 §cBronze").setExtra("4 Bronze").build());
	    inv.setItem(23, new ItemManager(Material.GOLDEN_APPLE).setAmount(1).setDisplayName("§3§lGoldene-§pfel").addLoreLine("§8>> §72 §7Eisen").setExtra("2 Eisen").build());
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openTruhenShop()
	  {
	    Inventory inv = getMainShop("Truhen");
	    
	    inv.setItem(21, new ItemManager(Material.CHEST).setAmount(1).setDisplayName("§3§lTruhe").addLoreLine("§8> §71 §7Eisen").setExtra("1 Eisen").build());
	    inv.setItem(22, new ItemManager(Material.ENDER_CHEST).setAmount(1).setDisplayName("§3§lTeam-Truhe").addLoreLine("§8> §71 §6Gold").setExtra("1 Gold").build());
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  public void openTränkeShop()
	  {
	    Inventory inv = getMainShop("Tränke");
	    
	    inv.setItem(19, new ItemManager(Material.POTION, (short)8194).setAmount(1).setDisplayName("§3§lSchnelligkeits-Trank").addLoreLine("§8> §77 §7Eisen").setExtra("7 Eisen").build());
	    
	    inv.setItem(21, new ItemManager(Material.POTION, (short)8261).setAmount(1).setDisplayName("§3§lDirektheilung 1").addLoreLine("§8> §73 §7Eisen").setExtra("3 Eisen").build());
	    inv.setItem(22, new ItemManager(Material.POTION, (short)8229).setAmount(1).setDisplayName("§3§lDirektheilung 2").addLoreLine("§8> §75 §7Eisen").setExtra("5 Eisen").build());
	    
	    inv.setItem(24, new ItemManager(Material.POTION, (short)8270).setAmount(1).setDisplayName("§3§lUnsichtbarkeitstrank").addLoreLine("§8> §77 §7Eisen").setExtra("7 Eisen").build());
	    inv.setItem(25, new ItemManager(Material.POTION, (short)8201).setAmount(1).setDisplayName("§3§lStärke-Trank").addLoreLine("§8> §73 §6Gold").setExtra("3 Gold").build());
	    
	    this.p.openInventory(inv);
	    this.p.updateInventory();
	    this.p.playSound(this.p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
	  }
	  
	  private Inventory getMainShop(String name)
	  {
	    Inventory inv = Bukkit.createInventory(null, 36, "§8> §c§lShop-" + name + " §8<");
	    
	    ItemStack Glass = new ItemManager(Material.STAINED_GLASS_PANE, (short)7).setDisplayName("  ").build();
	    
	    ItemStack Blöcke = new ItemManager(Material.SANDSTONE).setDisplayName("§e§lBlöcke").build();
	    ItemStack Rüstungen = new ItemManager(Material.CHAINMAIL_CHESTPLATE).setDisplayName("§e§lRüstungen").build();
	    ItemStack Spitzhacken = new ItemManager(Material.STONE_PICKAXE).setDisplayName("§e§lSpitzhacken").build();
	    ItemStack Schwerter = new ItemManager(Material.WOOD_SWORD).setDisplayName("§e§lSchwerter").build();
	    ItemStack Bögen = new ItemManager(Material.BOW).setDisplayName("§e§lBögen").build();
	    ItemStack Essen = new ItemManager(Material.COOKED_BEEF).setDisplayName("§e§lEssen").build();
	    ItemStack Truhen = new ItemManager(Material.CHEST).setDisplayName("§e§lTruhen").build();
	    ItemStack Tränke = new ItemManager(Material.GLASS_BOTTLE).setDisplayName("§e§lTränke").build();
	    ItemStack Extras = new ItemManager(Material.GHAST_TEAR).setDisplayName("§e§lExtras").build();
	    for (int i = 0; i < 36; i++) {
	      switch (i)
	      {
	      case 0: 
	        inv.setItem(i, Blöcke);
	        break;
	      case 1: 
	        inv.setItem(i, Rüstungen);
	        break;
	      case 2: 
	        inv.setItem(i, Spitzhacken);
	        break;
	      case 3: 
	        inv.setItem(i, Schwerter);
	        break;
	      case 4: 
	        inv.setItem(i, Bögen);
	        break;
	      case 5: 
	        inv.setItem(i, Essen);
	        break;
	      case 6: 
	        inv.setItem(i, Truhen);
	        break;
	      case 7: 
	        inv.setItem(i, Tränke);
	        break;
	      case 8: 
	        inv.setItem(i, Extras);
	        break;
	      default: 
	        inv.setItem(i, Glass);
	      }
	    }
	    return inv;
	  }
	}
