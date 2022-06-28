package net.spambude.networkhelper.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.spambude.networkhelper.Main;

public class PingCommand extends Command {

    /*
    zImSkillz
        2022
     */

    public PingCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        p.sendMessage(Main.getInstance().getPrefix() + "§4" + p.getPing() + "§7Ms§c!" );
    }
}
