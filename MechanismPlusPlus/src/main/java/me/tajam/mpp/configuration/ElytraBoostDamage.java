package me.tajam.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class ElytraBoostDamage extends Configuration<Integer> {

  public ElytraBoostDamage(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.ELYTRA_BOOST_DAMAGE;
  }

  @Override
  public Integer getData() {
    return section.getInt(getPath());
  }

  @Override
  protected String getPath() {
    return "elytra-boost-damage";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setInteger(this);
  }
  
}