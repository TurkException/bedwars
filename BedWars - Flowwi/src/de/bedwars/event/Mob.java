package de.bedwars.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Mob implements Listener {
	@EventHandler
	public void onMob(CreatureSpawnEvent e) {
		e.setCancelled(true);
	}

}
