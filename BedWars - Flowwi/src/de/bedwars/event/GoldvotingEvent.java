package de.bedwars.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.bedwars.Bedwars;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.ItemManager;

public class GoldvotingEvent implements Listener {
	public static ArrayList<Player> Goldvoter = new ArrayList();
	public static ArrayList<Player> agree = new ArrayList();
	public static ArrayList<Player> denied = new ArrayList();
	@EventHandler
	public void onShop(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if ((e.getCurrentItem().getItemMeta().hasLore()) && 
		        (ItemManager.extra.containsKey(e.getCurrentItem().getItemMeta().getDisplayName())))
		      {
		        ItemStack is = e.getCurrentItem();
		        ItemMeta meta = is.getItemMeta();
		        List<String> lor = meta.getLore();
		        meta.setLore(null);
		        is.setItemMeta(meta);
		        
		        String lore = (String)ItemManager.extra.get(e.getCurrentItem().getItemMeta().getDisplayName());
		        String[] lores = lore.split(" ");
		        if (lores[1].equalsIgnoreCase("Bronze")) {
//		        	if(!e.isShiftClick()) {
		          BedwarsManager.buy(p, is, Material.CLAY_BRICK, Integer.decode(lores[0]).intValue(), e.isShiftClick());
//		        	}else {
//		        		try {
//		        		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lSandstein")) {
//		        		for (int i = 0; i < 16; i++) {
//		        	
//		        	
//		        				  BedwarsManager.buy(p, is, Material.CLAY_BRICK, Integer.decode(lores[0]).intValue());
//		        			}
//		        	
//		        		}
//		         		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lGlas")) {
//			        		for (int i = 0; i < 32; i++) {
//			        	
//			        	
//			        				  BedwarsManager.buy(p, is, Material.CLAY_BRICK, Integer.decode(lores[0]).intValue());
//			        			}
//			        	
//			        		}
//		         		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lEndstein")) {
//			        		for (int i = 0; i < 64; i++) {
//			        	
//			        	
//			        				  BedwarsManager.buy(p, is, Material.CLAY_BRICK, Integer.decode(lores[0]).intValue());
//			        			}
//			        	
//			        		}
//		         		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lSeelaterne")) {
//			        		for (int i = 0; i < 64; i++) {
//			        	
//			        	
//			        				  BedwarsManager.buy(p, is, Material.CLAY_BRICK, Integer.decode(lores[0]).intValue());
//			        			}
//			        	
//			        		}
//		        	}catch (Exception exception) {
//						// TODO: handle exception
//					}
//		        	}
		        } 
		        
		        else if (lores[1].equalsIgnoreCase("Eisen")) {
		        	BedwarsManager.buy(p, is, Material.IRON_INGOT, Integer.decode(lores[0]).intValue(), e.isShiftClick());
		        } else if (lores[1].equalsIgnoreCase("Gold")) {
		        	BedwarsManager.buy(p, is, Material.GOLD_INGOT, Integer.decode(lores[0]).intValue(), e.isShiftClick());
		        }
		        meta.setLore(lor);
		        is.setItemMeta(meta);
		      
		    
		  }
		
		  
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		try {
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				
		        {
				if(p.getInventory().getItemInHand().getType() == Material.EMERALD) {
					if(	e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eGoldvoting")) {
						
						if(Goldvoter.contains(p)) {
						
							p.sendMessage(Bedwars.Prefix + "§cDu hast bereits schon abgestimmt.");
						}else {
						openGoldvoting(p);
						}
					}
					
				}
		        }
			
		}catch (Exception exception) {
			// TODO: handle exception
		}
	}
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		if(BedwarsManager.lobby == true) {
			e.setCancelled(true);
		}else {
			
			
		}
		try {
			
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAktivieren")) {
			p.sendMessage(Bedwars.Prefix + "§7Du hast erfolgreich für §aJa§7 entschieden");
			BedwarsManager.goldagree =+ 1;
			p.closeInventory();
			agree.add(p);
			Goldvoter.add(p);
		
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cDeaktivieren")) {
			p.sendMessage(Bedwars.Prefix + "§7Du hast erfolgreich für §4Nein§7 entschieden");
			BedwarsManager.golddenied =+ 1;
			p.closeInventory();
			denied.add(p);
			Goldvoter.add(p);
		
		}
			
		}catch (Exception exception) {
			// TODO: handle exception
		}
		
		
	}
	public static void openGoldvoting(Player p) {
    final Inventory inv = Bukkit.createInventory(null, 27, "§eGold");
	    
        ItemStack limeDye = new ItemStack(Material.INK_SACK, 1, (byte) 10);
		ItemMeta aa = limeDye.getItemMeta();
		aa.setDisplayName("§aAktivieren");
		limeDye.setItemMeta(aa);
		
		
		ItemStack graydye = new ItemStack(Material.INK_SACK, 1, DyeColor.SILVER.getData());
		ItemMeta aaa = graydye.getItemMeta();
		aaa.setDisplayName("§cDeaktivieren");
		
		graydye.setItemMeta(aaa);
		inv.setItem(11, graydye);
		inv.setItem(15, limeDye);
		
		p.openInventory(inv);
		
		
	}

}
