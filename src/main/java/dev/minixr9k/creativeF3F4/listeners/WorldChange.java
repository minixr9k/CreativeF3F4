package dev.minixr9k.creativeF3F4.listeners;

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import dev.minixr9k.creativeF3F4.CreativeF3F4;
import dev.minixr9k.creativeF3F4.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class WorldChange implements Listener {

    public WorldChange(CreativeF3F4 plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (player.isOp()) return;

        if (Utils.canF3F4(player, player.getWorld())) {
            Utils.setF3F4(player, true);
        }
    }

    @EventHandler
    private void onWorldChange(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        World world = player.getWorld();

        if (player.isOp()) return;

        if (Utils.canF3F4(player, world)) {
            Utils.setF3F4(player, true);
        }
        else {
            Utils.setF3F4(player, false);
        }
    }

    @EventHandler
    private void onRespawn(PlayerPostRespawnEvent e) {
        Player player = e.getPlayer();

        if (player.isOp()) return;

        World world = e.getRespawnedLocation().getWorld();

        if (Utils.canF3F4(player, world)) {
            Utils.setF3F4(player, true);
        }
    }
}
