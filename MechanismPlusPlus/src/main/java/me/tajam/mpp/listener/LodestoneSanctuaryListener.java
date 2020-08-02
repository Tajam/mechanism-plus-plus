package me.tajam.mpp.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.tajam.mpp.configuration.ConfigReader;
import me.tajam.mpp.configuration.Configuration.Name;
import me.tajam.mpp.sanctuary.LodestoneSanctuary;

public class LodestoneSanctuaryListener extends PluginListener {

  private final LodestoneSanctuary sanctuary;
  private final double healthRequired;
  private final int poisonTime;
  private final int nauseaTime;

  public LodestoneSanctuaryListener(final JavaPlugin plugin, final LodestoneSanctuary sanctuary, final ConfigReader config) {
    super(plugin, config);
    this.sanctuary = sanctuary;
    this.healthRequired = config.getDouble(Name.HEALTH_REQUIRED);
    this.poisonTime = config.getInteger(Name.POISON_TIME);
    this.nauseaTime = config.getInteger(Name.NAUSEA_TIME);
  }

  @EventHandler()
  public void RequestEvent(final PlayerInteractEvent event) {
    if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
      final Player player = event.getPlayer();
      if (player.getGameMode() == GameMode.SURVIVAL && player.getHealth() < this.healthRequired && player.getFireTicks() > 0) {
        final ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        if (mainHandItem.getType() != Material.COMPASS) return;
        final CompassMeta compassMeta = (CompassMeta) mainHandItem.getItemMeta();
        if (!compassMeta.hasLodestone()) return;
        final Location location = compassMeta.getLodestone();
        final World world = location.getWorld();
        if (!player.getWorld().getName().equals(world.getName())) return;
        if (!sanctuary.checkSanctuary(location.getBlock(), new Vector(0, -4, 0))) return;
        player.setFireTicks(0);
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, this.poisonTime, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, this.nauseaTime, 1));
        player.teleport(location.add(new Vector(0, 1, 0)));
        world.playSound(location, Sound.BLOCK_PORTAL_TRAVEL, SoundCategory.BLOCKS, 2.0f, 1.5f);
      }
    }
  }

  @EventHandler()
  public void SummonEvent(final EntityDamageEvent event) {
    final Entity entity = event.getEntity();
    if(entity.getType() == EntityType.DROPPED_ITEM && event.getCause() == DamageCause.LAVA){
      if (entity instanceof Item) {
        final Item item = (Item) entity;
        final Location location = item.getLocation();
        final World world = location.getWorld();
        final ItemStack itemStack = item.getItemStack();
        final String name = itemStack.getItemMeta().getDisplayName();
        if (itemStack.getType() != Material.COMPASS) return;
        final Player player = Bukkit.getPlayerExact(name);
        if (player == null) return;
        if (!player.getWorld().getName().equals(world.getName())) return;
        if (player.getGameMode() == GameMode.SURVIVAL && player.getHealth() < this.healthRequired && player.getFireTicks() > 0) {
          entity.remove();
          if (!sanctuary.checkSanctuary(location.getBlock(), new Vector(0, -1, 0))) return;
          player.setFireTicks(0);
          player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, this.poisonTime, 1));
          player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, this.nauseaTime, 1));
          player.teleport(location.add(new Vector(0, 5, 0)));
          world.playSound(location, Sound.BLOCK_PORTAL_TRAVEL, SoundCategory.BLOCKS, 2.0f, 0.5f);
        }
      }
    }
  }
  
}