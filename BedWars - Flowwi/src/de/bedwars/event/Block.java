package de.bedwars.event;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import de.bedwars.util.BedwarsManager;


public class Block implements Listener {

	  private static final List<Location> locations = new CopyOnWriteArrayList<>();

	    public static void reset() {
	    	

	        AtomicInteger blocks = new AtomicInteger();

	        locations.forEach(block -> {
	            block.getBlock().setType(Material.AIR);
	            blocks.getAndIncrement();
	        });

	      
	        locations.clear();
	    }
	    @EventHandler
	    public void onPlace(final BlockPlaceEvent e) {
		  
		

	    	if(BedwarsManager.lobby == true) {
	    		e.setCancelled(true);	
		    	}
	    	
		        	
		               
	                locations.add(e.getBlock().getLocation());
	                e.getBlock().getDrops().clear();
	        
	            
	        
	    
			
	        
	        
	        
	    }
	    @EventHandler
	    public void onBlockBreak(BlockBreakEvent e) {
	    	if(BedwarsManager.lobby == true) {
	    	
	    	e.setCancelled(true);
	    	}
	    if(e.getBlock().getType() == Material.SANDSTONE || (e.getBlock().getType() == Material.GLASS) || (e.getBlock().getType() == Material.CHEST) || (e.getBlock().getType() == Material.ENDER_STONE|| (e.getBlock().getType() == Material.SEA_LANTERN))) {
	    

	    	}else {
	    		e.setCancelled(true);
	    	}
	    	}
}
