package dev.maximde.simplelobby.versions;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;

import dev.maximde.simplelobby.SimpleLobby;

public class FireworkManager_1_11_to_1_19 {
	
	public static void spawn(Player p) {
	      Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)SimpleLobby.getInstance(), new Runnable() {
	            public void run() {
	              Firework f = (Firework)p.getWorld().spawn(p.getLocation(), Firework.class);
	              FireworkMeta fm = f.getFireworkMeta();
	              fm.addEffect(FireworkEffect.builder()
	                  .flicker(true)
	                  .trail(true)
	                  .with(FireworkEffect.Type.BALL)
	                  .withColor(Color.ORANGE)
	                  .build());
	              fm.setPower(0);
	              f.setFireworkMeta(fm);
	            }
	        }, 5L);
	}

}
