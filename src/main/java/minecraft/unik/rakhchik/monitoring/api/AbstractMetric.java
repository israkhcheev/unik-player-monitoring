package minecraft.unik.rakhchik.monitoring.api;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMetric<T, E extends Event> implements IMetric<T> {

    private static final Map<String, IMetric<?>> METRIC_MAP = new HashMap<>();

    public AbstractMetric(JavaPlugin plugin) {
        registerMetric(getName(), this);
        Bukkit.getPluginManager().registerEvents(
                new MetricEventHandler<E>() {
                    @Override
                    public void onEvent(E e) {
                        eventAction(e);
                    }
                }, plugin);
    }

    private void registerMetric(String configName, IMetric<?> metric) {
        METRIC_MAP.put(configName, metric);
    }

    public IMetric<?> getMetric(String configName) {
        return METRIC_MAP.get(configName);
    }

    protected abstract void eventAction(E e);

    private abstract static class MetricEventHandler<E> implements Listener {
        @EventHandler
        abstract public void onEvent(E e);
    }

}
