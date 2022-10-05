package dev.maximde.simplelobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import dev.maximde.simplelobby.Main;
import dev.maximde.simplelobby.utils.Settings;

public class BreakEvent implements Listener {
	
	@EventHandler
	public void breakEvent(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getGameMode().equals(GameMode.CREATIVE)) {
			return;
		}
		if(Settings.lobbyWorldName != null && Settings.isBreakEvent) {
			if(p.getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
				e.setCancelled(true);
				p.sendMessage(Settings.prefix+"§cYou cant break blocks here!");
				
			}
		}
	}

}
