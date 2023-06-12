package minecraft.unik.rakhchik.monitoring.handler;

import minecraft.unik.rakhchik.monitoring.PlayerMonitoringPlugin;
import minecraft.unik.rakhchik.monitoring.api.AbstractMetric;
import minecraft.unik.rakhchik.monitoring.metric.PlayerBlockBreakMetric;
import minecraft.unik.rakhchik.monitoring.metric.PlayerDeathMetric;
import org.bukkit.Bukkit;

import java.lang.reflect.InvocationTargetException;

public enum MetricHandler {

    PLAYER_DEATH(PlayerDeathMetric.class),
    PLAYER_BLOCK_BREAK(PlayerBlockBreakMetric.class)
    ;

    private final Class<? extends AbstractMetric<?,?>> clazz;

    MetricHandler(Class<? extends AbstractMetric<?, ?>> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends AbstractMetric<?, ?>> getClazz() {
        return clazz;
    }

    public void registerMetric(PlayerMonitoringPlugin plugin) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        getClazz().getDeclaredConstructor(PlayerMonitoringPlugin.class).newInstance(plugin);
    }
}
