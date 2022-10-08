package dev.maximde.simplelobby.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;
import dev.maximde.simplelobby.utils.Utils;
import dev.maximde.simplelobby.versions.bossbar.BossbarManager_1_9_plus;


public class ChangeWorldEvent implements Listener {
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent event) {
		Player player = event.getPlayer();
		
		if(Settings.Spawn == null)return;
		
		setScoreboard(player);
		setBossbar(player);

	}

	public void setBossbar(Player player) {
		Bukkit.getScheduler().runTaskLater(SimpleLobby.getInstance(), new Runnable() {
			@Override
			public void run() {
				
    	if(SimpleLobby.cfg.getBoolean("Bossbar.onlyInLobbyWorld")) {
	    if(!player.getLocation().getWorld().getName().equals(Settings.Spawn.getWorld().getName())) {
	    	Utils.removeBossbar(player);
	    } else {
	    	Utils.setBossbar(player);
	    }
	    } else {
	    	Utils.setBossbar(player);
	    }

			}
		}, 2);
	}
	
	public void setScoreboard(Player player) {
		Bukkit.getScheduler().runTaskLater(SimpleLobby.getInstance(), new Runnable() {
			@Override
			public void run() {
				
    	if(SimpleLobby.cfg.getBoolean("Scoreboard.onlyInLobbyWorld")) {
	    if(!player.getLocation().getWorld().getName().equals(Settings.Spawn.getWorld().getName())) {
			player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
	    	} else {
	    		Utils.setScoreBoard(player);
	    	}
	    } else {
	    	Utils.setScoreBoard(player);
	    }

			}
		}, 2);
	}
}
