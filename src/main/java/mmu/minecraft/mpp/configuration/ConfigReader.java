package mmu.minecraft.mpp.configuration;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;

import mmu.minecraft.mpp.configuration.Configuration.Name;

public abstract class ConfigReader {

  protected ConfigurationSection section;
  private Map<Name, Configuration<String>> stringData;
  private Map<Name, Configuration<Integer>> integerData;
  private Map<Name, Configuration<Double>> doubleData;
  private Map<Name, Configuration<Boolean>> booleanData;
  

  public ConfigReader(ConfigurationSection section) {
    this.section = section;
    stringData = new HashMap<>();
    integerData = new HashMap<>();
    doubleData = new HashMap<>();
    booleanData = new HashMap<>();
    load();
  }

  public void setString(Configuration<String> configuration) {
    stringData.put(configuration.getName(), configuration);
  }

  public void setInteger(Configuration<Integer> configuration) {
    integerData.put(configuration.getName(), configuration);
  }

  public void setDouble(Configuration<Double> configuration) {
    doubleData.put(configuration.getName(), configuration);
  }

  public void setBoolean(Configuration<Boolean> configuration) {
    booleanData.put(configuration.getName(), configuration);
  }

  public String getString(Name name) {
    Configuration<String> config = stringData.get(name);
    if (config == null) return "";
    return config.getData();
  }

  public Integer getInteger(Name name) {
    Configuration<Integer> config = integerData.get(name);
    if (config == null) return 0;
    return config.getData();
  }

  public Double getDouble(Name name) {
    Configuration<Double> config = doubleData.get(name);
    if (config == null) return 0.0;
    return config.getData();
  }

  public Boolean getBoolean(Name name) {
    Configuration<Boolean> config = booleanData.get(name);
    if (config == null) return false;
    return config.getData();
  }

  public abstract void load();
}