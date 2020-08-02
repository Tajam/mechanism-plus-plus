package me.tajam.mpp.listener;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.tajam.mpp.configuration.ConfigReader;

public class PluginListener implements Listener {
  
  protected ConfigReader config;

  public PluginListener(final JavaPlugin plugin, final ConfigReader config) {
    this.config = config;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

}