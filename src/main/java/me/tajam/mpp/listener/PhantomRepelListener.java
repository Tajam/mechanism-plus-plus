package me.tajam.mpp.listener;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PhantomRepelListener extends PluginListener {

  public PhantomRepelListener(JavaPlugin plugin) {
    super(plugin, null);
  }

  @EventHandler()
  public void PhantomRepelEvent(final EntityTargetLivingEntityEvent event) {
    LivingEntity target = event.getTarget();
    Entity entity = event.getEntity();
    TargetReason reason = event.getReason();
    if (target instanceof Player && entity instanceof Phantom) {
      Player player = (Player) target;
      if (reason.equals(TargetReason.CLOSEST_PLAYER)) {
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        ItemStack offHandItem = player.getInventory().getItemInOffHand();
        if (mainHandItem.getType() == Material.CRIMSON_FUNGUS || offHandItem.getType() == Material.CRIMSON_FUNGUS) {
          event.setCancelled(true);
        }
      }
    }
  }
  
}