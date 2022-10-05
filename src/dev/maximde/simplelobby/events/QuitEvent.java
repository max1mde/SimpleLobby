package dev.maximde.simplelobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev.maximde.simplelobby.utils.BarUtil;
import dev.maximde.simplelobby.utils.Settings;

public class QuitEvent implements Listener {

	@EventHandler
	public void playerJoin (PlayerQuitEvent e) {
		
		if(Settings.isBossbar) {
			BarUtil.removeBar(e.getPlayer()); 
		}
		
		if(Settings.isleaveMessage) {
			e.setQuitMessage(Settings.leaveMessage.replace("%player%", e.getPlayer().getName()));
		}
	}
}
