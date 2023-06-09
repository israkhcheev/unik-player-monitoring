package minecraft.unik.rakhchik.monitoring.config;

import minecraft.unik.rakhchik.monitoring.PlayerMonitoringPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public abstract class Config {

    private final PlayerMonitoringPlugin plugin;

    protected Config(PlayerMonitoringPlugin plugin) {
        this.plugin = plugin;
    }

    protected void reloadMetricsConfig(String configName) {
        File metricsConfigFile = new File(plugin.getDataFolder(), configName);
        FileConfiguration metricsConfiguration = YamlConfiguration.loadConfiguration(metricsConfigFile);
        setDefaultIfExist(metricsConfiguration, configName);
    }

    protected void setDefaultIfExist(FileConfiguration config, String configName) {
        InputStream is = plugin.getResource(configName);
        if (Objects.nonNull(is)) {
            Reader defaultConfigurationReader = new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8);
            config.setDefaults(YamlConfiguration.loadConfiguration(defaultConfigurationReader));
        }
    }

}
