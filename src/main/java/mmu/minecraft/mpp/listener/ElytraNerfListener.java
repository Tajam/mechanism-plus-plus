package mmu.minecraft.mpp.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mpp.configuration.ConfigReader;
import mmu.minecraft.mpp.configuration.Configuration.Name;

public class ElytraNerfListener extends PluginListener {

  private int damageMultiplier;
  private int mendMultiplier;
  private int boostDamage;
  private int activatePlayerCount;

  public ElytraNerfListener(JavaPlugin plugin, ConfigReader config) {
    super(plugin, config);
    this.damageMultiplier = config.getInteger(Name.ELYTRA_DAMAGE_MULTIPLIER);
    if (this.damageMultiplier < 1) {
      this.damageMultiplier = 1;
    }
    this.mendMultiplier = config.getInteger(Name.ELYTRA_MEND_MULTIPLIER);
    if (this.mendMultiplier < 1) {
      this.mendMultiplier = 1;
    }
    this.boostDamage = config.getInteger(Name.ELYTRA_BOOST_DAMAGE);
    if (this.boostDamage < 0) {
      this.boostDamage = 0;
    }
    this.activatePlayerCount = config.getInteger(Name.ELYTRA_NERF_ACTIVATE_PLAYER);
    if (this.activatePlayerCount < 0) {
      this.activatePlayerCount = 0;
    }
  }

  @EventHandler()
  public void ElytraUseEvent(final PlayerItemDamageEvent event) {
    // disable nerf if player count lower than configured value
    if (this.activatePlayerCount < Bukkit.getOnlinePlayers().size()) return;

    final ItemStack elytra = event.getItem();
    final int damageTaken = event.getDamage();
    if (elytra.getType() == Material.ELYTRA) {
      final Damageable damageable = (Damageable) elytra.getItemMeta();
      final int currentDamage = damageable.getDamage();
      final int maxDurability = Material.ELYTRA.getMaxDurability();
      event.setCancelled(true);
      int damageValue = currentDamage + damageTaken * damageMultiplier;
      if (damageValue > maxDurability) {
        damageValue = maxDurability;
      }
      damageable.setDamage(damageValue);
      elytra.setItemMeta((ItemMeta) damageable);
    }
  }

  @EventHandler()
  public void RocketBoostEvent(final PlayerInteractEvent event) {
    // disable nerf if player count lower than configured value
    if (this.activatePlayerCount < Bukkit.getOnlinePlayers().size()) return;

    final Player player = event.getPlayer();
    final ItemStack usedItem = event.getItem();
    if (player.isGliding() && usedItem != null && usedItem.getType() == Material.FIREWORK_ROCKET && event.getAction() == Action.RIGHT_CLICK_AIR) {
      final ItemStack elytra = player.getInventory().getChestplate();
      if (elytra != null && elytra.getType() == Material.ELYTRA) {
        final Damageable damageable = (Damageable) elytra.getItemMeta();
        final int maxDurability = Material.ELYTRA.getMaxDurability();
        int damageValue = damageable.getDamage() + this.boostDamage;
        if (damageValue > maxDurability) {
          damageValue = maxDurability;
        }
        damageable.setDamage(damageValue);
        elytra.setItemMeta((ItemMeta) damageable);
      }
    }
  }

  @EventHandler()
  public void RiptideBoostEvent(final PlayerRiptideEvent event) {
    // disable nerf if player count lower than configured value
    if (this.activatePlayerCount < Bukkit.getOnlinePlayers().size()) return;

    final Player player = event.getPlayer();
    final ItemStack elytra = player.getInventory().getChestplate();
    if (player.isGliding() && elytra != null && elytra.getType() == Material.ELYTRA) {
      final Damageable damageable = (Damageable) elytra.getItemMeta();
      final int maxDurability = Material.ELYTRA.getMaxDurability();
      int damageValue = damageable.getDamage() + this.boostDamage;
      if (damageValue > maxDurability) {
        damageValue = maxDurability;
      }
      damageable.setDamage(damageValue);
      elytra.setItemMeta((ItemMeta) damageable);
    }
  }

  @EventHandler()
  public void ElytraMendEvent(final PlayerItemMendEvent event) {
    // disable buff if player count lower than configured value
    if (this.activatePlayerCount < Bukkit.getOnlinePlayers().size()) return;

    final ItemStack elytra = event.getItem();
    if (elytra != null && elytra.getType() == Material.ELYTRA) {
      event.setRepairAmount(event.getRepairAmount() * 2);
    }
  }
  
}