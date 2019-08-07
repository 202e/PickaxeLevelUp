package io.github._202e.pickaxelevelup;

import org.bukkit.plugin.java.JavaPlugin;

public class PickaxeLevelUp extends JavaPlugin {
    String rightClickCommand;
    boolean rightClickEnabled;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        this.rightClickEnabled = getConfig().getBoolean("rightclickenabled");
        this.rightClickCommand = getConfig().getString("rightclickcommand");

        getServer().getPluginManager().registerEvents(new PLUListener(this), this);
    }
}
