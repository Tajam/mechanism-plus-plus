package mmu.minecraft.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class PoisonTime extends Configuration<Integer> {

  public PoisonTime(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.POISON_TIME;
  }

  @Override
  public Integer getData() {
    return section.getInt(getPath());
  }

  @Override
  protected String getPath() {
    return "poison-length";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setInteger(this);
  }
  
}