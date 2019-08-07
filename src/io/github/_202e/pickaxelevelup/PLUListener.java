package io.github._202e.pickaxelevelup;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

class PLUListener implements Listener {
    private final PickaxeLevelUp plugin;

    PLUListener(PickaxeLevelUp plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent pie) {
        if (plugin.rightClickEnabled && pie.getHand().equals(EquipmentSlot.HAND) &&
                (pie.getAction() == Action.RIGHT_CLICK_AIR || pie.getAction() == Action.RIGHT_CLICK_BLOCK) &&
                PickaxeLevelUp.picks.contains(pie.getMaterial())) {
            pie.getPlayer().performCommand(plugin.rightClickCommand);
        }
    }
}
