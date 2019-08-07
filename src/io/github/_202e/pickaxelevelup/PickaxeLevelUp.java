package io.github._202e.pickaxelevelup;

import io.github._202e.pickaxelevelup.commands.CommandLevelUp;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class PickaxeLevelUp extends JavaPlugin {
    public static final List<Material> picks = Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE,
            Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE);
    String rightClickCommand;
    boolean rightClickEnabled;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        this.rightClickEnabled = getConfig().getBoolean("rightclickenabled");
        this.rightClickCommand = getConfig().getString("rightclickcommand");

        getServer().getPluginManager().registerEvents(new PLUListener(this), this);

        getCommand("levelup").setExecutor(new CommandLevelUp());
    }
}
