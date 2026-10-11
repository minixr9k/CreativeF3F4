package dev.minixr9k.creativeF3F4;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import dev.minixr9k.creativeF3F4.listeners.GameModeChange;
import dev.minixr9k.creativeF3F4.listeners.WorldChange;
import org.bukkit.plugin.java.JavaPlugin;

public final class CreativeF3F4 extends JavaPlugin {

    @Override
    public void onLoad() {
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        PacketEvents.getAPI().init();

        PacketEvents.getAPI().getEventManager().registerListener(new GameModeChange(this), PacketListenerPriority.NORMAL);

        new WorldChange(this);
    }

    @Override
    public void onDisable() {
    }
}
