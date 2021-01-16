package me.ryzeon.rperms.handler;

import me.ryzeon.rperms.bungee.rPermsLoader;
import me.ryzeon.rperms.player.GhoulUser;
import me.ryzeon.rperms.utils.cache.DataInfo;
import me.ryzeon.rperms.utils.rUtils;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 11:08 p. m.
 */

public class RecievedDataListener implements Listener {

    @EventHandler
    public void onrPermsMessage(PluginMessageEvent event) {
        try {
            if (!event.getTag().equalsIgnoreCase(rPermsLoader.incomingrPermsChannel)) return;

            DataInputStream in = new DataInputStream(new ByteArrayInputStream(event.getData()));

            String channel = in.readUTF();

            if (!channel.equals("rPermsUpdate")) return;

            String text = in.readUTF();

            DataInfo dataInfo = rUtils.getInfoFromString(text);

            GhoulUser user = GhoulUser.getUser(dataInfo.getName()) == null ? new GhoulUser(dataInfo.getName()) : GhoulUser.getUser(dataInfo.getName());

            user.setPrefix(dataInfo.getPrefix());
            user.setPermissions(dataInfo.getPermission());
        } catch (Exception e) {
            rPermsLoader.logger("Error in get data -> &f" + e.getCause());
            e.printStackTrace();
        }
    }
}
