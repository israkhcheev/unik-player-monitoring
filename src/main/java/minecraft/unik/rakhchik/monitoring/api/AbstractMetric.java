package minecraft.unik.rakhchik.monitoring.api;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMetric<T> implements IMetric<T> {

    private static final Map<String, IMetric<?>> METRIC_NAME_MAP = new HashMap<>();

    public AbstractMetric() {
        addMetricName(getName(), this);
    }

    private void addMetricName(String configName, IMetric<?> metric) {
        METRIC_NAME_MAP.put(configName, metric);
    }

    public IMetric<?> getMetric(String configName) {
        return METRIC_NAME_MAP.get(configName);
    }

}
