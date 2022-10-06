/**
* 
* MaximDe 2022.
* 
* LINKS:
* https://github.com/JavaDevMC
* https://www.spigotmc.org/members/maximde.1620695/
* 
* 
* SimpleLobby on SpigotMC:
* https://www.spigotmc.org/resources/simplelobby-1-8-x.105614/
* 
* 
* You can use my code in your project.
* But please give credits :)
* 
*/

package dev.maximde.simplelobby;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import dev.maximde.simplelobby.commands.SimpleLobbyCommand;
import dev.maximde.simplelobby.commands.SpawnCommand;
import dev.maximde.simplelobby.events.BreakEvent;
import dev.maximde.simplelobby.events.DamageEvent;
import dev.maximde.simplelobby.events.JoinEvent;
import dev.maximde.simplelobby.events.PVPEvent;
import dev.maximde.simplelobby.events.PlaceEvent;
import dev.maximde.simplelobby.events.QuitEvent;
import dev.maximde.simplelobby.events.RespawnEvent;
import dev.maximde.simplelobby.utils.Config;
import dev.maximde.simplelobby.utils.Locations;
import dev.maximde.simplelobby.utils.Settings;


public class SimpleLobby extends JavaPlugin {
	
	
	//-----> IMPORTANT VALUES <-----
	/**
	 * Prefix color
	 */
	public final static String COLOR = "�b";
	/**
	 * Prefix
	 */
	public final static String name = "SimpleLobby";
	/**
	 * Prefix initials
	 */
	public final static String nameK = "sl";
	/**
	 * Plugin version
	 */
	public final static float Version = 1.2F;
	//-----> IMPORTANT VALUES <-----
	
	

	/**
	 * Main instance
	 */
	private static SimpleLobby instance;
	/**
	 * Plugin instance
	 */
	public static Plugin plugin;
	/**
	 * Prefix with color
	 */
	public final static String prefix = COLOR + "["+name+"] ";
	/**
	 * Prefix without color
	 */
	public final static String prefixWithoutColor = "["+name+"] ";
    /**
     * Config file
     */
	public static File file = new File("plugins/"+name, "config.yml");
	/**
	 * YAML config
	 */
	public static YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(file);

    /**
     * On plugin enable
     */
	@Override
	public void onEnable() {
		Config.setupConfig();
		Locations.setupFiles();
		instance = this;
		plugin = this;
		registerEvents();
		registerCommands();
		setSettingsFromConfig();
	    getServer().getConsoleSender().sendMessage("�6===>> "+name+" <<===");
	    getServer().getConsoleSender().sendMessage("�6=====================");
	    getServer().getConsoleSender().sendMessage("�6==Plugin by MaximDe==");
	    getServer().getConsoleSender().sendMessage("�bhttps://discord.gg/gbqF32Qsv2");
	    getServer().getConsoleSender().sendMessage("�bhttps://www.spigotmc.org/members/maximde.1620695/");
	    getServer().getConsoleSender().sendMessage("�6=====================");
	}
	
	/**
	 * Reload config (used in SimpleLobbyCommand.java)
	 */
	public static void reloadConfigCMD() {
		cfg = new YamlConfiguration().loadConfiguration(file);
		SimpleLobby.setSettingsFromConfig();
	}
	
	/**
	 * @return Instance of SimpleLobby (Main class)
	 */
	public static SimpleLobby getInstance() {
		return instance;
	}
	
	/**
	 * Register all commands
	 */
	private void registerCommands() {
		//Main command
		this.getCommand("simplelobby").setExecutor(new SimpleLobbyCommand());
		this.getCommand("sl").setExecutor(new SimpleLobbyCommand());
		//Spawn command
		this.getCommand("spawn").setExecutor(new SpawnCommand());
		this.getCommand("l").setExecutor(new SpawnCommand());
		this.getCommand("hub").setExecutor(new SpawnCommand());
		this.getCommand("stuck").setExecutor(new SpawnCommand());
		this.getCommand("lobby").setExecutor(new SpawnCommand());
		System.out.println(prefixWithoutColor + "loaded commands!");
	}
	
	/**
	 * Register all events
	 */
	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new BreakEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PlaceEvent(), this);
		Bukkit.getPluginManager().registerEvents(new PVPEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RespawnEvent(), this);
		System.out.println(prefixWithoutColor + "loaded events!");
	}
	
	/**
	 * Initialize settings
	 */
	public static void setSettingsFromConfig() {
		//BOOLEANS
		Settings.isTeleportOnJoin = cfg.getBoolean("Config.TeleportOnJoin");
		Settings.isBreakEvent = cfg.getBoolean("Config.DisableBlockBreak");
		Settings.isPlaceEvent = cfg.getBoolean("Config.DisableBlockPlace");
		Settings.isDamageEvent = cfg.getBoolean("Config.DisableDamage");
		Settings.isHitEvent = cfg.getBoolean("Config.DisablePVP");
		Settings.isWelcomeMessage = cfg.getBoolean("Config.WelcomeMessageB");
		Settings.isJoinMessage = cfg.getBoolean("Config.JoinMessageB");
		Settings.isleaveMessage = cfg.getBoolean("Config.LeaveMessageB");
		Settings.isFireWorkOnJoin = cfg.getBoolean("Config.FireworkOnJoin");
		Settings.isTeleportOnRespawn = cfg.getBoolean("Config.TeleportOnRespawn");
		Settings.isBossbar = cfg.getBoolean("Config.BossBar");
		//STRINGS
		Settings.breakMessage = cfg.getString("Messages.BreakBlocksMessage").replace("&", "�");
		Settings.placeMessage = cfg.getString("Messages.PlaceBlocksMessage").replace("&", "�");
		Settings.hitMessage = cfg.getString("Messages.PlayerHitMessage").replace("&", "�");
		Settings.prefix = cfg.getString("Messages.Prefix").replace("&", "�");
		Settings.leaveMessage = cfg.getString("Messages.LeaveMessage").replace("&", "�");
		Settings.joinMessage = cfg.getString("Messages.JoinMessage").replace("&", "�");
		Settings.welcomeMessage = cfg.getString("Messages.WelcomeMessage").replace("&", "�");
		Settings.teleportToSpawnMessage = cfg.getString("Messages.SpawnTeleportMessage").replace("&", "�");
		Settings.bossbarText = cfg.getString("Messages.BossBarText");
		
		/*
		 * Try catch because Locations.getLocation("Spawn") is null
		 * if spawn is not set.
		 */
		try {
			Settings.Spawn = Locations.getLocation("Spawn");
			Settings.lobbyWorldName = Locations.getLocation("Spawn").getWorld().getName();
		} catch (Exception e) {
			System.out.println(prefixWithoutColor + "Failed to init spawn location and world name because spawn is not set!");
			System.out.println(prefixWithoutColor + "Type ingame /" + nameK + " setspawn");
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
