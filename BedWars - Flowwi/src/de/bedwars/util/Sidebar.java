package de.bedwars.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;





public class Sidebar {
	 public static void setScoreboard(Player p)
	  {
		   Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
			  Objective o1 = board.registerNewObjective("board", "dummy");
			    o1.setDisplayName("§f§lFAIRMC.NET");
			    o1.setDisplaySlot(DisplaySlot.SIDEBAR);
			    
			
			    
			    Score lolre = o1.getScore("§k§l§e");
			    lolre.setScore(8);
			    
			    Score fifteen = o1.getScore("§4Rot");
			    fifteen.setScore(7);
			    if(BedwarsManager.rotbed == true) {
	
				    Score eleven = o1.getScore("§8» §a✔§a");
				    eleven.setScore(6);
			    }else {
				    Score eleven = o1.getScore("§8» §4✖ §b");
				    eleven.setScore(6);
			    }
	
			    
			    
			    Score lolrb = o1.getScore("§k§l§b");
			    lolrb.setScore(5);
			    
			  
			    Score bbbbb = o1.getScore("§9Blau");
			    bbbbb.setScore(4);
			    
			    if(BedwarsManager.blaubed == true) {

				    Score two = o1.getScore("§8» §a✔§c");
				    two.setScore(3);
			    }else {
				    Score two = o1.getScore("§8» §4✖ §n");
				    two.setScore(3);
			    }

			    
			    Score lolra = o1.getScore("§k§l§a");
			    lolra.setScore(2);
			    
			    Score one = o1.getScore("§7Hacker?");
			    one.setScore(1);
			    Score aaaa = o1.getScore("§8» §a/report");
			    aaaa.setScore(-1);
			   
			    Score lolr = o1.getScore("§k§l");
			    lolr.setScore(-2);
			    
	    

			    Team team0 = board.registerNewTeam("0000Tab0");
			    Team team1 = board.registerNewTeam("0001Tab1");
			    Team team2 = board.registerNewTeam("0002Tab2");
			    
			    for (Player targ : Bukkit.getOnlinePlayers()) {
 

			    	if (BedwarsManager.Rot.contains(targ))
				      {
				        team0.addPlayer(targ);
				        team0.setPrefix("§4Rot | ");
			    		
				      }else 	if (BedwarsManager.Blau.contains(targ))
				      {
					        team1.addPlayer(targ);
					        team1.setPrefix("§9Blau | ");
				    		
					      }else if(BedwarsManager.Spec.contains(targ)){
					    	  
					
					    		    team2.addPlayer(targ);
							        team2.setPrefix("§7Spec |");
					    	 
					      }
			    }
			    

		

		  p.setScoreboard(board);
		
	  }
	 
	
}
