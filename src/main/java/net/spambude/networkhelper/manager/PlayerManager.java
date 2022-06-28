package net.spambude.networkhelper.manager;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.spambude.networkhelper.listener.LoginListener;
import net.spambude.networkhelper.utils.VersionDetector;

import java.util.UUID;

public class PlayerManager {

    /*
    zImSkillz
        2022
     */

    public static String getStatus(String uuid) {
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(UUID.fromString(uuid));

        if (player != null) {
            if (player.isForgeUser()) {
                return "§aOnline §8| §cFORGE §8| §7" + VersionDetector.getClientProtocol(player.getPendingConnection());
            } else {
                return "§aOnline §8| §c" + getBrand(player.getName()) + " §8| §7" +
                        VersionDetector.getClientProtocol(player.getPendingConnection());
            }
        } else {
            return "§cOffline";
        }
    }

    public static String getBrand(String name) {
        return LoginListener.brands.get(name);
    }

}
