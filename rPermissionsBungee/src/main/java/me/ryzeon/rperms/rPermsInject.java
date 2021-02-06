package me.ryzeon.rperms;

import me.ryzeon.rperms.bungee.rPermsLoader;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:30 p. m.
 */

public class rPermsInject extends Plugin {

    @Override
    public void onEnable() {
        rPermsLoader.INSTANCE.onStart(this);
    }
}
