package dev.maximde.simplelobby.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import dev.maximde.simplelobby.Main;



public class Config {
	
	public static void setupConfig() {
		
		if(!Main.cfg.isSet("Config")) {	
			Main.cfg.set("Config.TeleportOnJoin", true);
			Main.cfg.set("Config.DisableBlockBreak", true);
			Main.cfg.set("Config.DisableBlockPlace", true);
			Main.cfg.set("Config.DisablePVP", true);
			Main.cfg.set("Config.DisableDamage", true);
			Main.cfg.set("Config.WelcomeMessageB", false);
			Main.cfg.set("Config.JoinMessageB", true);
			Main.cfg.set("Config.LeaveMessageB", true);
			Main.cfg.set("Config.FireworkOnJoin", true);
			Main.cfg.set("Config.TeleportOnRespawn", true);
			saveConfig();
		}
		
		
		if(!Main.cfg.isSet("Messages")) {	
			Main.cfg.set("Messages.WelcomeMessage", "&aWelcome %player%");
			Main.cfg.set("Messages.JoinMessage", "&a[+] &6%player% joined the server");
			Main.cfg.set("Messages.LeaveMessage", "&c[-] &6%player% left the server");
			Main.cfg.set("Messages.PlaceBlocksMessage", "&cYou cant place blocks here!");
			Main.cfg.set("Messages.BreakBlocksMessage", "&cYou cant break blocks here!");
			Main.cfg.set("Messages.PlayerHitMessage", "&cPVP is here disabled!");
			Main.cfg.set("Messages.Prefix", "&bSimpleLobby ");
			Main.cfg.set("Messages.SpawnTeleportMessage", "&aTeleported to spawn!");
			saveConfig();
		}

	}
	
	public static void saveConfig() {
		try {
			Main.cfg.save(Main.file);
		} catch (IOException e) {
			System.err.println(Main.prefixWithoutColor+"Error! cant save config!");
			e.printStackTrace();
		}
	}
	
	
	public static File getFile() {
		return Main.file;
	}
	
	public static YamlConfiguration getConfig() {
		return Main.cfg;
	}
	
}
