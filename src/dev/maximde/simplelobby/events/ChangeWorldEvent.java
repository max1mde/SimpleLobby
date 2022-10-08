package dev.maximde.simplelobby.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;
import dev.maximde.simplelobby.utils.Utils;

public class ChangeWorldEvent implements Listener {
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent event) {
		if(Settings.Spawn == null)return;
		
		Bukkit.getScheduler().runTaskLater(SimpleLobby.getInstance(), new Runnable() {
			@Override
			public void run() {
				
    	if(SimpleLobby.cfg.getBoolean("Scoreboard.onlyInLobbyWorld")) {
	    if(!event.getPlayer().getLocation().getWorld().getName().equals(Settings.Spawn.getWorld().getName())) {
			event.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
	    	} else {
		    	Utils.setScoreBoard(event.getPlayer());
		    }
	    } 

			}
		}, 2);
	}

}
