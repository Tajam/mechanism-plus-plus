package mmu.minecraft.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class ElytraMendMultiplier extends Configuration<Integer> {

  public ElytraMendMultiplier(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.ELYTRA_MEND_MULTIPLIER;
  }

  @Override
  public Integer getData() {
    return section.getInt(getPath());
  }

  @Override
  protected String getPath() {
    return "elytra-mend-multiplier";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setInteger(this);
  }

}
