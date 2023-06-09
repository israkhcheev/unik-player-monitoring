package minecraft.unik.rakhchik.monitoring;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MetricSaver {

    private Long period;

    private ScheduledExecutorService scheduler;

    public MetricSaver(Long period) {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }



}
