package dev.minixr9k.creativeF3F4.listeners;

import com.github.retrooper.packetevents.event.PacketListener;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientChangeGameMode;
import dev.minixr9k.creativeF3F4.CreativeF3F4;
import dev.minixr9k.creativeF3F4.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class GameModeChange implements PacketListener {

    private final CreativeF3F4 plugin;

    public GameModeChange(CreativeF3F4 plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent e) {
        if (e.getPacketType() != PacketType.Play.Client.CHANGE_GAME_MODE) return;

        WrapperPlayClientChangeGameMode packet = new WrapperPlayClientChangeGameMode(e);

        Player player = e.getPlayer();
        if (player.isOp()) return;

        World world = player.getWorld();

        if (Utils.canF3F4(player, world)) {
            GameMode gameMode = switch (packet.getGameMode()) {
                case ADVENTURE -> GameMode.ADVENTURE;
                case CREATIVE -> GameMode.CREATIVE;
                case SURVIVAL -> GameMode.SURVIVAL;
                case SPECTATOR -> GameMode.SPECTATOR;
                default -> null;
            };

            if (gameMode != null) {
                Bukkit.getScheduler().runTask(plugin, () -> player.setGameMode(gameMode));
            }
        }

        e.setCancelled(true); // не отправляем на сервер

    }

}
