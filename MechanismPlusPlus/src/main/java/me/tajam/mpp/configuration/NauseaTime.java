package me.tajam.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class NauseaTime extends Configuration<Integer> {

  public NauseaTime(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.NAUSEA_TIME;
  }

  @Override
  public Integer getData() {
    return section.getInt(getPath());
  }

  @Override
  protected String getPath() {
    return "nausea-length";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setInteger(this);
  }
  
}