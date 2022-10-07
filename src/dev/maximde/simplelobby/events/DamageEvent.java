package dev.maximde.simplelobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class DamageEvent implements Listener {
	
	
	/**
	 * Most damage is cancelled
	 * if Settings.isDamageEvent & lobby spawn is not null & player is in the same world as the spawn
	 * CANCELLED DAMAGE:
	 * FALL, LAVA, FIRE, FIRE_TICK, FALLING_BLOCK, BLOCK_EXPLOSION, & ENTITY_EXPLOSION
	 */
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if(Settings.lobbyWorldName == null && !Settings.isDamageEvent) {
		  return;	
		}	
			if(event.getEntity().getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
				if(event.getCause() == DamageCause.FALL) {
					event.setCancelled(true);
				} else if(event.getCause() == DamageCause.LAVA) {
					event.setCancelled(true);
				} else if(event.getCause() == DamageCause.FIRE) {
					event.setCancelled(true);
				} else if(event.getCause() == DamageCause.FIRE_TICK) {
					event.setCancelled(true);
				} else if(event.getCause() == DamageCause.FALLING_BLOCK) {
					event.setCancelled(true);
				} else if(event.getCause() == DamageCause.BLOCK_EXPLOSION) {
					event.setCancelled(true);
				} else if(event.getCause() == DamageCause.ENTITY_EXPLOSION) {
					event.setCancelled(true);
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
