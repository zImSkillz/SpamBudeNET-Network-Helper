package net.spambude.networkhelper.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.spambude.networkhelper.Main;
import net.spambude.networkhelper.manager.PlayerManager;
import net.spambude.networkhelper.utils.UUIDFetcher;

public class ClientCheckCommand extends Command {

    /*
    zImSkillz
        2022
     */

    // https://github.com/StaffCore-Projekt/StaffCore-Bungee/blob/main/src/main/java/de/lacodev/staffbungee/commands/CMDCheckPlayer.java

    public ClientCheckCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof ProxiedPlayer) {

            ProxiedPlayer player = (ProxiedPlayer) sender;

            if (player.hasPermission("SpamBude.CheckCLient")){

                if (args.length == 1) {
                    String name = args[0];
                    String uuid = UUIDFetcher.getUUID(name).toString();


                    Main.getInstance().getProxy().getScheduler().runAsync(Main.getInstance(), new Runnable() {

                        @Override
                        public void run() {

                            player.sendMessage(PlayerManager.getStatus(uuid));

                        }

                    });
                } else {
                    player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §cPlease use /clientcheck <player>"));
                }

            } else {
                player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §cYou don't have permission for that"));
            }


        } else {

            CommandSender player = sender;

            if (args.length == 1) {

                String name = args[0];
                String uuid = UUIDFetcher.getUUID(name).toString();

                Main.getInstance().getProxy().getScheduler().runAsync(Main.getInstance(), new Runnable() {

                    @Override
                    public void run() {
                        player.sendMessage(PlayerManager.getStatus(uuid));
                    }

                });

            } else {
                sender.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §cPlease use /clientcheck <player>"));
            }
        }

    }
}