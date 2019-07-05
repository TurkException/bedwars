package de.bedwars.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.bedwars.Bedwars;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.Sidebar;


public class Quit implements Listener {
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		Player p = e.getPlayer();
		BedwarsManager.Rot.remove(p);
		BedwarsManager.Blau.remove(p);
		if(GoldvotingEvent.denied.contains(p)) {
			GoldvotingEvent.denied.remove(p);
			BedwarsManager.golddenied =-1;
		}
		if(GoldvotingEvent.agree.contains(p)) {
			GoldvotingEvent.agree.remove(p);
			BedwarsManager.goldagree =-1;
		}

	    if(BedwarsManager.lobby == true) {

//	    	BedwarsManager.cd = 100000000;
	   BedwarsManager.stopStart(); 	
	
		    Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
		      {
		        public void run()
		        {
		        	for(Player all : Bukkit.getOnlinePlayers()) {

		        		all.setLevel(0);
		        
		            	all.sendMessage(Bedwars.Prefix + "§aDer Countdown wurde unterbochen da ein Spieler rausgegangen ist");
		            	if(BedwarsManager.Rot.contains(p)) {
		            		BedwarsManager.rotbed = false;
		            		Sidebar.setScoreboard(all);
		            	}else if(BedwarsManager.Blau.contains(p)) {
		            		BedwarsManager.blaubed = false;
		            		Sidebar.setScoreboard(all);
		            	}
		          	    Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
					      {
					        public void run()
					        {
					        	for(Player all1 : Bukkit.getOnlinePlayers()) {

					        		Sidebar.setScoreboard(all1);
					        }
					        }
					      }, 15L);
		        }
		        }
		      }, 15L);
	    	
	    }else {
	    	if(BedwarsManager.Spec.contains(p)) {
	    		
	    	}else {
	    	   
	    	   
	    		if(BedwarsManager.Rot.contains(p)) {
	    			 Player blau = BedwarsManager.Blau.get(0);
	    			Bukkit.broadcastMessage(Bedwars.Prefix + "§aDer Spieler §9" + blau.getName() + " §ahat gewonnen!");
	    		}else if(BedwarsManager.Blau.contains(p)) {
	    			 Player rot = BedwarsManager.Rot.get(0);
	    			Bukkit.broadcastMessage(Bedwars.Prefix + "§aDer Spieler §4" + rot.getName() + " §ahat gewonnen!");
	    		}
	    	
	    		Bukkit.broadcastMessage("§aDer Server startet im 3 Sekunden neu, da ein Spieler verlassen hat!");
	    		BedwarsManager.stopBronze();
	    		BedwarsManager.stopGold();
	    		BedwarsManager.stopIron();
	    	    Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
			      {
			        public void run()
			        {
			        	for(Player all : Bukkit.getOnlinePlayers()) {

			        		Sidebar.setScoreboard(all);
			        }
			        }
			      }, 15L);
	    		  Bukkit.getScheduler().runTaskLaterAsynchronously(Bedwars.o, new Runnable()
	              {
	                public void run()
	                {
	                	Bukkit.shutdown();
	                	
	                }
	              }, 60L);
	    	
	    	}
	    }
	}

}
