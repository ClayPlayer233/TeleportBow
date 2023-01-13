package me.clayplayer.teleportbow;

import me.clayplayer.teleportbow.command.GiveBowCommand;
import me.clayplayer.teleportbow.command.PluginReload;
import me.clayplayer.teleportbow.listeners.TeleportBowListerner;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportBow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("givetpbow").setExecutor(new GiveBowCommand(this));
        getCommand("tpbowreload").setExecutor(new PluginReload(this));
        getServer().getPluginManager().registerEvents(new TeleportBowListerner(this), this);
    }

}
