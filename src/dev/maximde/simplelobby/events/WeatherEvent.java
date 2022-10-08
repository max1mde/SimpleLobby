package dev.maximde.simplelobby.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import dev.maximde.simplelobby.SimpleLobby;

public class WeatherEvent implements Listener {
	
	@EventHandler
	public void onWeather(WeatherChangeEvent e) {
		if(SimpleLobby.cfg.getBoolean("Config.DisableWeatherChange")) {
		e.setCancelled(true);
		}
	}

}
