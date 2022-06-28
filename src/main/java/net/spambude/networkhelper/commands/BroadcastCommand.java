package net.spambude.networkhelper.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.spambude.networkhelper.Main;

public class BroadcastCommand
        extends Command {
    public BroadcastCommand(String name) {
        super(name);
    }

    /*
    zImSkillz
        2022
     */

    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {

            ProxiedPlayer pp = (ProxiedPlayer)sender;
            if (pp.hasPermission("SpamBude.Broadcast"))
            {
                if (pp.hasPermission("SpamBude.Broadcast")) {

                    if (args.length > 0)
                    {
                        String message = "";
                        for (int i = 0; i < args.length; i++)
                        {

                            message = String.valueOf(message) + args[i] + " ";
                        }

                        message = ChatColor.translateAlternateColorCodes('&', message);

                        ProxyServer.getInstance().broadcast("§a ");
                        ProxyServer.getInstance().broadcast("§8§m------------------------------------");
                        ProxyServer.getInstance().broadcast("§a ");
                        ProxyServer.getInstance().broadcast(Main.getInstance().getPrefix() + message);
                        ProxyServer.getInstance().broadcast("§a ");
                        ProxyServer.getInstance().broadcast("§8§m------------------------------------");
                        ProxyServer.getInstance().broadcast("§a ");

                    }
                    else
                    {
                        pp.sendMessage(Main.getInstance().getPrefix() + "Please use: §c/broadcast <text>");

                    }

                }
                else {
                    sender.sendMessage("§cYou have to be a Player!");
                }
            }
        }
    }
}