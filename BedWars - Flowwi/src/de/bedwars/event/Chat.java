package de.bedwars.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.bedwars.util.BedwarsManager;

public class Chat implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		org.bukkit.entity.Player p = e.getPlayer();
		
		
		if(BedwarsManager.Rot.contains(p)) {
			e.setFormat("§7[§4Rot§7] §4" + p.getName() + " §7» " + e.getMessage());
		}else if(BedwarsManager.Blau.contains(p)) {
			e.setFormat("§7[§9Blau§7] §9" + p.getName() + " §7» " + e.getMessage());
		}
		
	}

}
