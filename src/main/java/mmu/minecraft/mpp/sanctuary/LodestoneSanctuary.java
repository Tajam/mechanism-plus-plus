package mmu.minecraft.mpp.sanctuary;

import org.bukkit.Material;
import org.bukkit.util.Vector;

public class LodestoneSanctuary extends Sanctuary {

  @Override
  public void Setup() {
    /* y = 0 */
    super.setBlock(new VirtualBlock(new Vector(0, 0, 0), Material.CRYING_OBSIDIAN));

    /* y = 1 */
    super.setBlock(new VirtualBlock(new Vector(-1, 1, 0), Material.CRYING_OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 1, -1), Material.CRYING_OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 1, 0), Material.LAVA));
    super.setBlock(new VirtualBlock(new Vector(0, 1, 1), Material.CRYING_OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(1, 1, 0), Material.CRYING_OBSIDIAN));

    /* y = 2 */
    super.setBlock(new VirtualBlock(new Vector(-2, 2, 0), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 2, -2), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 2, 2), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(2, 2, 0), Material.OBSIDIAN));

    /* y = 3 */
    super.setBlock(new VirtualBlock(new Vector(-2, 3, 0), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 3, -2), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 3, 2), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(2, 3, 0), Material.OBSIDIAN));

    /* y = 4 */
    super.setBlock(new VirtualBlock(new Vector(-1, 4, 0), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 4, -1), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(0, 4, 0), Material.LODESTONE));
    super.setBlock(new VirtualBlock(new Vector(0, 4, 1), Material.OBSIDIAN));
    super.setBlock(new VirtualBlock(new Vector(1, 4, 0), Material.OBSIDIAN));
  }
  
}