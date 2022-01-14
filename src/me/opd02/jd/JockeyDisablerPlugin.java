package me.opd02.jd;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JockeyDisablerPlugin extends JavaPlugin implements Listener {
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
    @EventHandler
    public void onSpawn(SpawnerSpawnEvent event) {
        if (event.getEntityType().equals(EntityType.PIG_ZOMBIE) && this.getConfig().getBoolean("disableZombiePigmanJockey")) {
            if (event.getEntity().getVehicle()!=null) {
                event.getEntity().getVehicle().remove();
            }
        }
        else if (event.getEntityType().equals(EntityType.SKELETON) && this.getConfig().getBoolean("disableSkeltonJockey")) {
            if (event.getEntity().getVehicle()!=null) {
                event.getEntity().getVehicle().remove();
            }
        }
        else if (event.getEntityType().equals(EntityType.ZOMBIE) && this.getConfig().getBoolean("disableZombieJockey")) {
            if (event.getEntity().getVehicle()!=null) {
                event.getEntity().getVehicle().remove();
            }
        }
    }

}
