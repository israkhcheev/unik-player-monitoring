package minecraft.unik.rakhchik.monitoring.config;

import minecraft.unik.rakhchik.monitoring.PlayerMonitoringPlugin;

import java.io.*;
import java.nio.file.Files;

public enum MetricConfig {

    DEATH_METRIC(false);

    private boolean enable;

    MetricConfig(boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return enable;
    }

    public void enable() {
        this.enable = true;
    }

    public void disable() {
        this.enable = false;
    }


    public static void init(PlayerMonitoringPlugin plugin) {
        File metricConfig = new File(plugin.getDataFolder(), "metricConfig.yml");

    }

    private static void checkFile(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();

        }
    }


}
