package mmu.minecraft.mpp.namespace;

import java.util.HashMap;

import mmu.minecraft.mpp.namespace.MPPNamespace.DefinedNamespace;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

abstract class Namespace {

  Namespace (JavaPlugin plugin, HashMap<DefinedNamespace, NamespacedKey> namespaceMap) {
    final NamespacedKey namespacedKey = new NamespacedKey(plugin, getKey().toString());
    namespaceMap.put(getKey(), namespacedKey);
  }

  abstract public DefinedNamespace getKey();

}