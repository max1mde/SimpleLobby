/*
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
import dev.maximde.simplelobby.events.ChangeWorldEvent;
import dev.maximde.simplelobby.events.DamageEvent;
import dev.maximde.simplelobby.events.HungerEvent;
import dev.maximde.simplelobby.events.JoinEvent;
import dev.maximde.simplelobby.events.PVPEvent;
import dev.maximde.simplelobby.events.PlaceEvent;
import dev.maximde.simplelobby.events.QuitEvent;
import dev.maximde.simplelobby.events.RespawnEvent;
import dev.maximde.simplelobby.events.WeatherEvent;
import dev.maximde.simplelobby.utils.Config;
import dev.maximde.simplelobby.utils.Locations;
import dev.maximde.simplelobby.utils.Settings;



public class SimpleLobby extends JavaPlugin {
	
	
	//-----> IMPORTANT VALUES <-----
	/**
	 * Prefix color
	 */
	public final static String COLOR = "§b";
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
	public final static float Version = 1.4F;
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
	
	public static String serverVersion;
	
	@Override
	public void onEnable() {
		if(!VersionChecker()){
			getServer().getConsoleSender().sendMessage("§c==>> "+name+" <<==");
			getServer().getConsoleSender().sendMessage("§c=====================");
			getServer().getConsoleSender().sendMessage("§c==Plugin by MaximDe==");
			getServer().getConsoleSender().sendMessage("§c=====================");
			getServer().getConsoleSender().sendMessage("§cFAILED to load SimpleLobby! ");
			getServer().getConsoleSender().sendMessage("§cRunning non-compatible server version!");
			getServer().getConsoleSender().sendMessage("§c=====================");
			getServer().getConsoleSender().sendMessage("§cSimpleLobby is for MC 1.8.8 §7(v1_8_R3)§c - 1.19.2 §7(v1_19_R1)§c compatible");
			getServer().getConsoleSender().sendMessage("§cYour version: §7" + this.serverVersion);
			getServer().getConsoleSender().sendMessage("§c=====================");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		Config.setupConfig();
		Locations.setupFiles();
		instance = this;
		plugin = this;
	    	registerEvents();
	    	registerCommands();
	    	setSettingsFromConfig();
	    	getServer().getConsoleSender().sendMessage("§6==>> "+name+" <<==");
	    	getServer().getConsoleSender().sendMessage("§6=====================");
	    	getServer().getConsoleSender().sendMessage("§6==Plugin by MaximDe==");
	    	getServer().getConsoleSender().sendMessage("§bhttps://discord.gg/gbqF32Qsv2");
	    	getServer().getConsoleSender().sendMessage("§bhttps://www.spigotmc.org/members/maximde.1620695/");
	    	getServer().getConsoleSender().sendMessage("§6=====================");
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
		Bukkit.getPluginManager().registerEvents(new HungerEvent(), this);
		Bukkit.getPluginManager().registerEvents(new WeatherEvent(), this);
		Bukkit.getPluginManager().registerEvents(new ChangeWorldEvent(), this);
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

		//STRINGS
		Settings.breakMessage = cfg.getString("Messages.BreakBlocksMessage").replace("&", "§");
		Settings.placeMessage = cfg.getString("Messages.PlaceBlocksMessage").replace("&", "§");
		Settings.hitMessage = cfg.getString("Messages.PlayerHitMessage").replace("&", "§");
		Settings.prefix = cfg.getString("Messages.Prefix").replace("&", "§");
		Settings.leaveMessage = cfg.getString("Messages.LeaveMessage").replace("&", "§");
		Settings.joinMessage = cfg.getString("Messages.JoinMessage").replace("&", "§");
		Settings.welcomeMessage = cfg.getString("Messages.WelcomeMessage").replace("&", "§");
		Settings.teleportToSpawnMessage = cfg.getString("Messages.SpawnTeleportMessage").replace("&", "§");
		
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
	
    public boolean VersionChecker() {
    	serverVersion = "N/A";
    	try {
    		serverVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
			if(SimpleLobby.serverVersion.equals("v1_8_R3")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_9_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_10_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_11_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_12_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_13_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_14_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_15_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_16_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_17_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_18_R1")) {
				return true;
			} else if(SimpleLobby.serverVersion.equals("v1_19_R1")) {
				return true;
			} else {
				return false;
			}
    	} catch (Exception e) {
    		return false;
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
