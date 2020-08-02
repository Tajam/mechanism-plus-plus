package me.tajam.mpp.sanctuary;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.util.Vector;

public abstract class Sanctuary {

  private final List<VirtualBlock> virtualBlocks = new ArrayList<>();

  protected Sanctuary() {
    Setup();
  }

  protected void setBlock(final VirtualBlock block) {
    this.virtualBlocks.add(block);
  }

  public boolean checkSanctuary(final Block origin) {
    return this.checkSanctuary(origin, new Vector(0, 0, 0));
  }

  public boolean checkSanctuary(final Block target, final Vector offset) {
    final Block origin = target.getRelative(offset.getBlockX(), offset.getBlockY(), offset.getBlockZ());
    for (final VirtualBlock virtualBlock : this.virtualBlocks) {
      if (!virtualBlock.checkBlock(origin)) return false;
    }
    return true;
  }

  public abstract void Setup();

}