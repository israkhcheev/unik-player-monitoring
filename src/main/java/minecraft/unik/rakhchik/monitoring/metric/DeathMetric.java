package minecraft.unik.rakhchik.monitoring.metric;

import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.Map;

public class DeathMetric implements IMetric<Integer> {

    private final Map<String, Integer> values;

    public DeathMetric() {
        // load from metric value
        this.values = new HashMap<>();
    }

    @Override
    public String getName() {
        return "death";
    }

    @Override
    public Integer getValue(OfflinePlayer player) {
        String name = player.getName();
        Integer value = values.get(name);
        if (value == null) {
            value = player.getStatistic(Statistic.DEATHS);
            values.put(name, value);
        }
        return value;
    }

    @Override
    public Map<String, Integer> getValues() {
        return new HashMap<>(values);
    }

    @Override
    public void updateValue(Player player, Integer value) {
        this.values.put(player.getName(), value);
    }

    public void incrementValue(Player player) {
        updateValue(player, getValue(player) + 1);
    }

    public static class DeathEventHandler implements Listener {

        private final DeathMetric metrics;

        public DeathEventHandler() {
            metrics = new DeathMetric();
        }

        @EventHandler
        public void onDeath(PlayerDeathEvent e) {
            int deathCount = e.getEntity().getStatistic(Statistic.DEATHS) + 1;
            metrics.updateValue(e.getEntity(), deathCount);
        }

    }

}
