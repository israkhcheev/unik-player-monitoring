package minecraft.unik.rakhchik.monitoring.config;

import minecraft.unik.rakhchik.monitoring.PlayerMonitoringPlugin;

import java.util.Map;

public class PluginConfig extends Config {

    private Map<String, Boolean> metrics;

    public PluginConfig(PlayerMonitoringPlugin plugin) {
        super(plugin);
        loadConfig("config.yml");
    }

}
