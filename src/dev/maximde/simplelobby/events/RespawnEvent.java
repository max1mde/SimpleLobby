package dev.maximde.simplelobby.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import dev.maximde.simplelobby.utils.Settings;
import dev.maximde.simplelobby.SimpleLobby;

public class RespawnEvent implements Listener {
	
	/**
	 * Teleports player on respawn to spawn
	 * if Settings.isTeleportOnRespawn is true and spawn location is not null
	 */
	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		if(!Settings.isTeleportOnRespawn || Settings.Spawn == null) {
			return;
		}
		
		Bukkit.getScheduler().runTaskLater(SimpleLobby.getInstance(), new Runnable() {
			@Override
			public void run() {
	            event.getPlayer().teleport(Settings.Spawn);
			}
		}, 2);	
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
