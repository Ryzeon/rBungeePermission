package me.ryzeon.rperms.plugin;

import com.google.common.collect.Iterables;
import me.ryzeon.rperms.task.PlayerPermissionsInformation;
import me.ryzeon.rperms.utils.CC;
import me.ryzeon.rperms.utils.rUtils;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/**
 * Created by Ryzeon
 * Project: rBungeePermission
 * Date: 15/01/2021 @ 10:21 p. m.
 */

public enum rPermsLoader {
    INSTANCE;

    private JavaPlugin plugin;

    private LuckPerms luckPermsAPI;

    private PlayerPermissionsInformation playerPermissionsInformation;

    public JavaPlugin getPlugin() {
        return this.plugin;
    }

    public LuckPerms getLuckPermsAPI() {
        return this.luckPermsAPI;
    }

    @Deprecated
    public void onStart(JavaPlugin plugin) {
        this.plugin = plugin;
        load();
        playerPermissionsInformation = new PlayerPermissionsInformation();
    }

    public static JavaPlugin getInstance() {
        return rPermsLoader.INSTANCE.getPlugin();
    }

    private void load() {
        logger("Enabling rPerms");
        logger("Handler Lucky perms");
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null)
            this.luckPermsAPI = (LuckPerms)provider.getProvider();
        logger("Register permission channel");
        Bukkit.getMessenger().registerOutgoingPluginChannel(this.plugin, "rPerms");
    }

    public static void sendBungeeMessage(String message) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("rPermsUpdate");
            out.writeUTF(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Player player = Iterables.getFirst(rUtils.getOnlinePlayers(), null);
        if (player == null || !player.isOnline())
            return;
        player.sendPluginMessage(rPermsLoader.INSTANCE.getPlugin(), "rPerms", b.toByteArray());
    }

    public static void logger(String text) {
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7[&erLoader&7] &f" + text));
    }


    @Deprecated
    public void onStop() {
        playerPermissionsInformation.onCancel();
    }
}
