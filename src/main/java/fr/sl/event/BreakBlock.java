package fr.sl.event;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BreakBlock implements Listener {

    @EventHandler
    public void onBreakBlockEvent(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE) && e.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.COMMAND))) {

        }
    }
}
