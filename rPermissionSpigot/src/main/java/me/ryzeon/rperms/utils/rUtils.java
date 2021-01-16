package me.ryzeon.rperms.utils;

import me.ryzeon.rperms.plugin.rPermsLoader;
import net.luckperms.api.model.user.User;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:49 p. m.
 */

public class rUtils {

    public static List<Player> getOnlinePlayers() {
        List<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) players.add(player);
        return players;
    }

    public static String serializeStaffData(Player player) {
        User user = rPermsLoader.INSTANCE.getLuckPermsAPI().getUserManager().getUser(player.getUniqueId());
        List<String> permissions = new ArrayList<>();
        player.getEffectivePermissions().stream().filter(PermissionAttachmentInfo::getValue).map(PermissionAttachmentInfo::getPermission).forEach(permissions::add);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("fake@").append("lol")
                .append(":name@").append(player.getName())
                .append(":ptag@").append(user.getCachedData().getMetaData().getPrefix())
                .append(":perms@").append(permissions.isEmpty() ? "NONE" : StringUtils.join(permissions, "-"));

        return stringBuilder.toString();
    }
}
