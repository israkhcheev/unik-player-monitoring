package minecraft.unik.rakhchik.monitoring.metric;

import minecraft.unik.rakhchik.monitoring.api.AbstractMetric;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class PlayerBlockBreakMetric extends AbstractMetric<Integer, BlockBreakEvent> {

    private final Map<String, Integer> values;

    public PlayerBlockBreakMetric(JavaPlugin plugin) {
        super(plugin);
        this.values = new HashMap<>();
    }

    @Override
    protected void eventAction(BlockBreakEvent event) {
        Player player = event.getPlayer();
        int mineBlockCount = player.getStatistic(Statistic.MINE_BLOCK) + 1;
        updateValue(player, mineBlockCount);
    }

    @Override
    public String getName() {
        return "player.block.break";
    }

    @Override
    public Integer getValue(OfflinePlayer player) {
        return values.get(player.getName());
    }

    @Override
    public Map<String, Integer> getValues() {
        return values;
    }

    @Override
    public void updateValue(Player player, Integer value) {
        this.values.put(player.getName(), value);
    }
}
