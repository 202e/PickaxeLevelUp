package io.github._202e.pickaxelevelup.commands;

import io.github._202e.pickaxelevelup.PickaxeLevelUp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandLevelUp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                ItemStack held = p.getInventory().getItemInMainHand();
                if (PickaxeLevelUp.picks.contains(held.getType())) {
                    int level = held.getEnchantmentLevel(Enchantment.DIG_SPEED) + 1;
                    held.addUnsafeEnchantment(Enchantment.DIG_SPEED, level);
                    return true;
                }
            }
        }
        return false;
    }
}
