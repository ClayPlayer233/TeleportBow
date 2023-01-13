package me.clayplayer.teleportbow.utility;

import me.clayplayer.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BowUtils {

    private final TeleportBow plugin;

    public BowUtils(TeleportBow plugin) {
        this.plugin = plugin;
    }


    public ItemStack createTeleportBow() {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-description")));
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowMeta);
        return bow;
    }
}
