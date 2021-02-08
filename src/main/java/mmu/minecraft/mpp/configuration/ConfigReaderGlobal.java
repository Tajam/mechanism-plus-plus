package mmu.minecraft.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class ConfigReaderGlobal extends ConfigReader {

  public ConfigReaderGlobal(ConfigurationSection section) {
    super(section);
  }

  @Override
  public void load() {
    new HealthRequired(section).register(this);
    new NauseaTime(section).register(this);
    new PoisonTime(section).register(this);
    new ElytraBoostDamage(section).register(this);
    new ElytraDamageMultiplier(section).register(this);
    new ElytraMendMultiplier(section).register(this);
  }
  
}