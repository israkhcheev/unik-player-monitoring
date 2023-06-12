package minecraft.unik.rakhchik.monitoring;


import minecraft.unik.rakhchik.monitoring.handler.MetricHandler;

import java.lang.reflect.InvocationTargetException;

public final class PlayerMonitoring extends PlayerMonitoringPlugin {

    @Override
    public void onEnable() {
//        Bukkit.getPluginManager().registerEvents(new DeathMetric.DeathEventHandler(), this);
//        registerMetricHandler(new MetricHandler(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
