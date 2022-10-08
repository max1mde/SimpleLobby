package dev.maximde.simplelobby.versions.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import dev.maximde.simplelobby.SimpleLobby;
import dev.maximde.simplelobby.utils.Settings;

public class ScoreboardUtil_1_9_R1 implements ScoreboardUtil {
	
	/**
	 * Get plugin instance from main class
	 */
	public Plugin plugin = SimpleLobby.getInstance();

	/**
	 * Set scoreboard for a player
	 * @param p (Player)
	 * @param title (String)
	 * @param lines (String...)
	 */
	public void setScoreboard(Player p, String title, String... lines) {
		if(Settings.Spawn == null)return;
    	if(SimpleLobby.cfg.getBoolean("Scoreboard.onlyInLobbyWorld") && !p.getLocation().getWorld().getName().equals(Settings.Spawn.getWorld().getName())) {
    		return;
    	}
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            public void run() {        
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                final Scoreboard board = manager.getNewScoreboard();
                final Objective objective = board.registerNewObjective("lobbyboard", "dummy");        
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(title.replace("&", "§"));
                Score score = objective.getScore(lines[0].replace("&", "§").replace("%player%", p.getName()));
                score.setScore(10);            
                Score score1 = objective.getScore(lines[1].replace("&", "§").replace("%player%", p.getName()));
                score1.setScore(9);        
                Score score2 = objective.getScore(lines[2].replace("&", "§").replace("%player%", p.getName()));
                score2.setScore(8);                        
                Score score3 = objective.getScore(lines[3].replace("&", "§").replace("%player%", p.getName()));
                score3.setScore(7);
                Score score4 = objective.getScore(lines[4].replace("&", "§").replace("%player%", p.getName()));
                score4.setScore(6);        
                Score score5 = objective.getScore(lines[5].replace("&", "§").replace("%player%", p.getName()));
                score5.setScore(5);                        
                Score score6 = objective.getScore(lines[6].replace("&", "§").replace("%player%", p.getName()));
                score6.setScore(4);
                Score score7 = objective.getScore(lines[7].replace("&", "§").replace("%player%", p.getName()));
                score7.setScore(3);
                Score score8 = objective.getScore(lines[8].replace("&", "§").replace("%player%", p.getName()));
                score8.setScore(2);
                Score score9 = objective.getScore(lines[9].replace("&", "§").replace("%player%", p.getName()));
                score9.setScore(1);
                Score score10 = objective.getScore(lines[10].replace("&", "§").replace("%player%", p.getName()));
                score10.setScore(0);
                p.setScoreboard(board);
            }
        },0, 20 * 10);
	}

}
