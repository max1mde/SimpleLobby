package dev.maximde.simplelobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import dev.maximde.simplelobby.utils.Settings;

public class QuitEvent implements Listener {

	/**
	 * Changes the leave message
	 * if Settings.isleaveMessage is true and Settings.leaveMessage is not null
	 */
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(!Settings.isleaveMessage || Settings.leaveMessage == null) {
			return;
		}
		
		e.setQuitMessage(Settings.leaveMessage.replace("%player%", e.getPlayer().getName()));
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
