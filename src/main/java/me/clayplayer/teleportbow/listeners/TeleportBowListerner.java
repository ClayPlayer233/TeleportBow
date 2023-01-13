package me.clayplayer.teleportbow.listeners;

import me.clayplayer.teleportbow.TeleportBow;
import me.clayplayer.teleportbow.utility.BowUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class TeleportBowListerner implements Listener {

    private final TeleportBow plugin;
    private final BowUtils bowUtils;

    public TeleportBowListerner(TeleportBow plugin) {
        this.plugin = plugin;
        this.bowUtils = new BowUtils(plugin);
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {
        if (e.getEntity().getType().equals(EntityType.ARROW) && e.getEntity().getShooter() instanceof Player p) {
            ItemStack ItemInMainHand = p.getInventory().getItemInMainHand();
            if (ItemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")))) {
                Location location = e.getEntity().getLocation();
                p.teleport(location);
                e.getEntity().remove();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-message")));
                p.playSound(p, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, 1);
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (plugin.getConfig().getBoolean("give-on-join")) {
            Player p = e.getPlayer();
            p.getInventory().addItem(new ItemStack(bowUtils.createTeleportBow()));
            p.sendMessage(ChatColor.GREEN + "你被给予了传送弓！");
        }
    }

}
