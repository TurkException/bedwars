package de.bedwars.event;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.bedwars.Bedwars;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.ItemActionbarManager;
import de.bedwars.util.LocationManager;
import de.bedwars.util.Sidebar;

public class Join implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		p.setGameMode(GameMode.SURVIVAL);
		p.setHealth(20);
		p.setFoodLevel(20);
		p.getInventory().clear();
		World w = p.getWorld();
		w.setTime(1200);
		if(BedwarsManager.lobby = true) {
		p.getInventory().setItem(4, ItemActionbarManager.createItem(Material.EMERALD, 1, 0, "§eGoldvoting"));
		p.teleport(LocationManager.getLocation("Lobby"));
		if(!p.hasPlayedBefore() ) {
			p.teleport(LocationManager.getLocation("Lobby"));
			p.teleport(LocationManager.getLocation("Lobby"));
		}else {
			
		}
		BedwarsManager.start();
		 for(Player all : Bukkit.getOnlinePlayers()) {
			  
		     
		        Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
			      {
			        public void run()
			        {
			        	 if (BedwarsManager.Rot.size() == 0)
			              {


			        		 if(BedwarsManager.Blau.contains(p)) {
			        			 
			        		 }else {
			        			 BedwarsManager.Rot.add(p);

				        			BedwarsManager.rotbed = true;
			        		 }

			              }
			            
			        	
			        }
			      }, 10L);
			    }
			    
			    Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
			      {
			        public void run()
			        {
			        	if (BedwarsManager.Blau.size() == 0)
		            {
			        		if(BedwarsManager.Rot.contains(p)) {
			        			
			        		}else {
			        
			        			BedwarsManager.Blau.add(p);
		     
			        			BedwarsManager.blaubed = true;
		   
			        		

			        		}  
		            }
			        }
			      }, 10L);
			    Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
			      {
			        public void run()
			        {
		

			        		for(Player all2 : Bukkit.getOnlinePlayers()) {
        						Sidebar.setScoreboard(all2);
        						}
			        
			        }
			      }, 15L);
		   	 
	}else {
		
		BedwarsManager.Spec.add(p);
		p.setGameMode(GameMode.SPECTATOR);
		Bukkit.broadcastMessage(Bedwars.Prefix +  "§7Der Spieler " + e.getPlayer().getDisplayName() + " §7schaut nun zu! ");
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(!BedwarsManager.Spec.contains(all)) {
				all.hidePlayer(p);
				
			}
		}
	}
	}

}
