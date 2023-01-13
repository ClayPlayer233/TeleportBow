package me.clayplayer.teleportbow.command;

import me.clayplayer.teleportbow.TeleportBow;
import me.clayplayer.teleportbow.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GiveBowCommand implements CommandExecutor {

    private final TeleportBow plugin;
    private final BowUtils bowUtils;

    public GiveBowCommand(TeleportBow plugin) {
        this.plugin = plugin;
        this.bowUtils = new BowUtils(plugin);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p) {
            if (p.hasPermission("teleportbow.command.givetpbow")) {
                if (args.length == 0) {
                    ItemStack bow = bowUtils.createTeleportBow();
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    p.sendMessage(ChatColor.GREEN + "你获得了传送弓！");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "该玩家不在线！");
                    } else {
                        ItemStack bow = bowUtils.createTeleportBow();
                        target.getInventory().addItem(bow);
                        target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                        p.sendMessage(ChatColor.GREEN + "成功给予" + target.getName() + "传送弓！");
                        target.sendMessage(ChatColor.GREEN + "你被给予了传送弓！");
                    }
                }
            } else {
                p.sendMessage("你没有权限使用该命令！");
            }
        }

        return true;
    }
}
