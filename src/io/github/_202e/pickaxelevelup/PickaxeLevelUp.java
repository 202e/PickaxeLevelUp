package io.github._202e.pickaxelevelup;

import org.bukkit.plugin.java.JavaPlugin;

public class PickaxeLevelUp extends JavaPlugin {
    String rightClickCommand = "";
    boolean rightClickEnabled = true;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PLUListener(this), this);
    }
}
