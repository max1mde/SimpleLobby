package dev.maximde.simplelobby;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


import dev.maximde.simplelobby.commands.SimpleLobby;
import dev.maximde.simplelobby.commands.Spawn;
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
import dev.maximde.simplelobby.utils.BarUtil;


public class Main extends JavaPlugin {

	
	
	//------------------------------------------------
	public final static String COLOR = "§b";
	public final static String name = "SimpleLobby";
	public final static String nameK = "sl";
	//------------------------------------------------
	
	
	
	private static Main instance;
	public static Plugin plugin;
	public final static String prefix = COLOR + "["+name+"] ";
	public final static String prefixWithoutColor = "["+name+"] ";
	public final static float Version = 1.0F;
	public static File file = new File("plugins/"+name, "config.yml");
	public static YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(file);




	@Override
	public void onEnable() {
		Config.setupConfig();
		Locations.setupFiles();
		instance = this;
		plugin = this;
		registerEvents();
		registerCommands();
		setSettingsFromConfig();
		
	    getServer().getConsoleSender().sendMessage("§6===>> "+name+" <<===");
	    getServer().getConsoleSender().sendMessage("§6=====================");
	    getServer().getConsoleSender().sendMessage("§6==Plugin by MaximDe==");
	    getServer().getConsoleSender().sendMessage("§6=====================");
	    getServer().getConsoleSender().sendMessage("§bhttps://discord.gg/gbqF32Qsv2");
	    getServer().getConsoleSender().sendMessage("§bhttps://www.spigotmc.org/members/maximde.1620695/");
	    getServer().getConsoleSender().sendMessage("§6=====================");
	  

	
	}
	
	public void setBossBar() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(Settings.isBossbar) {
                    for(String s : BarUtil.getPlayers()) {
                        Player o = Bukkit.getPlayer(s);

                        if(o != null) BarUtil.teleportBar(o);
                    }

                    try {
                        Thread.sleep(1000); // 1000 = 1 sec
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
	}
	
	public static void reloadConfigCMD() {
		cfg = new YamlConfiguration().loadConfiguration(file);
		Main.setSettingsFromConfig();
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	private void registerCommands() {
		this.getCommand("simplelobby").setExecutor(new SimpleLobby());
		this.getCommand("sl").setExecutor(new SimpleLobby());
		
		this.getCommand("spawn").setExecutor(new Spawn());
		this.getCommand("l").setExecutor(new Spawn());
		this.getCommand("hub").setExecutor(new Spawn());
		this.getCommand("stuck").setExecutor(new Spawn());
		this.getCommand("lobby").setExecutor(new Spawn());
		
		System.out.println(prefixWithoutColor + "loaded commands!");
	}
	
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
		Settings.breakMessage = cfg.getString("Messages.BreakBlocksMessage").replace("&", "§");
		Settings.placeMessage = cfg.getString("Messages.PlaceBlocksMessage").replace("&", "§");
		Settings.hitMessage = cfg.getString("Messages.PlayerHitMessage").replace("&", "§");
		Settings.prefix = cfg.getString("Messages.Prefix").replace("&", "§");
		Settings.leaveMessage = cfg.getString("Messages.LeaveMessage").replace("&", "§");
		Settings.joinMessage = cfg.getString("Messages.JoinMessage").replace("&", "§");
		Settings.welcomeMessage = cfg.getString("Messages.WelcomeMessage").replace("&", "§");
		Settings.teleportToSpawnMessage = cfg.getString("Messages.SpawnTeleportMessage").replace("&", "§");
		Settings.bossbarText = cfg.getString("Messages.BossBarText");
		

		
		try {
			Settings.Spawn = Locations.getLocation("Spawn");
			Settings.lobbyWorldName = Locations.getLocation("Spawn").getWorld().getName();
			
		} catch (Exception e) {
			
		}

	}
}
