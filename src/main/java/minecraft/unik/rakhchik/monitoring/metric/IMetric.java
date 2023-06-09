package minecraft.unik.rakhchik.monitoring.metric;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public interface IMetric<T> {

    String getName();

    T getValue(OfflinePlayer player);

    Map<String, T> getValues();

    void updateValue(Player player, T value);

}
