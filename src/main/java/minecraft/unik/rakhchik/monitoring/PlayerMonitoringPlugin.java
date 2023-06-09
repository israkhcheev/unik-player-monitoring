package minecraft.unik.rakhchik.monitoring;

import minecraft.unik.rakhchik.monitoring.handler.MetricHandler;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PlayerMonitoringPlugin extends JavaPlugin {

    private  MetricHandler metricHandler;

    protected void registerMetricHandler(MetricHandler metricHandler) {
        this.metricHandler = metricHandler;
    }

    public void initConfig() {

    }

}
