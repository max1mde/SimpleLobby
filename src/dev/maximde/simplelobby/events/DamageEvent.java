package dev.maximde.simplelobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import dev.maximde.simplelobby.Main;
import dev.maximde.simplelobby.utils.Settings;

public class DamageEvent implements Listener {
	
	@EventHandler
	public void onDMG(EntityDamageEvent e) {
		if(Settings.lobbyWorldName != null && Settings.isDamageEvent) {
			if(e.getEntity().getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
				if(e.getCause() == DamageCause.FALL) {
					e.setCancelled(true);
				} else if(e.getCause() == DamageCause.LAVA) {
					e.setCancelled(true);
				} else if(e.getCause() == DamageCause.FIRE) {
					e.setCancelled(true);
				} else if(e.getCause() == DamageCause.FIRE_TICK) {
					e.setCancelled(true);
				} else if(e.getCause() == DamageCause.FALLING_BLOCK) {
					e.setCancelled(true);
				} else if(e.getCause() == DamageCause.BLOCK_EXPLOSION) {
					e.setCancelled(true);
				} else if(e.getCause() == DamageCause.ENTITY_EXPLOSION) {
					e.setCancelled(true);
				} else {

				}
			}
		}
	}

}
