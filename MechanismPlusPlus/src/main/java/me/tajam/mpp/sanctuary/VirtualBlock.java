package me.tajam.mpp.sanctuary;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import me.tajam.mpp.Log;

public class VirtualBlock {
  
  private final Vector vector;
  private final Material blockType;

  public VirtualBlock(final Vector vector, final Material blockType) {
    this.vector = vector;
    this.blockType = blockType;
  }

  public Block getBlock(final Block origin) {
    try {
      return origin.getRelative(
        this.vector.getBlockX(),
        this.vector.getBlockY(),
        this.vector.getBlockZ()
      );
    } catch (Exception e) {
      return null;
    }
  }

  public boolean checkBlock(final Block origin) {
    try {
      final Block block = this.getBlock(origin);
      if (block == null) return false;
      return (block.getType() == this.blockType);
    } catch (Exception e) {
      new Log().warn().t("Block check error!").send();
      return false;
    }
  }

}