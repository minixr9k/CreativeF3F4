package dev.minixr9k.creativeF3F4.utils;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityStatus;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Utils {

    public static boolean canF3F4(Player player, World world) {

        if (player.hasPermission("minecraft.command.gamemode")) return true;

        return false;
    }

    public static void setF3F4(Player player, boolean enabled) {
        if (enabled) {
            WrapperPlayServerEntityStatus packet = new WrapperPlayServerEntityStatus(
                    player.getEntityId(),
                    26 // 2 лвл оп для f3f4
            );

            PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
        }
        else {
            WrapperPlayServerEntityStatus packet = new WrapperPlayServerEntityStatus(
                    player.getEntityId(),
                    24 // отключаем f3f4
            );

            PacketEvents.getAPI().getPlayerManager().sendPacket(player, packet);
        }
    }

}
