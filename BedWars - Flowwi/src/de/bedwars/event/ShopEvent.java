package de.bedwars.event;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import de.bedwars.util.Shop;
public class ShopEvent  implements Listener
{
	
	  @EventHandler
	  public void onInteract(PlayerInteractEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    if (e.getRightClicked().getType() == EntityType.VILLAGER)
	    {

	   
	    	  e.setCancelled(true);
	    	  
	    	  
	    	  
	    	  
	    	  new Shop(e.getPlayer()).openMainShop();
	    	  
	    	  
	    	  
	    	  
	    	  
	      }
	    
	  }
	   @EventHandler
	    public void onEnitiyDamage(EntityDamageByEntityEvent e) {
	   
	    	if(e.getEntity() instanceof Villager && e.getDamager() instanceof Player) {
	    		
	    	
	    		e.setCancelled(true);
	    	}
	    	
	    }
	  @EventHandler
	  public void on(InventoryClickEvent e)
	  {
	    Player p = (Player)e.getWhoClicked();
	    if (e.getInventory().getContents() == null) {
	      return;
	    }
	    if (e.getCurrentItem() == null) {
	      return;
	    }
	if(e.getClickedInventory().getName().equalsIgnoreCase("§8> §c§lShop-" + "Tränke" + " §8<") || e.getClickedInventory().getName().equalsIgnoreCase("§8> §c§lShop-" + "Truhen" + " §8<") || e.getClickedInventory().getName().equalsIgnoreCase("§8> §c§lShop-" + "Essen" + " §8<")
			|| e.getClickedInventory().getName().equalsIgnoreCase( "§8> §c§lShop §8<") || e.getClickedInventory().getName().equalsIgnoreCase( "§8> §c§lShop-" + "Bögen" + " §8<") || e.getClickedInventory().getName().equalsIgnoreCase("§8> §c§lShop-" + "Schwerter" + " §8<") ||e.getClickedInventory().getName().equalsIgnoreCase( "§8> §c§lShop-" + "Spitzhacken" + " §8<")
					|| e.getClickedInventory().getName().equalsIgnoreCase("§8> §c§lShop-" + "Blöcke" + " §8<") || e.getClickedInventory().getName().equalsIgnoreCase("§8> §c§lShop-" + "Rüstung" + " §8<")) {
	      e.setCancelled(true);
	      if (e.getSlot() == 0)
	      {
	        new Shop(p).openBlöckeShop();
	      }
	      else if (e.getSlot() == 1)
	      {
	        new Shop(p).openRüstungenShop();
	      }
	      else if (e.getSlot() == 2)
	      {
	        new Shop(p).openSpitzhackenShop();
	      }
	      else if (e.getSlot() == 3)
	      {
	        new Shop(p).openSchwerterShop();
	      }
	      else if (e.getSlot() == 4)
	      {
	        new Shop(p).openBögenShop();
	      }
	      else if (e.getSlot() == 5)
	      {
	        new Shop(p).openEssenShop();
	      }
	      else if (e.getSlot() == 6)
	      {
	        new Shop(p).openTruhenShop();
	      }
	      else if (e.getSlot() == 7)
	      {
	        new Shop(p).openTränkeShop();
	      }
	      else if (e.getSlot() == 8)
	      {
	        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
	      }
	      
	}
	  }

}

