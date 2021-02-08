package mmu.minecraft.mpp.configuration;

import org.bukkit.configuration.ConfigurationSection;

public class ElytraNerfActivatePlayer extends Configuration<Integer> {

  public ElytraNerfActivatePlayer(ConfigurationSection section) {
    super(section);
  }

  @Override
  public Name getName() {
    return Name.ELYTRA_NERF_ACTIVATE_PLAYER;
  }

  @Override
  public Integer getData() {
    return section.getInt(getPath());
  }

  @Override
  protected String getPath() {
    return "elytra-nerf-activate-player";
  }

  @Override
  public void register(ConfigReader reader) {
    reader.setInteger(this);
  }

}
