package dev.maximde.simplelobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import dev.maximde.simplelobby.SimpleLobby;

public class HungerEvent  implements Listener {

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if(SimpleLobby.cfg.getBoolean("Config.DisableHunger")) {
		e.setCancelled(true);
		}
	}
	
}
