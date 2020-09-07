package me.tajam.mpp;

import org.bukkit.plugin.java.JavaPlugin;

import me.tajam.mpp.configuration.ConfigReader;
import me.tajam.mpp.configuration.ConfigReaderGlobal;
import me.tajam.mpp.listener.BeheadedListener;
import me.tajam.mpp.listener.ElderGuardianPotionListener;
import me.tajam.mpp.listener.ElytraNerfListener;
import me.tajam.mpp.listener.PhantomRepelListener;
import me.tajam.mpp.listener.LodestoneSanctuaryListener;
import me.tajam.mpp.namespace.MPPNamespace;
import me.tajam.mpp.sanctuary.LodestoneSanctuary;

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
