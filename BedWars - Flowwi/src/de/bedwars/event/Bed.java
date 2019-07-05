package de.bedwars.event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import de.bedwars.Bedwars;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.ItemActionbarManager;
import de.bedwars.util.Sidebar;

public class Bed implements Listener {

	public static String bedname;
	@EventHandler
	public void onBreakRed(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getType() == Material.BED_BLOCK) {

			if(e.getBlock().getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.REDSTONE_BLOCK) {
				if(BedwarsManager.Blau.contains(p)) {
					if(BedwarsManager.rotbed == false) {
						e.setCancelled(true);
						p.sendMessage(Bedwars.Prefix + "§cDas Bett wurde bereits abgebaut!");
					}else {
						BedwarsManager.rotbed = false;
						bedname = "§4Rot";
						for(Player all : Bukkit.getOnlinePlayers()) {
							ItemActionbarManager.sendFullTitle(all, 5, 5, 5, "§7Das Bett von Team " + bedname, "§7wurde zerstört");
							Sidebar.setScoreboard(all);
						
						
						}
						e.setCancelled(true);
					}
					
				}else {
					e.setCancelled(true);
					p.sendMessage(Bedwars.Prefix + "§cDu darfst dein eigenes Bett nicht abbauen!");
				}
			}
		}
	}
	@EventHandler
	public void onBreakRBlau(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getType() == Material.BED_BLOCK) {

			if(e.getBlock().getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.LAPIS_BLOCK) {
				if(BedwarsManager.Rot.contains(p)) {
					if(BedwarsManager.blaubed == false) {
						p.sendMessage(Bedwars.Prefix + "§cDas Bett wurde bereits abgebaut!");
						e.setCancelled(true);
					}else {
						BedwarsManager.blaubed = false;
						bedname = "§9Blau";
						for(Player all : Bukkit.getOnlinePlayers()) {
							ItemActionbarManager.sendFullTitle(all, 5, 5, 5, "§7Das Bett von Team " + bedname, "§7wurde zerstört");
							Sidebar.setScoreboard(all);
						}
						e.setCancelled(true);
					}
					
				}else {
					e.setCancelled(true);
					p.sendMessage(Bedwars.Prefix + "§cDu darfst dein eigenes Bett nicht abbauen!");
				}
			}
		}
	}
	@EventHandler
	public void onBlock(BlockBreakEvent e) {
		if(BedwarsManager.lobby == true) {
			e.setCancelled(true);
		}
	}
//	@EventHandler
//	public void onBreakBed(BlockBreakEvent e) {
//		Player p = (Player)e.getPlayer();
// if (e.getBlock().getType() == Material.BED_BLOCK) {
//
//	
//			 
//			 e.setCancelled(true);
//             if (e.getBlock().getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.LAPIS_BLOCK) {
//            	 if(BedwarsManager.Rot.contains(p)) {
//            		 for(org.bukkit.entity.Player all : Bukkit.getOnlinePlayers()) {
//            			 bedname = "§9Blau";
//       
//            			 if(!BedwarsManager.blaubed == false) {
//            			 ItemActionbarManager.sendFullTitle(all, 5, 5, 5, "§7Das Bett von Team " + bedname, "§7wurde zerstört");
//            			 BedwarsManager.blaubed = false;
//            		
//          			        	for(Player all2 : Bukkit.getOnlinePlayers()) {
//
//          			        		Sidebar.setScoreboard(all);
//          			     
//            			 }
//            		 }else {
//        				 e.getPlayer().sendMessage(Bedwars.Prefix + "§cDas Bett wurde bereits abgebaut!");
//        			 }
//            	 }
//            	 
//             }else {
//        		 e.setCancelled(true);
//        	 }
//             
//             } if (e.getBlock().getLocation().subtract(0D, 1D, 0D).getBlock().getType() == Material.REDSTONE_BLOCK) {
//            	 if(BedwarsManager.Blau.contains(p)) {
//            		 for(org.bukkit.entity.Player all : Bukkit.getOnlinePlayers()) {
//            			 bedname = "§4Rot";
//       
//            			 if(!BedwarsManager.rotbed == false) {
//            			 ItemActionbarManager.sendFullTitle(all, 5, 5, 5, "§7Das Bett von Team " + bedname, "§7wurde zerstört");
//            			 BedwarsManager.rotbed = false;
//            			 
//          			        	for(Player all1 : Bukkit.getOnlinePlayers()) {
//
//          			        		Sidebar.setScoreboard(all);
//          			        	}          			
//            			 }else {
//            				 e.getPlayer().sendMessage(Bedwars.Prefix + "§cDas Bett wurde bereits abgebaut!");
//            			 }
//            		 }
//            	 }else {
//            		 e.setCancelled(true);
//            	 }
//            	 
//             }
// }
//	}
//}
}
