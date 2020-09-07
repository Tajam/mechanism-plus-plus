package mmu.minecraft.mpp.namespace;

import java.util.HashMap;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mpp.namespace.MPPNamespace.DefinedNamespace;

public class SafetyCharmType extends Namespace {

  SafetyCharmType(JavaPlugin plugin, HashMap<DefinedNamespace, NamespacedKey> namespaceMap) {
    super(plugin, namespaceMap);
  }

  @Override
  public DefinedNamespace getKey() {
    return DefinedNamespace.SAFETY_CHARM_TYPE;
  }
  
}