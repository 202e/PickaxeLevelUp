package io.github._202e.pickaxelevelup;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Arrays;
import java.util.List;

class PLUListener implements Listener {
    private static final List<Material> picks = Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE,
            Material.IRON_PICKAXE, Material.GOLD_PICKAXE, Material.DIAMOND_PICKAXE);
    private final PickaxeLevelUp plugin;

    PLUListener(PickaxeLevelUp plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent pie) {
        if (plugin.rightClickEnabled && pie.getHand().equals(EquipmentSlot.HAND) &&
                (pie.getAction() == Action.RIGHT_CLICK_AIR || pie.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                picks.contains(pie.getMaterial())) {
            pie.getPlayer().performCommand(plugin.rightClickCommand);
        }
    }
}
