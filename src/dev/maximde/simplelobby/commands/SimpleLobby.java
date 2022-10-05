package dev.maximde.simplelobby.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.maximde.simplelobby.Main;
import dev.maximde.simplelobby.utils.Settings;
import dev.maximde.simplelobby.utils.Config;
import dev.maximde.simplelobby.utils.Locations;
import dev.maximde.simplelobby.utils.NPCs;

public class SimpleLobby implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			/*If player has perms*/  if (p.hasPermission(Main.name.toLowerCase() + ".admin") || p.hasPermission(Main.prefixWithoutColor.toLowerCase() + ".cmd")) {
			
				
			if(args.length == 0) {
            sendCMDListAdmin(p);
			} else if (args.length == 1) {
				switch(args[0])
				{
				case "setspawn":
					Settings.Spawn = p.getLocation();
					Settings.lobbyWorldName = p.getLocation().getWorld().getName();
					Locations.setLocation("Spawn", p.getLocation());
					Locations.saveLocations();
					Main.reloadConfigCMD();
					p.sendMessage("§aLobby spawnpoint set!");	
					break;
					
				case "reload":
					Main.reloadConfigCMD();

					p.sendMessage(Settings.prefix + "§aConfig reloaded!");	
					break;
					
				case "spawn":
					teleportToSpawn(p);
					break;
					
				case "hub":
					teleportToSpawn(p);
					break;
					
				case "lobby":
					teleportToSpawn(p);
					break;
					
				case "l":
					teleportToSpawn(p);
					break;
				
				default:
		            sendCMDListAdmin(p);
		            break;
				}
				
			} else if (args.length == 2) {
				
				
				
			} else if (args.length == 3) {
				switch(args[0])
				{
				case "createnpc":
					NPCs.createNPC(p, args[1], Boolean.getBoolean(args[2]));
					break;
				default:
		            sendCMDListAdmin(p);
		            break;
				}
				
			} else {
	            sendCMDListAdmin(p);
			}
			
			
			/*If player has no perms*/} else { /*------------------------------*/

				if(args.length == 0) {
		            sendCMDList(p);
					} else if (args.length == 1) {
						switch(args[0])
						{
						case "spawn":
							teleportToSpawn(p);
							break;
						
						case "hub":
							teleportToSpawn(p);
							break;
							
						case "lobby":
							teleportToSpawn(p);
							break;
							
						case "l":
							teleportToSpawn(p);
							break;
							
						default:
				            sendCMDList(p);
				            break;
						}
						
					} else if (args.length == 2) {
						
						
						
					} else {
			            sendCMDList(p);
					}

			}/*----------------------------------------------------------------*/
		}
		return false;
	}
	
	
	
    void sendCMDList(Player p) {
    	//TODO
    	p.sendMessage(Main.prefix + "§f----Commands----");
		p.sendMessage(Main.prefix + "§6/" + Main.nameK.toLowerCase() + " spawn");
		p.sendMessage(Main.prefix + "§f----------------");
    }
    
    void sendCMDListAdmin(Player p) {
    	//TODO
    	p.sendMessage(Main.prefix + "§f----Commands----");
		p.sendMessage(Main.prefix + "§6/" + Main.nameK.toLowerCase() + " spawn");
		p.sendMessage(Main.prefix + "§6/" + Main.nameK.toLowerCase() + " reload");
		p.sendMessage(Main.prefix + "§6/" + Main.nameK.toLowerCase() + " setspawn");
		p.sendMessage(Main.prefix + "§f----------------");
    }
    
    String boolTM(boolean b) {
    	if(b) {
    		return " = §aEnabled ✔";
    	} else {
    		return " = §cDisabled ✘";
    	}
    }
    
    public void teleportToSpawn(Player p) {
    	if(Settings.Spawn == null) {
    		if (p.hasPermission(Main.prefixWithoutColor.toLowerCase() + ".admin") || p.hasPermission(Main.prefixWithoutColor.toLowerCase() + ".cmd")) {
        		p.sendMessage("§cType /sl setspawn to set the spawn point!");

    		 } else {
        		p.sendMessage("§cNo spawn is set!");
    	     }
           return;
    	} 
    	
    	p.teleport(Settings.Spawn);
		p.sendMessage(Settings.teleportToSpawnMessage);
    }
    
    public static void saveSettingsInConfig() {
    	//TODO save settings
    }
    
    public static void resetSettings() {
    	//TODO reset settings
    	saveSettingsInConfig();
    }
}
