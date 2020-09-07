package mmu.minecraft.mpp;

import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mpp.configuration.ConfigReader;
import mmu.minecraft.mpp.configuration.ConfigReaderGlobal;
import mmu.minecraft.mpp.listener.BeheadedListener;
import mmu.minecraft.mpp.listener.ElderGuardianPotionListener;
import mmu.minecraft.mpp.listener.ElytraNerfListener;
import mmu.minecraft.mpp.listener.PhantomRepelListener;
import mmu.minecraft.mpp.listener.LodestoneSanctuaryListener;
import mmu.minecraft.mpp.namespace.MPPNamespace;
import mmu.minecraft.mpp.sanctuary.LodestoneSanctuary;

public class MPP extends JavaPlugin {
  
  @Override
  public void onEnable() {
    try {
      load();
      new Log().okay().t("Enabled M++!").send();
    } catch (Exception e) {
      new Log().eror().t("Error when enabling M++!").send();
      e.printStackTrace();
      this.getServer().getPluginManager().disablePlugin(this);
    }
  }

  @Override
  public void onDisable() {
    new Log().warn().t("Disabled M++!").send();
  }

  private void load() {
    /* Temporary configuration implementation */
    this.saveDefaultConfig();
    ConfigReader config = new ConfigReaderGlobal(this.getConfig());

    MPPNamespace.getInstance().registerNamespace(this);

    LodestoneSanctuary sanctuary = new LodestoneSanctuary();
    new LodestoneSanctuaryListener(this, sanctuary, config);
    new BeheadedListener(this);
    new PhantomRepelListener(this);
    new ElytraNerfListener(this, config);
    new ElderGuardianPotionListener(this);

  }

}
