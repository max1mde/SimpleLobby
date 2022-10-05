package dev.maximde.simplelobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.maximde.simplelobby.Main;
import dev.maximde.simplelobby.utils.Settings;

public class Spawn implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			teleportToSpawn(p);
		}
		return false;
	}
	
    public void teleportToSpawn(Player p) {
    	if(Settings.Spawn == null) {
    		if (p.hasPermission(Main.name.toLowerCase() + ".admin") || p.hasPermission(Main.prefixWithoutColor.toLowerCase() + ".cmd")) {
        		p.sendMessage("§cType /sl setspawn to set the spawn point!");

    		 } else {
        		p.sendMessage("§cNo spawn is set!");
    	     }
           return;
    	} 
    	
    	p.teleport(Settings.Spawn);
		p.sendMessage(Settings.teleportToSpawnMessage);
    }
}
