package de.bedwars.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.bedwars.util.BedwarsManager;
import de.bedwars.util.LocationManager;


public class Move implements Listener {

	@EventHandler
    public void onMove(PlayerMoveEvent e) {
    	Player p = e.getPlayer();
    	 if ((p.getLocation().getBlockY() < de.bedwars.util.LocationManager.getHeight("höhe")))
    		    {
    		 if(BedwarsManager.lobby == false) {
    		 if(!p.isDead() && !(p.getHealth() <= 0.0D)) {
    			 
    			 
    	
    		   p.setHealth(0);
    			 
    		 	}
    		 
    		  
    		    }else {
    		    	p.teleport(LocationManager.getLocation("Lobby"));
    		    }
    		    }
    		 
    	 
    		 
    }

}
