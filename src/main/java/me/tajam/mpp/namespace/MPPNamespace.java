package me.tajam.mpp.namespace;

import java.util.HashMap;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class MPPNamespace {

  private static MPPNamespace instance = null;
  public static MPPNamespace getInstance() {
    if (instance == null) {
      instance = new MPPNamespace();
    }
    return instance;
  }

  public enum DefinedNamespace {
    SAFETY_CHARM_TYPE("mpp.safety_charm_type"),
    IDENTIFIER("mpp.identifier")
    ;

    private String value;

    private DefinedNamespace(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }

  }

  private HashMap<DefinedNamespace, NamespacedKey> namespaceMap;

  private MPPNamespace() {
    namespaceMap = new HashMap<>();
  }

  public void registerNamespace(JavaPlugin plugin) {
    
  }

  public NamespacedKey get(DefinedNamespace key) {
    return this.namespaceMap.get(key);
  }

}