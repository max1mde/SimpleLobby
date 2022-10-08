package dev.maximde.simplelobby.versions.scoreboard;

import org.bukkit.entity.Player;

public interface ScoreboardUtil {

	public void setScoreboard(Player p, String title, String... lines);
}
