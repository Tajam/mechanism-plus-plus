package me.tajam.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class ElytraDamageMultiplier extends Configuration<Integer> {

  public ElytraDamageMultiplier(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.ELYTRA_DAMAGE_MULTIPLIER;
  }

  @Override
  public Integer getData() {
    return section.getInt(getPath());
  }

  @Override
  protected String getPath() {
    return "elytra-damage-multiplier";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setInteger(this);
  }
  
}