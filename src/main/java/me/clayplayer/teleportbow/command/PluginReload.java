package me.clayplayer.teleportbow.command;

import me.clayplayer.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PluginReload implements CommandExecutor {

    private final TeleportBow plugin;

    public PluginReload(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        plugin.reloadConfig();
        if (sender instanceof Player p) {
            p.sendMessage(ChatColor.GREEN + "重载成功！");
        } else {
            plugin.getLogger().info("重载成功！");
        }
        return true;
    }
}
