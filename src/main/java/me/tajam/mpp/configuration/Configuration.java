package me.tajam.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public abstract class Configuration<T> {
  
  public enum Name {
    HEALTH_REQUIRED,
    POISON_TIME,
    NAUSEA_TIME,
    ELYTRA_DAMAGE_MULTIPLIER,
    ELYTRA_BOOST_DAMAGE
  }

  protected ConfigurationSection section;

  public Configuration(ConfigurationSection section) {
    this.section = section;
  }

  public abstract Name getName();
  public abstract T getData();
  public abstract void register(ConfigReader reader);
  protected abstract String getPath();

}