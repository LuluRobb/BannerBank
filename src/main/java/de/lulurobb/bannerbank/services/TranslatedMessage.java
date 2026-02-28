package de.lulurobb.bannerbank.services;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.OfflinePlayer;

public class TranslatedMessage {

    private String message;
    public TranslatedMessage(String message) {
        this.message = message;
    }

    public TranslatedMessage replace(String key, String value) {
        message = message.replace("%" + key + "%", value);
        return this;
    }

    public Component getAsComponent() {
        MiniMessage mm = MiniMessage.miniMessage();
        try {
            return mm.deserialize(message);
        } catch (Exception ex) {
            return Component.text(message);
        }
    }

    public String getAsString() {
        return message;
    }

    @Override
    public String toString() {
        return getAsString();
    }
}
