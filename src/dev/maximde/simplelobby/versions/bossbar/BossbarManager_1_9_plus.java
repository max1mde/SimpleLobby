package dev.maximde.simplelobby.versions.bossbar;


import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class BossbarManager_1_9_plus {
	
	public static BossBar lobbyBar = Bukkit.createBossBar(SimpleLobby.cfg.getString("Bossbar.Text"), BarColor.BLUE, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
	
	public static void setBossbar(Player player) {
		if(Settings.Spawn == null || !SimpleLobby.cfg.getBoolean("Bossbar.isEnabled")) {
			return;
		}
		
		lobbyBar.removePlayer(player);
		BarColor color = BarColor.BLUE;
		String configColor = SimpleLobby.cfg.getString("Bossbar.Color");
		if(configColor.equalsIgnoreCase("blue")) {
			color = BarColor.BLUE;
		} else if(configColor.equalsIgnoreCase("red")) {
			color = BarColor.RED;
		} else if(configColor.equalsIgnoreCase("pink")) {
			color = BarColor.PINK;
		} else if(configColor.equalsIgnoreCase("green")) {
			color = BarColor.GREEN;
		} else if(configColor.equalsIgnoreCase("yellow")) {
			color = BarColor.YELLOW;
		} else if(configColor.equalsIgnoreCase("white")) {
			color = BarColor.WHITE;
		} else if(configColor.equalsIgnoreCase("purple")) {
			color = BarColor.PURPLE;
		} else {
			color = BarColor.BLUE;
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§c==>> SimpleLobby <<==");
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§c=====================");
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§cInvalid bossbar color!");
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§cYour color in config: " + "§7" + configColor);
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§c===Valid Colors===");
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§7purple, blue, red, pink,");
			SimpleLobby.getInstance().getServer().getConsoleSender().sendMessage("§7green, yellow, & white.");
		}
		
		lobbyBar.setTitle(SimpleLobby.cfg.getString("Bossbar.Text").replace("&", "§").replace("%player%", player.getName()));
		lobbyBar.setColor(color);
		lobbyBar.addPlayer(player);
		lobbyBar.show();
		
	}

}
