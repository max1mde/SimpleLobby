package dev.maximde.simplelobby.utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.versions.bossbar.BossbarManager_1_9_plus;
import dev.maximde.simplelobby.versions.scoreboard.ScoreboardUtil;
import dev.maximde.simplelobby.versions.scoreboard.ScoreboardUtil_1_8_R3;
import dev.maximde.simplelobby.versions.scoreboard.ScoreboardUtil_1_9_R1;

public class Utils {
	
	/**
	 * Set lobby scoreboard
	 * @param p
	 */
	public static void setScoreBoard(Player p) {
		if(SimpleLobby.cfg.getBoolean("Scoreboard.isEnabled")) {
			ScoreboardUtil su;
			if(SimpleLobby.serverVersion.equals("v1_8_R3")) {
				su = new ScoreboardUtil_1_8_R3();
			} else {
				su = new ScoreboardUtil_1_9_R1();
			}
			su.setScoreboard(p, SimpleLobby.cfg.getString("Scoreboard.Title"),
			SimpleLobby.cfg.getString("Scoreboard.line0"),
			SimpleLobby.cfg.getString("Scoreboard.line1"),
			SimpleLobby.cfg.getString("Scoreboard.line2"),
			SimpleLobby.cfg.getString("Scoreboard.line3"),
			SimpleLobby.cfg.getString("Scoreboard.line4"),
			SimpleLobby.cfg.getString("Scoreboard.line5"),
			SimpleLobby.cfg.getString("Scoreboard.line6"),
			SimpleLobby.cfg.getString("Scoreboard.line7"),
			SimpleLobby.cfg.getString("Scoreboard.line8"),
			SimpleLobby.cfg.getString("Scoreboard.line9"),
			SimpleLobby.cfg.getString("Scoreboard.line10"));
		}
	}
	
	/**
	 * Set lobby bossbar
	 * @param p
	 */
	public static void setBossbar(Player p) {
		if(!SimpleLobby.serverVersion.equals("v1_8_R3")) {
			BossbarManager_1_9_plus.setBossbar(p);
		}
	}
	
	/**
	 * Remove bossbar from a player
	 * @param p
	 */
	public static void removeBossbar(Player p) {
		if(!SimpleLobby.serverVersion.equals("v1_8_R3")) {
			BossbarManager_1_9_plus.lobbyBar.removePlayer(p);
		}
	}
	
	/**
	 * Reload (used in SimpleLobbyCommand.java)
	 */
	public static void reloadConfig() {
		SimpleLobby.cfg = new YamlConfiguration().loadConfiguration(SimpleLobby.file);
		SimpleLobby.setSettingsFromConfig();
		for(Player player : Bukkit.getOnlinePlayers()) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SimpleLobby.getInstance(), new Runnable() {
				public void run() {
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				setScoreBoard(player);
				setBossbar(player);
				}
		    }, 20L);
		}
	}
	
	/**
	 * Reload (used in SimpleLobbyCommand.java)
	 */
	public static void reloadConfigCMD(Player p) {
		p.sendMessage("§6Reloading config...");
		SimpleLobby.cfg = new YamlConfiguration().loadConfiguration(SimpleLobby.file);
		SimpleLobby.setSettingsFromConfig();
		for(Player player : Bukkit.getOnlinePlayers()) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SimpleLobby.getInstance(), new Runnable() {
				public void run() {
				p.sendMessage("§6Reloading scoreboard...");
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				setScoreBoard(player);
				p.sendMessage("§6Reloading bossbar...");
				setBossbar(player);
				p.sendMessage("§aReload complete!");
				}
		    }, 20L);
		}
	}
	
	public static void reloadConfigConsole() {
		org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage(Settings.prefix + "§6Reloading config...");
		SimpleLobby.cfg = new YamlConfiguration().loadConfiguration(SimpleLobby.file);
		SimpleLobby.setSettingsFromConfig();
		for(Player player : Bukkit.getOnlinePlayers()) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SimpleLobby.getInstance(), new Runnable() {
				public void run() {
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage(Settings.prefix + "§6Reloading scoreboard...");
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				setScoreBoard(player);
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage(Settings.prefix + "§6Reloading bossbar...");
				setBossbar(player);
				org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage(Settings.prefix + "§aReload complete!");
				}
		    }, 20L);
		}
	}

}
