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

    public static String MENU_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------";
    public static String CHAT_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------------------------------";
    public static String MEDIUM_CHAT_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------------";
}
