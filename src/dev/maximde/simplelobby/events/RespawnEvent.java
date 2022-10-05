package dev.maximde.simplelobby.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import dev.maximde.simplelobby.utils.Settings;
import dev.maximde.simplelobby.Main;

public class RespawnEvent implements Listener {
	
	@EventHandler
	public void onRswn(PlayerRespawnEvent e) {
		if(Settings.isTeleportOnRespawn) {
	    	if(Settings.Spawn != null) {
	    		Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
	    			@Override
	    			public void run() {
			            e.getPlayer().teleport(Settings.Spawn);
	    			}
	    		}, 2);
	    	}
		}
	}
	


}
