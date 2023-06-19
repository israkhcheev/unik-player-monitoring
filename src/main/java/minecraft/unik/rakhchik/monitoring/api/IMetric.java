package minecraft.unik.rakhchik.monitoring.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

interface IMetric<T> {

    // iRakhchik: {player.block.place: 12, player.death: 2}

    String getName();

    T getValue(OfflinePlayer player);

    Map<String, T> getValues();

    void updateValue(Player player, T value);

}
