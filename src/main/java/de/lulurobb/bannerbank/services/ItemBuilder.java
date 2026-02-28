package de.lulurobb.bannerbank.services;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ItemBuilder {

    ItemStack item;
    ItemMeta itemmeta;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        itemmeta = item.getItemMeta();
    }

    public ItemBuilder(ItemStack item) {
        this.item = item;
        itemmeta = this.item.getItemMeta();
    }

    @Deprecated
    public ItemBuilder setName(String name) {
        itemmeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder name(Component name) {
        if(name == null) {
            itemmeta.displayName(null);
            return this;
        }

        itemmeta.displayName(name.decoration(TextDecoration.ITALIC, false));
        return this;
    }

    public ItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }

    @Deprecated
    public ItemBuilder setLore(String... lore) {
        itemmeta.setLore(Arrays.asList(lore));
        return this;
    }

    @Deprecated
    public ItemBuilder setLore(ArrayList<String> lore) {
        itemmeta.setLore(lore);
        return this;
    }

    public ItemBuilder lore(List<Component> lore) {
        if(lore == null) {
            itemmeta.lore(null);
            return this;
        }
        List<Component> fixedLore = lore.stream()
                .map(c -> c.decoration(TextDecoration.ITALIC, false))
                .toList();

        itemmeta.lore(fixedLore);
        return this;
    }

    public ItemBuilder translateItem(MessageTranslationConfiguration msgTranslation, String key, HashMap<String, String> replacements) {

        TranslatedMessage nameMsg = msgTranslation.getMessage(key + ".Name");
        for (var entry : replacements.entrySet()) {
            nameMsg.replace(entry.getKey(), entry.getValue());
        }
        name(nameMsg.getAsComponent());

        TranslatedMessage[] loreArray = msgTranslation.getMessageList(key + ".Lore");
        if (loreArray.length > 0) {
            List<Component> loreList = Arrays.stream(loreArray)
                    .peek(msg -> replacements.forEach(msg::replace))
                    .map(TranslatedMessage::getAsComponent)
                    .toList();

            lore(loreList);
        }

        return this;
    }

    public ItemBuilder translateItem(MessageTranslationConfiguration msgTranslation, String key) {
        return translateItem(msgTranslation, key, new HashMap<>());
    }

    @Deprecated
    public ItemBuilder addEnchantment(Enchantment enchantment, int lvl) {
        itemmeta.addEnchant(enchantment, lvl, true);
        return this;
    }

    public ItemStack create() {
        item.setItemMeta(itemmeta);
        return item;
    }

    public ItemStack createAsSkull(OfflinePlayer owner) {
        SkullMeta skullMeta = (SkullMeta) itemmeta;
        skullMeta.setOwningPlayer(owner);
        item.setItemMeta(skullMeta);
        return item;
    }
    
    public ItemBuilder glow() {
        itemmeta.addEnchant(Enchantment.MENDING, 1, true);
        itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return this;
    }

    public ItemBuilder unbreakable() {
        itemmeta.setUnbreakable(false);
        return this;
    }

}
