package de.bedwars.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.bedwars.Bedwars;
import de.bedwars.event.Bed;
import de.bedwars.event.Player;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.ItemActionbarManager;

public class CMD_start implements CommandExecutor {

	public static boolean start;
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

		org.bukkit.entity.Player p = (org.bukkit.entity.Player)arg0;
		if(p.hasPermission("bedwars.start")) {
			if(start == false) {
				if(Bukkit.getOnlinePlayers().size() != 2) {
					p.sendMessage(BedwarsManager.Prefix +  "§cEs sind nicht genpügend Spieler anwesend");
				}else {
				start = true;
				BedwarsManager.cd = 5;
				for(org.bukkit.entity.Player all : Bukkit.getOnlinePlayers()) {
					ItemActionbarManager.sendTitle(all, 10, 10, 10, "§7Das Spiel startet ", "in §a5 Sekunden");		
				
					all.sendMessage(Bedwars.Prefix + "§7Der Spieler §a" + p.getDisplayName() + " §7hat das Spiel gestartet.");
				
				}
				}
			}else {
				p.sendMessage(Bedwars.Prefix + "§cDieser Befehl wurde bereits in der Runde verwendet!");
			}
		}else {
			p.sendMessage(Bedwars.Prefix + "§cDiesen Befehl können nur Leute ab Premium Rang nutzen!");
		}
		return false;
	}

}
