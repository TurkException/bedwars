package de.bedwars.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.bedwars.Bedwars;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.LocationManager;

public class Death implements Listener {
	public static String deathspawn;
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		e.setDeathMessage(null);

		org.bukkit.entity.Player p = e.getEntity();
		org.bukkit.entity.Player t = p.getKiller();
		e.getDrops().clear();
		
        Bukkit.getScheduler().scheduleSyncDelayedTask(Bedwars.o, new Runnable()
        {
          public void run()
          {
		  p.spigot().respawn();
		  p.getInventory();
			if(BedwarsManager.Blau.contains(p)) {
			p.teleport(LocationManager.getLocation("blau"));
			 p.getInventory();
			}else if(BedwarsManager.Rot.contains(p)){
				
				 p.getInventory();
				 p.teleport(LocationManager.getLocation("rot"));
			}else {
				 p.getInventory();
				
			p.teleport(LocationManager.getLocation("Lobby"));
			}
          }
        }, 1*1);
		
			if(t == null) {
				BedwarsManager.cdpahse = false;
				Bukkit.broadcastMessage(Bedwars.Prefix + "§7Der Spieler §a" + p.getDisplayName() + " §7ist gestorben.");
				if(BedwarsManager.Rot.contains(p)) {
					deathspawn = "rot";
					if(BedwarsManager.rotbed == false) {
						
						BedwarsManager.rotlive = 0;
					

						
						BedwarsManager.end(BedwarsManager.Blau.get(0));
					}
					
				}else {
					deathspawn = "blau";
					if(BedwarsManager.blaubed == false) {
						
						BedwarsManager.blaulive = 0;
					
						BedwarsManager.end(BedwarsManager.Rot.get(0));
					}
				}
				if(!BedwarsManager.Spec.contains(p)) {
					p.teleport(LocationManager.getLocation(deathspawn));
				}
			}else {
				Bukkit.broadcastMessage(Bedwars.Prefix + "§7Der Spieler §a" + t.getDisplayName() + " §7hat den Spieler §a" + p.getDisplayName() + " §7getötet.");
				if(BedwarsManager.Rot.contains(p)) {
					deathspawn = "rot";
					if(BedwarsManager.rotbed == false) {
						
						BedwarsManager.rotlive = 0;
					
						BedwarsManager.end(t);
					}
					
				}else {
					deathspawn = "blau";
					if(BedwarsManager.blaubed == false) {
						
						BedwarsManager.blaulive = 0;
					
						BedwarsManager.end(t);
					}
				}
				if(!BedwarsManager.Spec.contains(p)) {
					p.teleport(LocationManager.getLocation(deathspawn));
				}
				
			}
		
		
	}
}
