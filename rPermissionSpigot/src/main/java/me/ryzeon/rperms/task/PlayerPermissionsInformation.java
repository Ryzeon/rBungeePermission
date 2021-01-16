package me.ryzeon.rperms.task;

import me.ryzeon.rperms.plugin.rPermsLoader;
import me.ryzeon.rperms.utils.rUtils;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:46 p. m.
 */

public class PlayerPermissionsInformation {

    private BukkitTask task;

    public PlayerPermissionsInformation() {
        rPermsLoader.logger("Enabling information task");
        onStart();
    }

    public void onCancel(){
        if (task != null) task.cancel();
    }

    private void onStart(){
        task = new BukkitRunnable() {
            @Override
            public void run() {
                rUtils.getOnlinePlayers().stream().filter(player -> player.hasPermission("rperms.staff")).forEach(player -> {
                    rPermsLoader.sendBungeeMessage(rUtils.serializeStaffData(player));
                });
            }
        }.runTaskTimerAsynchronously(rPermsLoader.getInstance(), 0,20);
    }
}
