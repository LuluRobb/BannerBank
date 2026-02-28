package de.lulurobb.bannerbank.services;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class PluginConfigurationFile {
    private final Plugin plugin;
    private final String fileName;

    private File file;
    private FileConfiguration fileConfiguration;

    public PluginConfigurationFile(Plugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        saveDefault();
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public void saveConfig() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveDefault() {
        file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }
}
