package me.ryzeon.rperms;

import me.ryzeon.rperms.plugin.rPermsLoader;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:16 p. m.
 */

public class rPermsInject extends JavaPlugin {
    @Override
    public void onEnable() {
        rPermsLoader.INSTANCE.onStart(this);
    }
}
