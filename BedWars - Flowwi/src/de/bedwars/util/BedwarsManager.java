package de.bedwars.util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;
import org.w3c.dom.CDATASection;

import de.bedwars.Bedwars;
import de.bedwars.event.Block;


public class BedwarsManager {
	public static String Prefix;
	public static ArrayList<Player> Rot = new ArrayList<>();
	public static ArrayList<Player> Blau = new ArrayList<>();
	public static ArrayList<Player> Spec = new ArrayList<>();
	public static int goldagree;
	public static int golddenied;
	public static boolean votegold = false;
	public static String Gold;
	public static int rotlive;
	public static int blaulive;
	public static boolean rotbed ;
	public static boolean blaubed ;
	public static boolean lobby ;
	public static boolean cd1;
	public static int cd;
	private static boolean bronzeisrunning = false;
	private static boolean ironisrunning = false;
	private static boolean goldisrunning = false;
	private static int bronzeTaskID;
	private static int startID;
	private static int ironTaskID;
	private static int goldTaskID;
	public static boolean cdpahse;
	public static boolean end;
	public static void start(){
		end = false;
		if(Bukkit.getOnlinePlayers().size() == 2) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				ItemActionbarManager.sendTitle1(all, 15, 15, 15, "Es beginnt in", "§e30 Sekunden!");
				 cd = 30;
				 cdpahse = true;
			}
			if(cdpahse == true){
				cd1 = true;
      startID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.o, new Runnable()
          {
            public void run()
            {
            	if(Bukkit.getOnlinePlayers().size() == 2) {
            		if(cdpahse == true){
            		if(cd != 0) {
            	cd -= 1;
            	for(Player all : Bukkit.getOnlinePlayers()) {
   
            		all.setLevel(cd);
            	
            		if(all.getLevel() == 0) {
            			
            			if(cd1 = true) {
           
            
            					cd1 = false;
            					ItemActionbarManager.sendTitle(all, 5, 5, 5, "Es beginnt", "§eJetzt");
            					all.getInventory().clear();
            					all.closeInventory();
            	
            					lobby = false;
            					if(Rot.contains(all)) {
            						all.teleport(LocationManager.getLocation("rot"));
  
            					}else if(Blau.contains(all)) {
            						all.teleport(LocationManager.getLocation("blau"));
            						
//            						 Bukkit.getScheduler().runTaskLaterAsynchronously(Bedwars.o, new Runnable()
//            				          {
//            				            public void run()
//            				            {
//            				    
//            				            	Sidebar.setScoreboard(all);
//            				            }
//            				          }, 5L);
            						 
            						 if(goldagree>golddenied) {
            							 votegold = true;
            							 startGold();
            							 Gold = "§aaktiviert";
            						 }else if(golddenied>goldagree) {
            							 votegold = false;
            							 Gold = "§4deaktivert";
            							 stopGold();
            						 }else if(goldagree==golddenied) {
            							 votegold = false;
            							 Gold = "§4deaktivert";
            							 stopGold();
            						 }
            					  	  Bukkit.getScheduler().runTaskTimerAsynchronously(Bedwars.o, new Runnable()
            				          {
            				            public void run()
            				            {
            				            	for(Player all1 : Bukkit.getOnlinePlayers()) {
            		
            									 ItemActionbarManager.sendActionbar(all1, "§7Gold ist " + Gold);
            										World w = all1.getWorld();
            										w.setTime(1200);
            				            	}
            						 
            		
            				            }
            				          }, 1L, 1L);
            					
            						rotlive = 1;
            						blaulive = 1;
            						startIron();
            						startBronze();
            		
            						lobby = false;
         
            				
            						
            					}
            					
            			
            				}
            		}
            	}
            	
            
             } 
            	}
            	}
            }
          }, 20L, 20L);
			}else {
				
			}
			
		}
		
	}
	public static void checkprefix(Player p) {
		if(Rot.contains(p)) {
			Prefix = "§4Rot";
		}else if(Blau.contains(p)) {
			Prefix = "§9Blau";
		}else {
			Prefix = "§7";
		}
	}
	public static void end(Player p) {

			Bukkit.broadcastMessage(Bedwars.Prefix + "§aDer Spieler §4" + p.getDisplayName() + " §ahat gewonnen!");


		Bukkit.broadcastMessage("§aDer Server startet in 3 Sekunden neu!");
		stopBronze();
		stopGold();
		stopIron();
		end = true;
		Block.reset();
		  Bukkit.getScheduler().runTaskLaterAsynchronously(Bedwars.o, new Runnable()
          {
            public void run()
            {
            	Bukkit.shutdown();
            	
            }
          }, 60L);
	}
	 public static void startBronze()
	  {
	    if (!bronzeisrunning)
	    {
	      bronzeisrunning = true;
	      bronzeTaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.o, new Runnable()
	      {
	        public void run()
	        {
	     
	            Location loc = LocationManager.getLocation("Bronze").add(0.5D, 0.0D, 0.5D);
	            Location loc2 = LocationManager.getLocation("Bronze2").add(0.5D, 0.0D, 0.5D);
	            
	            loc.getWorld().dropItem(loc, getItem(Material.CLAY_BRICK, 0, "§cBronze"));
	            loc2.getWorld().dropItem(loc2, getItem(Material.CLAY_BRICK, 0, "§cBronze"));
	          
	        }
	      }, 0L, 13L);
	    }
	  }
	  public static void stopStart()
	  {
	   
	      Bukkit.getScheduler().cancelTask(startID);
	    
	  }
	  public static void stopBronze()
	  {
	    if (bronzeisrunning)
	    {
	      bronzeisrunning = false;
	      Bukkit.getScheduler().cancelTask(bronzeTaskID);
	    }
	  }
	  
	  public static void startIron()
	  {
	    if (!ironisrunning)
	    {
	      ironisrunning = true;
	      ironTaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.o, new Runnable()
	      {
	        public void run()
	        {
	   
	            Location loc = LocationManager.getLocation("Eisen").add(0.5D, 0.0D, 0.5D);
	            
	            loc.getWorld().dropItem(loc, getItem(Material.IRON_INGOT, 0, "§7Eisen")).setPickupDelay(5);
	            Location loc2 = LocationManager.getLocation("Eisen2").add(0.5D, 0.0D, 0.5D);
	            
	            loc2.getWorld().dropItem(loc2, getItem(Material.IRON_INGOT, 0, "§7Eisen")).setPickupDelay(5);
	          
	        }
	      }, 0L, 300L);
	    }
	  }
	  
	  public static void stopIron()
	  {
	    if (ironisrunning)
	    {
	      ironisrunning = false;
	      Bukkit.getScheduler().cancelTask(ironTaskID);
	    }
	  }
	  
	  public static void startGold()
	  {
	    if (!goldisrunning)
	    {
	      goldisrunning = true;
	      goldTaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.o, new Runnable()
	      {
	        public void run()
	        {
	       
	            Location loc = LocationManager.getLocation("Gold").add(0.5D, 0.0D, 0.5D);
	            
	            loc.getWorld().dropItem(loc, getItem(Material.GOLD_INGOT, 0, "§6Gold")).setPickupDelay(5);
	          
	        }
	      }, 0L, 600L);
	    }
	  }
	  
	  public static void stopGold()
	  {
	    if (goldisrunning)
	    {
	      goldisrunning = false;
	      Bukkit.getScheduler().cancelTask(goldTaskID);
	    }
	  }
	  
	  public static ItemStack getItem(Material mat, int subid, String displayname, ArrayList<String> blauteam)
	  {
	    ItemStack is = new ItemStack(mat, 1, (short)subid);
	    ItemMeta im = is.getItemMeta();
	    im.setDisplayName(displayname);
	    im.setLore(blauteam);
	    is.setItemMeta(im);
	    return is;
	  }
	  
	  public static ItemStack getItem(Material mat, int subid, String displayname)
	  {
	    ItemStack is = new ItemStack(mat, 1, (short)subid);
	    ItemMeta im = is.getItemMeta();
	    im.setDisplayName(displayname);
	    is.setItemMeta(im);
	    return is;
	  }
	  public static void buy(Player p, ItemStack item, Material mat, int amount, boolean issneaking)
	  {
	    PlayerInventory inv = p.getInventory();
	    if (issneaking)
	    {
	      for (int i = 0; i < 32; i++) {
	        if (inv.contains(mat, amount))
	        {
	          removeInventoryItems(inv, mat, amount);
	          inv.addItem(new ItemStack[] { item });
	          p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
	        }
	        else
	        {
//	          p.sendMessage(Bedwars.Prefix + "§cDu hast nicht genügend dafür!");
	          return;
	        }
	      }
	    }
	    else if (inv.contains(mat, amount))
	    {
	      removeInventoryItems(inv, mat, amount);
	      inv.addItem(new ItemStack[] { item });
	      p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
	    }
	    else
	    {
	          p.sendMessage(Bedwars.Prefix + "§cDu hast nicht genügend dafür!");
	    }
	  }
	  public static boolean hasSpace(PlayerInventory inv)
	  {
	    for (int i = 0; i < inv.getSize(); i++) {
	      if ((inv.getItem(i) == null) || (inv.getItem(i).getType() == Material.AIR)) {
	        return true;
	      }
	    }
	    return false;
	  }
	  

	  
	  public static boolean removeInventoryItems(PlayerInventory inv, Material type, int amount)
	  {
	    boolean b = false;
	    ItemStack[] arritemStack = inv.getContents();
	    int n = arritemStack.length;
	    int n2 = 0;
	    while (n2 < n)
	    {
	      ItemStack is = arritemStack[n2];
	      if ((is != null) && (is.getType() == type))
	      {
	        b = true;
	        int newamount = is.getAmount() - amount;
	        if (newamount > 0)
	        {
	          is.setAmount(newamount);
	        }
	        else
	        {
	          inv.remove(is);
	          amount = -newamount;
	          if (amount == 0) {
	            break;
	          }
	        }
	      }
	      n2++;
	    }
	    return b;
	  }
	  
	
}
