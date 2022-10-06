package dev.maximde.simplelobby.events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.FireworkManager;
import dev.maximde.simplelobby.utils.Settings;


public class JoinEvent implements Listener {

	/**
	 * Changes the join message
	 * if Settings.isleaveMessage is true and Settings.leaveMessage is not null.
	 * Adds a welcome message (Only to joined player) if Settings.isWelcomeMessage is true.
	 * Teleports player to spawn if Settings.isTeleportOnJoin is true.
	 * Spawns firework on players location if Settings.isFireWorkOnJoin is true.
	 * Sends the player a message if spawn is not set.
	 */
	@EventHandler
	public void playerJoin (PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		
		if(Settings.isWelcomeMessage) {
			p.sendMessage(Settings.prefix + Settings.welcomeMessage.replace("%player%", p.getName()));
		}
		
		if(Settings.isJoinMessage) {
			e.setJoinMessage(Settings.joinMessage.replace("%player%", p.getName()));
		}
		


		if(Settings.lobbyWorldName == null) {
		if(p.hasPermission(SimpleLobby.prefixWithoutColor.toLowerCase() + ".admin") || p.hasPermission(SimpleLobby.prefixWithoutColor.toLowerCase() + ".cmd")) {
				p.sendMessage(Settings.prefix + "§cType §a/sl setspawn §c to set the lobby spawn point");
			} else {
				p.sendMessage(Settings.prefix + "§cType §6op " + p.getName() + "§c in server console and set the lobby spawn with §a/sl setspawn");
			}
		}
		
		if(Settings.isTeleportOnJoin && Settings.lobbyWorldName != null) {
			p.teleport(Settings.Spawn);
		}
		
		if(Settings.isFireWorkOnJoin) {
			FireworkManager fire = new FireworkManager(SimpleLobby.plugin);
	    	fire.setLocation(p.getLocation());
	    	fire.setPower(2);
	    	fire.setEffect(FireworkEffect.builder().withColor(Color.ORANGE).with(Type.BURST).withFlicker().withTrail().build());
	        fire.setLifeTime(5);
	        fire.spawnFirework();
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
