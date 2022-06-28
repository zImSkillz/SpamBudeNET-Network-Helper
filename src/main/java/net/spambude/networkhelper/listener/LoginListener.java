package net.spambude.networkhelper.listener;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.spambude.networkhelper.objects.LabyModInfo;
import net.spambude.networkhelper.utils.StringGenerator;

public class LoginListener implements Listener {

    /*
    zImSkillz
        2022
     */

    public static HashMap<String, String> brands = new HashMap<>();

    public static HashMap<String, LabyModInfo> labymod_info = new HashMap<>();



    // https://github.com/StaffCore-Projekt/StaffCore-Bungee/blob/main/src/main/java/de/lacodev/staffbungee/listeners/ListenerLogin.java
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPluginMessageReceived(PluginMessageEvent e) {
        if (e.getSender() instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) e.getSender();
            String player = p.getName();
            try {
                if (e.getTag().contains("labymod")) {
                    if (brands.containsKey(player)) {
                        brands.replace(player, "LabyMod v3");
                    } else {
                        brands.put(player, "LabyMod v3");
                    }
                } else if (e.getTag().contains("LMC")) {
                    String response = StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8"));

                    if (response.startsWith("INFO")) {
                        String stripped_response = response.substring(6);
                        JsonParser parser = new JsonParser();

                        JsonElement element = parser.parse(stripped_response);
                        JsonObject obj = element.getAsJsonObject();

                        String version = obj.get("version").getAsString();
                        ArrayList<String> mods = new ArrayList<>();

                        JsonArray array = obj.get("addons").getAsJsonArray();
                        for (int i = 0; i < array.size(); i++) {
                            JsonObject child = array.get(i).getAsJsonObject();
                            mods.add(child.get("name").getAsString());
                        }

                        if (labymod_info.containsKey(player)) {
                            labymod_info.replace(player, new LabyModInfo(version, mods));
                        } else {
                            labymod_info.put(player, new LabyModInfo(version, mods));
                        }
                    }
                } else if (e.getTag().contains("the5zigmod")) {
                    if (brands.containsKey(player)) {
                        brands.replace(player, "5zig Mod");
                    } else {
                        brands.put(player, "5zig Mod");
                    }
                } else if (e.getTag().contains("MC|Brand")) {
                    if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("lunarclient")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "LunarClient");
                        } else {
                            brands.put(player, "LunarClient");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("vanilla")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "Vanilla");
                        } else {
                            brands.put(player, "Vanilla");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("PLC18")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "PvPLounge");
                        } else {
                            brands.put(player, "PvPLounge");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("LiteLoader")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "LiteLoader");
                        } else {
                            brands.put(player, "LiteLoader");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("StaffCore-Client")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "StaffCore");
                        } else {
                            brands.put(player, "StaffCore");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("Tecknix-Client")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "TecknixClient");
                        } else {
                            brands.put(player, "TecknixClient");
                        }
                    }
                } else if (e.getTag().contains("minecraft:brand")) {
                    if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("lunarclient")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "LunarClient");
                        } else {
                            brands.put(player, "LunarClient");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("vanilla")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "Vanilla");
                        } else {
                            brands.put(player, "Vanilla");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("PX|Version")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "PXMod");
                        } else {
                            brands.put(player, "PXMod");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("l:5zig_Set")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "The 5zig Mod");
                        } else {
                            brands.put(player, "The 5zig Mod");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("hyperium")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "Hyperium");
                        } else {
                            brands.put(player, "Hyperium");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("LC|Brand")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "Winterware");
                        } else {
                            brands.put(player, "Winterware");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("PLC18")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "PvPLounge");
                        } else {
                            brands.put(player, "PvPLounge");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("LOLIMAHACKER")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "Vape");
                        } else {
                            brands.put(player, "Vape");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("StaffCore-Client")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "StaffCore");
                        } else {
                            brands.put(player, "StaffCore");
                        }
                    } else if (StringGenerator.readChannelMessage(new String(e.getData(), "UTF-8")).contains("Tecknix-Client")) {
                        if (brands.containsKey(player)) {
                            brands.replace(player, "TecknixClient");
                        } else {
                            brands.put(player, "TecknixClient");
                        }
                    }
                }
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }
    }
}