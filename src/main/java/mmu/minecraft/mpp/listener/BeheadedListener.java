package mmu.minecraft.mpp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class BeheadedListener extends PluginListener {

  public BeheadedListener(JavaPlugin plugin) {
    super(plugin, null);
  }

  @EventHandler(priority = EventPriority.NORMAL)
  public void BeheadedEvent(final PlayerDeathEvent event) {
    final Player victim = event.getEntity();
    final Player killer = victim.getKiller();
    final ItemStack helmet = victim.getInventory().getHelmet();
    if (helmet != null && helmet.getType() == Material.GOLDEN_HELMET) {
      final ItemStack weapon = killer.getInventory().getItemInMainHand();
      if (weapon != null && weapon.getType() == Material.GOLDEN_AXE) {
        final ItemStack victimSkull = new ItemStack(Material.PLAYER_HEAD, 1);
        final SkullMeta victimSkullMeta = (SkullMeta) victimSkull.getItemMeta();
        victimSkullMeta.setOwningPlayer(victim);
        victimSkull.setItemMeta(victimSkullMeta);
        event.getDrops().add(victimSkull);
      }
    }
  }
  
}