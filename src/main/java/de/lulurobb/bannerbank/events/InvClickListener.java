package de.lulurobb.bannerbank.events;

import de.lulurobb.bannerbank.UIContainer;
import de.lulurobb.bannerbank.Main;
import de.lulurobb.bannerbank.services.ItemBuilder;
import de.lulurobb.bannerbank.services.MessageTranslationConfiguration;
import de.lulurobb.bannerbank.ui.BannerBankBackgroundSelectionInventoryHolder;
import de.lulurobb.bannerbank.ui.BannerBankFontSelectionInventoryHolder;
import de.lulurobb.bannerbank.ui.BannerBankInventoryHolder;
import de.lulurobb.bannerbank.util.Util;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InvClickListener implements Listener {

    private MessageTranslationConfiguration msgTranslation;
    public InvClickListener(MessageTranslationConfiguration msgTranslation) {
        this.msgTranslation = msgTranslation;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        ItemStack item = e.getCurrentItem();
        if(item == null) return;

        Player p = (Player) e.getWhoClicked();

        UIContainer uiContainer = new UIContainer(msgTranslation, p);

        if(e.getClickedInventory().getHolder() instanceof BannerBankInventoryHolder) { // BANK
            e.setCancelled(true);

            if(e.getAction() != InventoryAction.PICKUP_ALL) return;

            if(Util.isBanner(item.getType())) {
                ItemBuilder banner = new ItemBuilder(item);
                banner.lore(null);
                banner.name(null);
                banner.translateItem(msgTranslation, "UI.BannerBank.GetBannerItem");
                p.getInventory().addItem(item);
                p.playSound(p, Sound.UI_LOOM_TAKE_RESULT, 10, 1);
            } else if(e.getSlot() == 2) {
                uiContainer.openColorSwitcher(p, true);
            } else if(e.getSlot() == 6) {
                uiContainer.openColorSwitcher(p, false);
            } else if(item.getType() == Material.STRUCTURE_VOID) {
                p.playSound(p, Sound.ITEM_SHIELD_BREAK, 10, 1);
            }

        } else if(e.getClickedInventory().getHolder() instanceof BannerBankFontSelectionInventoryHolder) { // font
            e.setCancelled(true);

            if(Util.isDye(item.getType())) {
                DyeColor color = Util.getDyeColorFromBanner(item.getType());
                Main.getInstance().getPlayerDataManager().updateLatestFontColor(p, color);
                uiContainer.openBannerBank();
                p.sendMessage(msgTranslation.getMessage("ColorSelection.ColorSelected").getAsComponent());
                p.playSound(p, Sound.UI_BUTTON_CLICK, 10, 1);
            } else if(item.getType() == Material.ARROW) {
                uiContainer.openBannerBank();
            }


        } else if(e.getClickedInventory().getHolder() instanceof BannerBankBackgroundSelectionInventoryHolder) { // background
            e.setCancelled(true);

            if(Util.isDye(item.getType())) {
                DyeColor color = Util.getDyeColorFromBanner(item.getType());
                Main.getInstance().getPlayerDataManager().updateLatestBackgroundColor(p, color);
                uiContainer.openBannerBank();
                p.sendMessage(msgTranslation.getMessage("ColorSelection.ColorSelected").getAsComponent());
                p.playSound(p, Sound.UI_BUTTON_CLICK, 10, 1);
            } else if(item.getType() == Material.ARROW) {
                uiContainer.openBannerBank();
            }


        }
    }

}
