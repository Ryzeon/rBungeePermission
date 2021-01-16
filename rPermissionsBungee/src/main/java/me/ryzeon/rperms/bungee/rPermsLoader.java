package me.ryzeon.rperms.bungee;

import lombok.Getter;
import me.ryzeon.rperms.handler.RecievedDataListener;
import me.ryzeon.rperms.utils.CC;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:30 p. m.
 */

@Getter
public enum rPermsLoader {

    INSTANCE;

    private Plugin plugin;

    public static String incomingrPermsChannel = "rPerms";

    @Deprecated
    public void onStart(Plugin plugin) {
        this.plugin = plugin;

        load();
    }

    @Deprecated
    public void onStop() {

    }

    public static void logger(String text) {
        getInstance().getProxy().getConsole().sendMessage(CC.translate("&7[&erLoader&7] &f" + text));
    }


    private void load() {
        logger("Register channel");
        plugin.getProxy().registerChannel(incomingrPermsChannel);
        logger("Channel Listener");
        plugin.getProxy().getPluginManager().registerListener(plugin, new RecievedDataListener());
    }


    public static Plugin getInstance() {
        return rPermsLoader.INSTANCE.getPlugin();
    }
}
