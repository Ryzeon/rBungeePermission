package me.ryzeon.rperms.utils;

import net.md_5.bungee.api.ChatColor;

/**
 * Created by Ryzeon
 * Project: rCore
 * Date: 13/01/2021 @ 07:54 p. m.
 */

public class CC {
    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
