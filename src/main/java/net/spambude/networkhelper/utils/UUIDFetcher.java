/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package net.spambude.networkhelper.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class UUIDFetcher {
    public static final long FEBRUARY_2015 = 1422748800000L;
    private static Gson gson = new GsonBuilder().registerTypeAdapter(UUID.class, (Object)new UUIDTypeAdapter()).create();
    private static final String UUID_URL = "https://api.mojang.com/users/profiles/minecraft/%s?at=%d";
    private static final String NAME_URL = "https://api.mojang.com/user/profiles/%s/names";
    private static Map<String, UUID> uuidCache = new HashMap<String, UUID>();
    private static Map<UUID, String> nameCache = new HashMap<UUID, String>();
    private static ExecutorService pool = Executors.newCachedThreadPool();
    private String name;
    private UUID id;

    public static void getUUID(String name, Consumer<UUID> action) {
        pool.execute(() -> action.accept(UUIDFetcher.getUUID(name)));
    }

    public static UUID getUUID(String name) {
        return UUIDFetcher.getUUIDAt(name, System.currentTimeMillis());
    }

    public static void getUUIDAt(String name, long timestamp, Consumer<UUID> action) {
        pool.execute(() -> action.accept(UUIDFetcher.getUUIDAt(name, timestamp)));
    }

    public static UUID getUUIDAt(String name, long timestamp) {
        if (uuidCache.containsKey(name = name.toLowerCase())) {
            return uuidCache.get(name);
        }
        try {
            HttpURLConnection connection = (HttpURLConnection)new URL(String.format(UUID_URL, name, timestamp / 1000L)).openConnection();
            connection.setReadTimeout(5000);
            UUIDFetcher data = (UUIDFetcher)gson.fromJson((Reader)new BufferedReader(new InputStreamReader(connection.getInputStream())), UUIDFetcher.class);
            uuidCache.put(name, data.id);
            nameCache.put(data.id, data.name);
            return data.id;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getName(UUID uuid, Consumer<String> action) {
        pool.execute(() -> action.accept(UUIDFetcher.getName(uuid)));
    }

    public static String getName(UUID uuid) {
        if (nameCache.containsKey(uuid)) {
            return nameCache.get(uuid);
        }
        try {
            HttpURLConnection connection = (HttpURLConnection)new URL(String.format(NAME_URL, UUIDTypeAdapter.fromUUID(uuid))).openConnection();
            connection.setReadTimeout(5000);
            UUIDFetcher[] nameHistory = (UUIDFetcher[])gson.fromJson((Reader)new BufferedReader(new InputStreamReader(connection.getInputStream())), UUIDFetcher[].class);
            UUIDFetcher currentNameData = nameHistory[nameHistory.length - 1];
            uuidCache.put(currentNameData.name.toLowerCase(), uuid);
            nameCache.put(uuid, currentNameData.name);
            return currentNameData.name;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

