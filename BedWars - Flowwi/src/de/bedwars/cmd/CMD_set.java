package de.bedwars.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.bedwars.Bedwars;
import de.bedwars.util.LocationManager;

public class CMD_set implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {

		Player p = (Player)arg0;
		if(arg3.length == 0) {
			
			
			p.sendMessage(Bedwars.Prefix + "§7/set rot ");
			p.sendMessage(Bedwars.Prefix + "§7/set blau ");
			p.sendMessage(Bedwars.Prefix + "§7/set gold ");
			p.sendMessage(Bedwars.Prefix + "§7/set bronze ");
			p.sendMessage(Bedwars.Prefix + "§7/set eisen ");
			p.sendMessage(Bedwars.Prefix + "§7/set bronze2 ");
			p.sendMessage(Bedwars.Prefix + "§7/set eisen2 ");
			p.sendMessage(Bedwars.Prefix + "§7/set lobby ");
			p.sendMessage(Bedwars.Prefix + "§7/set höhe ");
		}else if(arg3[0].equalsIgnoreCase("rot")) {
			LocationManager.setLocation(p, "rot");
		}else if(arg3[0].equalsIgnoreCase("blau")) {
			LocationManager.setLocation(p, "blau");
		}else if(arg3[0].equalsIgnoreCase("gold")) {
			LocationManager.setLocation(p, "Gold");
		}else if(arg3[0].equalsIgnoreCase("bronze")) {
			LocationManager.setLocation(p, "Bronze");
		}else if(arg3[0].equalsIgnoreCase("eisen")) {
			LocationManager.setLocation(p, "Eisen");
		}else if(arg3[0].equalsIgnoreCase("bronze2")) {
			LocationManager.setLocation(p, "Bronze2");
		}else if(arg3[0].equalsIgnoreCase("eisen2")) {
			LocationManager.setLocation(p, "Eisen2");
		}else if(arg3[0].equalsIgnoreCase("lobby")) {
			LocationManager.setLocation(p, "Lobby");
		}else if(arg3[0].equalsIgnoreCase("höhe")) {
			LocationManager.setHeight(p, "höhe");
		}
		return false;
	}

}
