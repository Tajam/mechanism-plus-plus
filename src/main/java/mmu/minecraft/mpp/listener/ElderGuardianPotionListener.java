package mmu.minecraft.mpp.listener;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class ElderGuardianPotionListener extends PluginListener {

  public ElderGuardianPotionListener(JavaPlugin plugin) {
    super(plugin, null);
  }

  @EventHandler()
  public void GetMiningFatiguePotion(PlayerInteractEntityEvent event) {
    final Entity entity = event.getRightClicked();
    final PlayerInventory inventory = event.getPlayer().getInventory();
    final ItemStack item = inventory.getItemInMainHand();
    if (item != null && (item.getType() == Material.POTION || item.getType() == Material.SPLASH_POTION) && entity instanceof ElderGuardian) {
      final PotionMeta m1 = (PotionMeta)item.getItemMeta();
      if (m1.getBasePotionData().getType() == PotionType.WATER) {
        final ItemStack potion = new ItemStack(item.getType());
        final PotionMeta m2 = (PotionMeta)potion.getItemMeta();
        m2.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1200, 2), true);
        m2.setColor(Color.GRAY);
        String name = "Potion of Mining Fatigue";
        if (item.getType() == Material.SPLASH_POTION) {
          name = "Splash " + name;
        }
        m2.setDisplayName(name);
        potion.setItemMeta(m2);
        item.setAmount(item.getAmount() - 1);
        inventory.addItem(potion);
      }
    }
  }
  
}