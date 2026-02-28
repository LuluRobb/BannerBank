package de.lulurobb.bannerbank;

import org.bukkit.DyeColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class PlayerDataManager {

    private Main plugin;
    private FileConfiguration cfg;

    public PlayerDataManager(Main plugin) {
        this.plugin = plugin;
        this.cfg = plugin.getPlayerDataConfiguration().getFileConfiguration();
    }
    private boolean hasData(Player p) {
        return cfg.contains("BannerBank." + p.getUniqueId());
    }

    public DyeColor getLatestFontColor(Player p) {
        if(!hasData(p)) return DyeColor.WHITE;
        try {
            return DyeColor.valueOf(cfg.getString("BannerBank." + p.getUniqueId() + ".lastFont"));
        } catch (Exception ex) {
            return DyeColor.WHITE;
        }
    }

    public DyeColor getLatestBackgroundColor(Player p) {
        if(!hasData(p)) return DyeColor.BLACK;
        try {
            return DyeColor.valueOf(cfg.getString("BannerBank." + p.getUniqueId() + ".lastBackground"));
        } catch (Exception ex) {
            return DyeColor.BLACK;
        }
    }

    public void updateLatestFontColor(Player p, DyeColor color) {
        cfg.set("BannerBank." + p.getUniqueId() + ".lastFont", color.name());
        plugin.getPlayerDataConfiguration().saveConfig();
    }

    public void updateLatestBackgroundColor(Player p, DyeColor color) {
        cfg.set("BannerBank." + p.getUniqueId() + ".lastBackground", color.name());
        plugin.getPlayerDataConfiguration().saveConfig();
    }
}
