package de.lulurobb.bannerbank.services;

import java.util.List;

public class MessageTranslationConfiguration {

    private PluginConfigurationFile pluginConfiguration;

    public MessageTranslationConfiguration(PluginConfigurationFile pluginConfiguration) {
        this.pluginConfiguration = pluginConfiguration;
    }

    public TranslatedMessage getMessage(String key) {
        String message = pluginConfiguration.getFileConfiguration().getString("Config.Messages." + key);
        if(message == null) return new TranslatedMessage(key);
        //if(message.isBlank()) return new TranslatedMessage(key);
        return new TranslatedMessage(message);
    }

    public TranslatedMessage[] getMessageList(String key) {
        List<String> list = pluginConfiguration.getFileConfiguration().getStringList("Config.Messages." + key);
        if (list.isEmpty()) return new TranslatedMessage[0];
        return list.stream().map(TranslatedMessage::new).toArray(TranslatedMessage[]::new);
    }
}
