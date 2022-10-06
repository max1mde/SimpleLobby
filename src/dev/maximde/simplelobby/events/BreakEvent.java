package dev.maximde.simplelobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class BreakEvent implements Listener {
	
	/**
	 * Block break event is cancelled
	 * if Settings.isBreakEvent & player is in survival
	 * & lobby spawn is not null & player is in the same world as the spawn
	 */
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		if(p.getGameMode().equals(GameMode.CREATIVE)) {
			return;
		}
		if(Settings.lobbyWorldName != null && Settings.isBreakEvent) {
			if(p.getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
				event.setCancelled(true);
				p.sendMessage(Settings.prefix+"§cYou cant break blocks here!");
				
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
