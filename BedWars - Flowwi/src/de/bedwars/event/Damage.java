package de.bedwars.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.bedwars.util.BedwarsManager;

public class Damage implements Listener {
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(BedwarsManager.lobby == true) {
			e.setCancelled(true);
		}else if(BedwarsManager.end == true) {
			e.setCancelled(true);
			
		}else {
			
		}
	}

}
