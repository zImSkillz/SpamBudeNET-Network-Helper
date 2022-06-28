package net.spambude.networkhelper.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.spambude.networkhelper.listener.LoginListener;
import net.spambude.networkhelper.objects.LabyModInfo;

public class LabyModCommand extends Command {

    /*
    zImSkillz
        2022
     */

    // https://github.com/StaffCore-Projekt/StaffCore-Bungee/blob/main/src/main/java/de/lacodev/staffbungee/commands/CMDLabyMod.java

    public LabyModCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof ProxiedPlayer) {

            ProxiedPlayer player = (ProxiedPlayer) sender;

            if (player.hasPermission("SpamBude.LabyModCommand")) {

                if (args.length == 2) {

                    if (args[0].equalsIgnoreCase("info")) {

                        String username = args[1];

                        if (LoginListener.labymod_info.containsKey(username)) {

                            LabyModInfo info = LoginListener.labymod_info.get(username);

                            player.sendMessage(new TextComponent(""));
                            player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7LabyMod Information about §c" + username));
                            player.sendMessage(new TextComponent(""));
                            player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7LabyMod Version §8» §c" + info.getVersion()));
                            player.sendMessage(new TextComponent(""));
                            player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§cInstalled Mods:"));
                            player.sendMessage(new TextComponent(""));
                            for (int i = 0; i < info.getMods().size(); i++) {
                                player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7" + info.getMods().get(i)));
                            }
                            player.sendMessage(new TextComponent(""));
                        } else {
                            player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§cNo information about this player"));
                        }

                    } else {
                        player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7/labymod info <Player>"));
                    }

                } else {
                    player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7/labymod info <Player>"));
                }

            } else {
                player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ You don't have permission for that"));
            }

        } else {
            CommandSender player = sender;

            if (args.length == 2) {

                if (args[0].equalsIgnoreCase("info")) {

                    String username = args[1];

                    if (LoginListener.labymod_info.containsKey(username)) {

                        LabyModInfo info = LoginListener.labymod_info.get(username);

                        player.sendMessage(new TextComponent(""));
                        player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7LabyMod Information about §c" + username));
                        player.sendMessage(new TextComponent(""));
                        player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7LabyMod Version §8» §c" + info.getVersion()));
                        player.sendMessage(new TextComponent(""));
                        player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§cInstalled Mods:"));
                        player.sendMessage(new TextComponent(""));
                        for (int i = 0; i < info.getMods().size(); i++) {
                            player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7" + info.getMods().get(i)));
                        }
                        player.sendMessage(new TextComponent(""));
                    } else {
                        player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§cNo information about this player"));
                    }

                } else {
                    player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7/labymod info <Player>"));
                }

            } else {
                player.sendMessage(new TextComponent("§7•§8● §cSpamBude§4NET §8●§7• §8┃ §7§7/labymod info <Player>"));
            }
        }

    }

}