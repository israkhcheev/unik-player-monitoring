package minecraft.unik.rakhchik.monitoring.config;

import minecraft.unik.rakhchik.monitoring.PlayerMonitoringPlugin;

import java.util.Map;

public class MetricsConfig extends Config {

    private Map<String, Boolean> metrics;

    public MetricsConfig(PlayerMonitoringPlugin plugin) {
        super(plugin);
        loadConfig("metrics.yml");
    }

}
