package dev.maximde.simplelobby.versions.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class ScoreboardUtil_1_8_R3 implements ScoreboardUtil {
	
	/**
	 * Get plugin instance from main class
	 */
	  public Plugin plugin = SimpleLobby.getInstance();

	  /**
	   * Set scoreboard for a player
	   * @param p
	   * @param title
	   * @param lines
	   */
	  public void setScoreboard(Player p, String title, String... lines) {
			if(Settings.Spawn == null)return;
	    	if(SimpleLobby.cfg.getBoolean("Scoreboard.onlyInLobbyWorld") && !p.getLocation().getWorld().getName().equals(Settings.Spawn.getWorld().getName())) {
	    		return;
	    	}
	            	ScoreboardManager sm = Bukkit.getScoreboardManager();
	            	Scoreboard board = sm.getNewScoreboard();
	            	Objective o = board.registerNewObjective("lobbyboard", "dummy");
	            	o.setDisplaySlot(DisplaySlot.SIDEBAR);
	            	o.setDisplayName(title.replace("&", "§").replace("%player%", p.getName()));
	            	o.getScore(lines[0].replace("&", "§").replace("%player%", p.getName())).setScore(10);
	            	o.getScore(lines[1].replace("&", "§").replace("%player%", p.getName())).setScore(9);
	            	o.getScore(lines[2].replace("&", "§").replace("%player%", p.getName())).setScore(8);
	            	o.getScore(lines[3].replace("&", "§").replace("%player%", p.getName())).setScore(7);
	            	o.getScore(lines[4].replace("&", "§").replace("%player%", p.getName())).setScore(6); 
	            	o.getScore(lines[5].replace("&", "§").replace("%player%", p.getName())).setScore(5);
	            	o.getScore(lines[6].replace("&", "§").replace("%player%", p.getName())).setScore(4);
	            	o.getScore(lines[7].replace("&", "§").replace("%player%", p.getName())).setScore(3);
	            	o.getScore(lines[8].replace("&", "§").replace("%player%", p.getName())).setScore(2);
	            	o.getScore(lines[9].replace("&", "§").replace("%player%", p.getName())).setScore(1);
	            	o.getScore(lines[10].replace("&", "§").replace("%player%", p.getName())).setScore(0);
	                p.setScoreboard(board);  
	  }
	
}
