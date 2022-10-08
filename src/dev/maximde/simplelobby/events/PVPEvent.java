package dev.maximde.simplelobby.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class PVPEvent implements Listener {
	
	/**
	 * Player hit event is cancelled
	 * if Settings.isHitEvent & player is in survival
	 * & lobby spawn is not null & player is in the same world as the spawn
	 */
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		
		Player player = (Player) e.getEntity();
		if(player.getGameMode().equals(GameMode.CREATIVE) || !Settings.isHitEvent || Settings.lobbyWorldName == null) {
			return;
		}
		
		if(player.getLocation().getWorld().getName().equals(Settings.lobbyWorldName)) {
			e.setCancelled(true);
		    e.getDamager().sendMessage(Settings.prefix+Settings.hitMessage.replace("%player%", e.getDamager().getName()));
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
