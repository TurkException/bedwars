package de.bedwars.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import de.bedwars.util.BedwarsManager;

public class Player implements Listener {
	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if(BedwarsManager.lobby == true) {
		e.setCancelled(true);
		}else {
			
		}
	}
	@EventHandler
	public void onPickUP(PlayerPickupItemEvent e) {
		if(BedwarsManager.lobby == true) {
			e.setCancelled(true);
		}else {
			
		}
	}

}
