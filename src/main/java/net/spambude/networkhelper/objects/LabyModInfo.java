package net.spambude.networkhelper.objects;

import java.util.ArrayList;

public class LabyModInfo {

    /*
    zImSkillz
        2022
     */

    private String version;
    private ArrayList<String> mods = new ArrayList<>();

    public LabyModInfo(String version, ArrayList<String> mods) {
        super();
        this.version = version;
        this.mods = mods;
    }

    public String getVersion() {
        return version;
    }

    public ArrayList<String> getMods() {
        return mods;
    }

}