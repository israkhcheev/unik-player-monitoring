package minecraft.unik.rakhchik.monitoring.metric;

import minecraft.unik.rakhchik.monitoring.PlayerMonitoringPlugin;
import minecraft.unik.rakhchik.monitoring.api.AbstractMetric;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PlayerDeathMetric extends AbstractMetric<Integer, PlayerDeathEvent> {

    private final Map<String, Integer> values;

    public PlayerDeathMetric(JavaPlugin plugin) {
        super(plugin);
        // TODO load from metric value
        this.values = new HashMap<>();
        //
    }

    @Override
    protected void eventAction(PlayerDeathEvent e) {
        int deathCount = e.getEntity().getStatistic(Statistic.DEATHS) + 1;
        updateValue(e.getEntity(), deathCount);
    }

    @Override
    public String getName() {
        return "player.death";
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

}
