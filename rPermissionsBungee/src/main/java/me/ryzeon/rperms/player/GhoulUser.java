package me.ryzeon.rperms.player;

import lombok.Getter;
import lombok.Setter;
import me.ryzeon.rperms.bungee.rPermsLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:33 p. m.
 */

@Getter
@Setter
public class GhoulUser {

    @Getter
   private static List<GhoulUser> ghoulUsers = new ArrayList<>();

    private String name;

    private List<String> permissions = new ArrayList<>();

    private String prefix = "&a";

    public GhoulUser(String name) {
        this.name = name;
        ghoulUsers.add(this);
        rPermsLoader.logger("&cNew staff data -> " + name);
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }

    public static GhoulUser getUser(String name) {
        return ghoulUsers.stream().filter(ghoulUser -> ghoulUser.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
