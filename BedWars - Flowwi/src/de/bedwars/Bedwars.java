package de.bedwars;

import org.bukkit.plugin.java.JavaPlugin;

import de.bedwars.cmd.CMD_start;
import de.bedwars.cmd.CMD_set;
import de.bedwars.event.Bed;
import de.bedwars.event.Block;
import de.bedwars.event.Chat;
import de.bedwars.event.Damage;
import de.bedwars.event.Death;
import de.bedwars.event.GoldvotingEvent;
import de.bedwars.event.Join;
import de.bedwars.event.Mob;
import de.bedwars.event.Move;
import de.bedwars.event.Player;
import de.bedwars.event.Quit;
import de.bedwars.event.Respawn;
import de.bedwars.event.ShopEvent;
import de.bedwars.util.BedwarsManager;
import de.bedwars.util.LocationManager;

public class Bedwars extends JavaPlugin{
	public static String Prefix = "§8» §4BedWars §8| §7";
	public static Bedwars o;
	
	@Override
	public void onEnable() {
		load();
		
	}
	@Override
	public void onDisable() {

	}
	public void load() {
		o = this;
		BedwarsManager.lobby = true;
		getCommand("set").setExecutor(new CMD_set());
		getCommand("start").setExecutor(new CMD_start());
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Quit(), this);
		getServer().getPluginManager().registerEvents(new Block(), this);
		getServer().getPluginManager().registerEvents(new Player(), this);
		getServer().getPluginManager().registerEvents(new Bed(), this);
		getServer().getPluginManager().registerEvents(new Death(), this);
		getServer().getPluginManager().registerEvents(new Move(), this);
		getServer().getPluginManager().registerEvents(new ShopEvent(), this);
		getServer().getPluginManager().registerEvents(new Damage(), this);
		getServer().getPluginManager().registerEvents(new ShopEvent(), this);
		getServer().getPluginManager().registerEvents(new GoldvotingEvent(), this);
		getServer().getPluginManager().registerEvents(new Respawn(), this);
		getServer().getPluginManager().registerEvents(new Chat(), this);
		getServer().getPluginManager().registerEvents(new Mob(), this);
		
	
		LocationManager.setupFiles();
	}

}
