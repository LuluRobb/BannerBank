package de.lulurobb.bannerbank;

import de.lulurobb.bannerbank.cmd.BannerBankCommand;
import de.lulurobb.bannerbank.events.InvClickListener;
import de.lulurobb.bannerbank.services.MessageTranslationConfiguration;
import de.lulurobb.bannerbank.services.PluginConfigurationFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String RawPrefix = "§x§0§0§f§b§9§2ʙ§x§3§2§f§b§8§0ᴀ§x§6§4§f§c§6§eɴ§x§9§5§f§c§5§bɴ§x§c§7§f§d§4§9ᴇ§x§f§9§f§d§3§7ʀ";
    public static String PREFIX = RawPrefix + " §8» §7";
    public static String RawError = "§x§c§0§0§0§0§0§lE§x§c§d§1§3§1§3§lr§x§d§9§2§6§2§6§lr§x§e§6§3§8§3§8§lo§x§f§2§4§b§4§b§lr";
    public static String ERROR = RawError + " §8» §7";
    public static String CONSOLE = "";
    public static String USE = ERROR + "§4Use » §c/";

    private static Main instance;
    private PluginConfigurationFile bannerConfiguration;
    private PluginConfigurationFile playerDataConfiguration;
    private PluginConfigurationFile pluginConfiguration;

    private MessageTranslationConfiguration messageTranslation;
    private PlayerDataManager playerDataManager;


    @Override
    public void onEnable() {
        instance = this;
        bannerConfiguration = new PluginConfigurationFile(this, "config.yml");
        playerDataConfiguration = new PluginConfigurationFile(this, "playerData.yml");
        pluginConfiguration = new PluginConfigurationFile(this, "config.yml");

        saveDefaultConfig();

        messageTranslation = new MessageTranslationConfiguration(pluginConfiguration);
        playerDataManager = new PlayerDataManager(this);

        getCommand("bannerbank").setExecutor(new BannerBankCommand(messageTranslation));

        Bukkit.getPluginManager().registerEvents(new InvClickListener(messageTranslation), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Boolean hasPerm(CommandSender p, String perm) {
        if(p.hasPermission(perm)) {
            return true;
        } else {
            p.sendMessage("PrefixStrings.ERROR" + "§cDir fehlt folgende Berechtigung um diesen Command zu verwenden:");
            p.sendMessage("§4" + perm);
            return false;
        }
    }

    public static String getLine(String name) {
        String ret = "";

        String line1 = "§x§0§4§f§b§f§6§m⚊§x§2§8§d§7§f§6§m⚊§x§4§b§b§3§f§7§m⚊§x§6§f§8§f§f§7§m⚊§x§9§2§6§c§f§7§m⚊§x§b§6§4§8§f§7§m⚊§x§d§9§2§4§f§8§m⚊§x§f§d§0§0§f§8§m⚊";
        String line2 = "§x§f§d§0§0§f§8§m⚊§x§d§9§2§4§f§8§m⚊§x§b§6§4§8§f§7§m⚊§x§9§2§6§c§f§7§m⚊§x§6§f§8§f§f§7§m⚊§x§4§b§b§3§f§7§m⚊§x§2§8§d§7§f§6§m⚊§x§0§4§f§b§f§6§m⚊";
        String star = "§x§0§0§f§b§e§7✦";
        String space = "§f  ";
        ret = star + line1 + space + name + space + line2 + star;
        return ret;
    }

    public static Main getInstance() {
        return instance;
    }

    public PluginConfigurationFile getBannerConfiguration() {
        return bannerConfiguration;
    }

    public PluginConfigurationFile getPlayerDataConfiguration() {
        return playerDataConfiguration;
    }

    public PlayerDataManager getPlayerDataManager() {
        return playerDataManager;
    }

    public MessageTranslationConfiguration getMessageTranslation() {
        return messageTranslation;
    }
}
