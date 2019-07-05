package de.bedwars.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.bedwars.Bedwars;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.LocationManager;

public class Respawn implements Listener {

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		
   	    
    	  Bukkit.getScheduler().runTaskLaterAsynchronously(Bedwars.o, new Runnable()
        {
          public void run()
          {
		if(BedwarsManager.Blau.contains(e.getPlayer())) {
			e.getPlayer().teleport(LocationManager.getLocation("blau"));
		}else if(BedwarsManager.Rot.contains(e.getPlayer())){
			e.getPlayer().teleport(LocationManager.getLocation("rot"));
		}else if(BedwarsManager.Spec.contains(e.getPlayer())){

				e.getPlayer().teleport(LocationManager.getLocation("Lobby"));
		}else {

			e.getPlayer().sendMessage("");
			e.getPlayer().sendMessage(Bedwars.Prefix + "§cTeleportation Error: kein Team");
			e.getPlayer().sendMessage("");
		}
		e.getPlayer().getInventory().clear();
	
          
          }
        }, 5L);
	}

}
