package dev.maximde.simplelobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class PlaceEvent  implements Listener {
	
	/**
	 * Block place event is cancelled
	 * if Settings.isPlaceEvent & player is in survival
	 * & lobby spawn is not null & player is in the same world as the spawn
	 */
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		if(p.getGameMode().equals(GameMode.CREATIVE)) {
			return;
		}
		if(Settings.lobbyWorldName != null && Settings.isPlaceEvent) {
			if(p.getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
				event.setCancelled(true);
				p.sendMessage(Settings.prefix+"§cYou cant place blocks here!");
				
			}
		}
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
