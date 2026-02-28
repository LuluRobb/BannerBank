package de.lulurobb.bannerbank;

import de.lulurobb.bannerbank.services.ItemBuilder;
import de.lulurobb.bannerbank.services.MessageTranslationConfiguration;
import de.lulurobb.bannerbank.services.TranslatedMessage;
import de.lulurobb.bannerbank.ui.BannerBankBackgroundSelectionInventoryHolder;
import de.lulurobb.bannerbank.ui.BannerBankFontSelectionInventoryHolder;
import de.lulurobb.bannerbank.ui.BannerBankInventoryHolder;
import de.lulurobb.bannerbank.util.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UIContainer {

    private MessageTranslationConfiguration msgTranslation;
    private Player player;
    public UIContainer(MessageTranslationConfiguration msgTranslation, Player player) {
        this.msgTranslation = msgTranslation;
        this.player = player;
    }

    public void openBannerBank() {

        Inventory gui = Bukkit.createInventory(
                new BannerBankInventoryHolder(),
                9*6,
                msgTranslation.getMessage("UI.BannerBank.Title"
                ).getAsComponent());

        Util.setOutline(gui, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).translateItem(msgTranslation, "UI.BannerBank.BackgroundFiller").create());

        DyeColor font = Main.getInstance().getPlayerDataManager().getLatestFontColor(player);
        DyeColor background = Main.getInstance().getPlayerDataManager().getLatestBackgroundColor(player);

        gui.setItem(2,
                new ItemBuilder(ColorManager.getDyeByDye(font))
                    .translateItem(msgTranslation, "UI.BannerBank.ChangeFontItem", new HashMap<>() {{
                        put("color", ColorManager.getByDyeColor(font));
                        put("color_name", font.name());
                    }})
                    .create()
                );
        gui.setItem(4,
                new ItemBuilder(Material.PLAYER_HEAD)
                        .translateItem(msgTranslation, "UI.InfoItem", new HashMap<>() {{
                            put("player", player.getName());
                        }})
                        .createAsSkull(player)
        );
        gui.setItem(6,
                new ItemBuilder(ColorManager.getDyeByDye(background))
                .translateItem(msgTranslation, "UI.BannerBank.ChangeBackgroundItem", new HashMap<>() {{
                    put("color", ColorManager.getByDyeColor(background));
                    put("color_name", background.name());
                }})
                .create()
        );

        ArrayList<String> letters = new ArrayList<>();
        for (Letter currentletter : BannerManager.getAllLetters()) {
            letters.add(currentletter.name());
        }

        for (String alphabet : BannerManager.getAlpherbet()) {

            if(!letters.contains(alphabet)) continue;

            if(!player.hasPermission("bannerbank.get." + alphabet)) {
                gui.setItem(gui.firstEmpty(), new ItemBuilder(Material.STRUCTURE_VOID).translateItem(msgTranslation, "UI.BannerBank.GetBannerPreviewItem").create());
                continue;
            }

            Letter letter = Letter.valueOf(alphabet);
            ItemStack banner = BannerManager.getBanner(background, font, letter);

            ItemBuilder bannerPreview = new ItemBuilder(banner);
            bannerPreview.translateItem(msgTranslation, "UI.BannerBank.GetBannerPreviewItem", new HashMap<>() {{
                put("font_color", ColorManager.getByDyeColor(font));
                put("background_color", ColorManager.getByDyeColor(background));
                put("letter", letter.name());
            }});

            gui.setItem(gui.firstEmpty(), bannerPreview.create());
        }

        player.openInventory(gui);
    }

    public void openColorSwitcher(Player p, Boolean font) {
        Inventory gui = Bukkit.createInventory(
                (font ? new BannerBankFontSelectionInventoryHolder() : new BannerBankBackgroundSelectionInventoryHolder()),
                9*5,
                msgTranslation.getMessage("UI.ChangeColor.Title"
                ).getAsComponent());

        Util.setOutline(gui, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).translateItem(msgTranslation, "UI.ChangeColor.BackgroundFiller").create());

        gui.setItem(4,
                new ItemBuilder(Material.PLAYER_HEAD)
                        .translateItem(msgTranslation, "UI.InfoItem", new HashMap<>() {{
                            put("player", player.getName());
                        }})
                        .createAsSkull(player)
        );

        gui.setItem(44, new ItemBuilder(Material.ARROW).translateItem(msgTranslation, "UI.ReturnItem").create());

        DyeColor latestFont = Main.getInstance().getPlayerDataManager().getLatestFontColor(player);
        DyeColor latestBackground = Main.getInstance().getPlayerDataManager().getLatestBackgroundColor(player);

        for (DyeColor currentColor : ColorManager.getAll()) {
            if(font) { // FONT
                if(!p.hasPermission("bannerbank.font." + currentColor.name())) continue;
                ItemBuilder colorItem = new ItemBuilder(ColorManager.getDyeByDye(currentColor)).translateItem(msgTranslation, "UI.ChangeColor.ColorItem", new HashMap<>() {{
                    put("color", ColorManager.getByDyeColor(currentColor));
                    put("color_name", currentColor.name());
                    if (latestFont == currentColor)
                        put("selected", msgTranslation.getMessage("UI.ChangeColor.SelectedAddition").getAsString());
                    else
                        put("selected", "");
                }});

                if(latestFont == currentColor)
                    colorItem.glow();

                gui.setItem(gui.firstEmpty(), colorItem.create());
            } else { // BACKGROUND
                if(!p.hasPermission("bannerbank.background." + currentColor.name())) continue;
                ItemBuilder colorItem = new ItemBuilder(ColorManager.getDyeByDye(currentColor)).translateItem(msgTranslation, "UI.ChangeColor.ColorItem", new HashMap<>() {{
                    put("color", ColorManager.getByDyeColor(currentColor));
                    put("color_name", currentColor.name());
                    if (latestBackground == currentColor)
                        put("selected", msgTranslation.getMessage("UI.ChangeColor.SelectedAddition").getAsString());
                    else
                        put("selected", "");
                }});

                if(latestBackground == currentColor)
                    colorItem.glow();

                gui.setItem(gui.firstEmpty(), colorItem.create());
            }
        }
        p.openInventory(gui);
    }


}
