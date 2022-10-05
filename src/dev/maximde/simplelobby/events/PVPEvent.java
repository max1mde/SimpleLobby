package dev.maximde.simplelobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import dev.maximde.simplelobby.Main;
import dev.maximde.simplelobby.utils.Settings;

public class PVPEvent implements Listener {
	
	@EventHandler
	public void pvpEvent(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
		Player p = (Player) e.getEntity();
		if(p.getGameMode().equals(GameMode.CREATIVE)) {
			return;
		}
		if(Settings.lobbyWorldName != null && Settings.isHitEvent) {
			if(p.getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
				e.setCancelled(true);
			    e.getDamager().sendMessage(Settings.prefix+"§cPVP is here disabled!");
				
			}
		}
		
		}
	}

}
