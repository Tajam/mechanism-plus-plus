package me.tajam.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class HealthRequired extends Configuration<Double> {

  public HealthRequired(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.HEALTH_REQUIRED;
  }

  @Override
  public Double getData() {
    return section.getDouble(getPath());
  }

  @Override
  protected String getPath() {
    return "lower-health-required";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setDouble(this);
  }
  
}