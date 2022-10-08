package dev.maximde.simplelobby.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import dev.maximde.simplelobby.SimpleLobby;



public class Config {
	
	/**
	 * Sets the values in the config if not already existing
	 */
	public static void setupConfig() {
		/*
		 * Booleans
		 */
		if(!SimpleLobby.cfg.isSet("Config")) {	
			SimpleLobby.cfg.set("Config.TeleportOnJoin", true);
			SimpleLobby.cfg.set("Config.DisableBlockBreak", true);
			SimpleLobby.cfg.set("Config.DisableBlockPlace", true);
			SimpleLobby.cfg.set("Config.DisablePVP", true);
			SimpleLobby.cfg.set("Config.DisableDamage", true);
			SimpleLobby.cfg.set("Config.WelcomeMessageB", false);
			SimpleLobby.cfg.set("Config.JoinMessageB", true);
			SimpleLobby.cfg.set("Config.LeaveMessageB", true);
			SimpleLobby.cfg.set("Config.FireworkOnJoin", true);
			SimpleLobby.cfg.set("Config.TeleportOnRespawn", true);
			SimpleLobby.cfg.set("Config.DisableHunger", true);
			SimpleLobby.cfg.set("Config.DisableWeatherChange", true);
			saveConfig();
		}
		/*
		 * Strings
		 */
		if(!SimpleLobby.cfg.isSet("Messages")) {	
			SimpleLobby.cfg.set("Messages.WelcomeMessage", "&aWelcome %player%");
			SimpleLobby.cfg.set("Messages.JoinMessage", "&a[+] &6%player% joined the server");
			SimpleLobby.cfg.set("Messages.LeaveMessage", "&c[-] &6%player% left the server");
			SimpleLobby.cfg.set("Messages.PlaceBlocksMessage", "&cYou cant place blocks here!");
			SimpleLobby.cfg.set("Messages.BreakBlocksMessage", "&cYou cant break blocks here!");
			SimpleLobby.cfg.set("Messages.PlayerHitMessage", "&cPVP is here disabled!");
			SimpleLobby.cfg.set("Messages.Prefix", "&bSimpleLobby ");
			SimpleLobby.cfg.set("Messages.SpawnTeleportMessage", "&aTeleported to spawn!");
			saveConfig();
		}
		/*
		 * Scoreboard
		 */
		if(!SimpleLobby.cfg.isSet("Scoreboard")) {	
			SimpleLobby.cfg.set("Scoreboard.isEnabled", true);
			SimpleLobby.cfg.set("Scoreboard.onlyInLobbyWorld", true);
			SimpleLobby.cfg.set("Scoreboard.Title", "&b&lSimpleLobby");
			SimpleLobby.cfg.set("Scoreboard.line0", " ");
			SimpleLobby.cfg.set("Scoreboard.line1", "&aWelcome %player%");
			SimpleLobby.cfg.set("Scoreboard.line2", " ");
			SimpleLobby.cfg.set("Scoreboard.line3", "");
			SimpleLobby.cfg.set("Scoreboard.line4", "Change the text in:");
			SimpleLobby.cfg.set("Scoreboard.line5", "&nSimpleLobby/plugins/config.yml");
			SimpleLobby.cfg.set("Scoreboard.line6", "");
			SimpleLobby.cfg.set("Scoreboard.line7", "");
			SimpleLobby.cfg.set("Scoreboard.line8", "");
			SimpleLobby.cfg.set("Scoreboard.line9", "");
			SimpleLobby.cfg.set("Scoreboard.line10", "&7yourserver.net");
			saveConfig();
		}
		/*
		 * Commands
		 */
		if(!SimpleLobby.cfg.isSet("Commands")) {	
			SimpleLobby.cfg.set("Commands.SpawnTeleport", true);
			saveConfig();
		}

	}
	
    /**
     * Save config in config.yml
     */
	public static void saveConfig() {
		try {
			SimpleLobby.cfg.save(SimpleLobby.file);
		} catch (IOException e) {
			System.err.println(SimpleLobby.prefixWithoutColor+"Error! cant save config!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Get config file from main class
	 * @return config file
	 */
	public static File getFile() {
		return SimpleLobby.file;
	}
	
	/**
	 * Get cfg Config (YamlConfiguration) from main class
	 * @return
	 */
	public static YamlConfiguration getConfig() {
		return SimpleLobby.cfg;
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
