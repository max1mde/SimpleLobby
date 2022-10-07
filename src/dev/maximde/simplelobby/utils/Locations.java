package dev.maximde.simplelobby.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import dev.maximde.simplelobby.SimpleLobby;



public class Locations {

	public static File folder = new File("plugins/"+SimpleLobby.name+"/");
	public static File file = new File("plugins/"+SimpleLobby.name+"/locations.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
    /**
     * Creates files if not existing
     */
	public static void setupFiles(){
		if(!folder.exists()){
			folder.mkdir();
		}
		
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
    /**
     * Save locations in locations.yml
     */
	public static void saveLocations(){
		try {
			cfg.save(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Set location with name and location
	 * @param name (LocationName)
	 * @param loc (Location)
	 */
	public static void setLocation(String name, Location loc){
		double x = loc.getBlockX() + 0.5;
		double y = loc.getBlockY();
		double z = loc.getBlockZ() + 0.5;
		double yaw = Math.round(loc.getYaw() / 45) * 45;
		double pitch = Math.round(loc.getPitch() / 45) * 45;
		String worldName = loc.getWorld().getName();
		cfg.set("Locations." + name + ".X", x);
		cfg.set("Locations." + name + ".Y", y);
		cfg.set("Locations." + name + ".Z", z);
		cfg.set("Locations." + name + ".Yaw", yaw);
		cfg.set("Locations." + name + ".Pitch", pitch);
		cfg.set("Locations." + name + ".worldName", worldName);
		saveLocations();
	}
	
	/**
	 * Remove existing location in locations.yml by location name
	 * @param name (LocationName)
	 */
	public static void removeLocation(String name){
		String path = "Locations." + name;
		cfg.set(path, null);
		saveLocations();
	}
	
	/**
	 * Check location exists in locations.yml by location name
	 * @param name (LocationName)
	 * @return boolean (LocationExists)
	 */
	public static boolean locationIsExisting(String name){
		return cfg.get("Locations." + name) != null ? true : false;
	}
	
	/**
	 * Get location from locations.yml by location name
	 * @param name (LocationName)
	 * @return Location
	 */
	public static Location getLocation(String name){
		double x = cfg.getDouble("Locations." + name + ".X");
		double y = cfg.getDouble("Locations." + name + ".Y");
		double z = cfg.getDouble("Locations." + name + ".Z");
		double yaw = cfg.getDouble("Locations." + name + ".Yaw");
		double pitch = cfg.getDouble("Locations." + name + ".Pitch");
		String worldName = cfg.getString("Locations." + name + ".worldName");
		Location location = new Location(Bukkit.getWorld(worldName), x, y, z);
		location.setYaw((float) yaw);
		location.setPitch((float) pitch);
		return location;
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}