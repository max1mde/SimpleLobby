package dev.maximde.simplelobby.events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;
import dev.maximde.simplelobby.versions.FireworkManager_1_11_to_1_19;
import dev.maximde.simplelobby.versions.FireworkManager_1_8_8_R3;
import dev.maximde.simplelobby.versions.FireworkManager_1_9_to_1_10;



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
           SpawnFirework(p);
		}
	}
	
	/**
	 * Checking version and spawn firework
	 * @param p
	 */
	public void SpawnFirework(Player p) {
		if(SimpleLobby.serverVersion.equals("v1_8_R3")) {
			FireworkManager_1_8_8_R3 fire;
			fire = new FireworkManager_1_8_8_R3(SimpleLobby.plugin);
			fire.setLocation(p.getLocation());
	    	fire.setPower(2);
	    	fire.setPlayer(p);
	    	fire.setEffect(FireworkEffect.builder().withColor(Color.ORANGE).with(Type.BURST).withFlicker().withTrail().build());
	        fire.setLifeTime(5);
	        fire.spawnFirework();
		} else if(SimpleLobby.serverVersion.equals("v1_9_R1")) {
			//-Not my code!-
			//CREDITS https://www.spigotmc.org/members/jeussa.19465/
			FireworkManager_1_9_to_1_10.spawn(p.getLocation(), FireworkEffect.builder().withColor(Color.ORANGE).withFlicker().withTrail().build(), p);
		    //--------------
		} else if(SimpleLobby.serverVersion.equals("v1_10_R1")) {
			//-Not my code!-
			//CREDITS https://www.spigotmc.org/members/jeussa.19465/
			FireworkManager_1_9_to_1_10.spawn(p.getLocation(), FireworkEffect.builder().withColor(Color.ORANGE).withFlicker().withTrail().build(), p);
		    //--------------
		} else {
			FireworkManager_1_11_to_1_19.spawn(p);
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
