package dev.maximde.simplelobby.versions;
 
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
 
 
public class FireworkManager_1_8_8_R3{
 
    Location location;
    Player p;
    Location spawnlocation;
    Firework firework;
    FireworkMeta fireworkmeta;
    FireworkEffect fireworkeffect;
    int lifeTime = 0;
    int power;
    Plugin plugin;
    
    public FireworkManager_1_8_8_R3(Plugin plugin)
    {
        this.plugin = plugin;
    }
    
    /**
     * Method not used!
     */
    public void setPlayer(Player p) {
    	//nothing
    }
    
    /**
     * Set firework location
     */
    public void setLocation(Location location){
        this.location = location;
    }
    
    /**
     * Set firework power
     */
    public void setPower(int power){
        this.power = power;
    }
    
    /**
     * Set firework life time (how long it should exist until it explodes)
     */
    public void setLifeTime(int lifeTime){
        this.lifeTime = lifeTime;
    }

    /**
     * Set fireworkeffect (FireworkEffect)
     */
    public void setEffect(FireworkEffect fireworkEffect){
        this.fireworkeffect = fireworkEffect;
    }
    
    /**
     * Add effect to fireworkmeta (FireworkEffect)
     */
    public void addEffect(FireworkEffect fireworkEffect){
            if(this.fireworkeffect == null){
                this.fireworkeffect = fireworkEffect;
            }else{
                if(this.fireworkmeta != null){
            this.fireworkmeta.addEffect(fireworkEffect);
                }
            }
    }
    
    
    /**
     * Clears all effects from the firework (FireworkMeta)
     */
    public void clearEffect(){
        if(fireworkmeta != null){
        this.fireworkmeta.clearEffects();
        }
    }
    
    /**
     * Teleports the firework
     */
    public void teleport(Location location){
        this.location = location;
        if(firework != null){
        this.firework.teleport(this.location);
        }
    }
    
    /**
     * Makes the fireworks rocket explode
     */
    public void detonate(){
        if(firework != null){
        this.firework.detonate();
        }
    }
    
    /**
     * Spawns the firework
     */
    public void spawnFirework(){
        this.firework = (Firework)this.location.getWorld().spawnEntity(this.location, EntityType.FIREWORK);
        this.spawnlocation = this.location;
        this.fireworkmeta = (FireworkMeta)this.firework.getFireworkMeta();
        if(this.fireworkeffect != null){
        this.fireworkmeta.addEffect(this.fireworkeffect);
        }
        this.fireworkmeta.setPower(this.power);
        this.firework.setFireworkMeta(this.fireworkmeta);
        
        if(this.lifeTime != 0){
            Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable() {
                
                @Override
                public void run() {
                    detonate(); 
                }
            }, this.lifeTime);
        }
    }
    
    
    /**
     * @return Current location of the firework
     */
    public Location getLocation(){
        return firework.getLocation();
    }
    
    /**
     * @return Spawn location of the firework
     */
    public Location getSpawnLocaton(){
        return this.spawnlocation;
    }
 
}