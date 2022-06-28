package net.spambude.networkhelper.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.spambude.networkhelper.Main;

public class FakePluginsCommand extends Command {

    /*
    zImSkillz
        2022
     */

    public FakePluginsCommand(String name) {
        super(name);
    }

    public void execute(CommandSender commandSender, String[] args) {

        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) commandSender;

        if(args.length == 0) {
            if(proxiedPlayer.hasPermission("SpamBude.otherCommands")) {

            }
        } else {
            {

                proxiedPlayer.sendMessage(Main.getInstance().getNoPerms());
            }
        }
    }

}
