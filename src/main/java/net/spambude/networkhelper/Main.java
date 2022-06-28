package net.spambude.networkhelper;

import net.md_5.bungee.api.plugin.Plugin;
import net.spambude.networkhelper.commands.*;
import net.spambude.networkhelper.listener.LoginListener;

public final class Main extends Plugin {

    /*
    zImSkillz
        2022
     */


    public static Main instance;

    private String prefix;
    private String noPerms;

    @Override
    public void onEnable() {
        // MSG
        System.out.println(" ");
        System.out.println("   _____                       ____            _      _   _ ______ _______ ");
        System.out.println("  / ____|                     |  _ \\          | |    | \\ | |  ____|__   __|");
        System.out.println(" | (___  _ __   __ _ _ __ ___ | |_) |_   _  __| | ___|  \\| | |__     | |   ");
        System.out.println("  \\___ \\| '_ \\ / _` | '_ ` _ \\|  _ <| | | |/ _` |/ _ \\ . ` |  __|    | |   ");
        System.out.println("  ____) | |_) | (_| | | | | | | |_) | |_| | (_| |  __/ |\\  | |____   | |   ");
        System.out.println(" |_____/| .__/ \\__,_|_| |_| |_|____/ \\__,_|\\__,_|\\___|_| \\_|______|  |_|   ");
        System.out.println("        | |                                                                ");
        System.out.println("        |_|                                                                ");
        System.out.println(" ");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println("ENABLE SPAMBUDENET NETWORK HELPER 1.1");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println(" ");

        // Instance
        instance = this;

        // Default Settings
        setPrefix("§7•§8● §cSpamBude&4NET §8●§7• §8┃ §7");
        setNoPerms(getPrefix() + "§cYou don't §7have §cpermission §7for §cthat!");

        // Listener
        getProxy().getPluginManager().registerListener(this, new LoginListener());

        // Commands
        getProxy().getPluginManager().registerCommand(this, new LabyModCommand("labymod"));
        getProxy().getPluginManager().registerCommand(this, new ClientCheckCommand("checkclient"));
        getProxy().getPluginManager().registerCommand(this, new ClientCheckCommand("clientcheck"));
        getProxy().getPluginManager().registerCommand(this, new ClientCheckCommand("client"));
        getProxy().getPluginManager().registerCommand(this, new PingCommand("ping"));
        getProxy().getPluginManager().registerCommand(this, new BroadcastCommand("announce"));
        getProxy().getPluginManager().registerCommand(this, new BroadcastCommand("announcement"));
        getProxy().getPluginManager().registerCommand(this, new BroadcastCommand("bc"));
        getProxy().getPluginManager().registerCommand(this, new BroadcastCommand("broadcast"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:?"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("about"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:about"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:help"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:me"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:pl"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:plugins"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:ver"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("bukkit:version"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("icanhasbukkit"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("info"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("/calc"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("/eval"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("//eval"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("//calc"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("calc"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("eval"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("plugin"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("plugins"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("pl"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("ver"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("version"));
        getProxy().getPluginManager().registerCommand(this, new FakePluginsCommand("?"));
    }

    @Override
    public void onDisable() {
        // MSG
        System.out.println(" ");
        System.out.println("   _____                       ____            _      _   _ ______ _______ ");
        System.out.println("  / ____|                     |  _ \\          | |    | \\ | |  ____|__   __|");
        System.out.println(" | (___  _ __   __ _ _ __ ___ | |_) |_   _  __| | ___|  \\| | |__     | |   ");
        System.out.println("  \\___ \\| '_ \\ / _` | '_ ` _ \\|  _ <| | | |/ _` |/ _ \\ . ` |  __|    | |   ");
        System.out.println("  ____) | |_) | (_| | | | | | | |_) | |_| | (_| |  __/ |\\  | |____   | |   ");
        System.out.println(" |_____/| .__/ \\__,_|_| |_| |_|____/ \\__,_|\\__,_|\\___|_| \\_|______|  |_|   ");
        System.out.println("        | |                                                                ");
        System.out.println("        |_|                                                                ");
        System.out.println(" ");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println("DISABLE SPAMBUDENET NETWORK HELPER 1.1");
        System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~");
        System.out.println(" ");
    }

    public String getPrefix(){
        return this.prefix;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    public void setNoPerms(String noperms){
        this.noPerms = noperms;
    }

    public String getNoPerms() {
        return  this.noPerms;
    }

    public static Main getInstance() {
        return instance;
    }
}
