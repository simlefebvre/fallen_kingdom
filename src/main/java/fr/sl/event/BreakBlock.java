package fr.sl.event;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import fr.sl.main.MainClass;

public class BreakBlock implements Listener {
	
	//X en 0, Y en 1 et Z en 2
	private int[] coo1 = {0,0,0};
	private int[] coo2 = {0,0,0};
	private MainClass mc;
	private World wd = null;
	
	public BreakBlock(MainClass main) {
		this.mc = main;
	}
	
    @EventHandler
    public void onBreakBlockEvent(BlockBreakEvent e) {
    	Player p = e.getPlayer();
    	Block b = e.getBlock();
        if (p.getGameMode().equals(GameMode.CREATIVE) && e.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.COMMAND_BLOCK))) {
        	if(coo1[0] == 0 && coo1[1]==0 && coo1[2]==0) {
        		coo1[0] = b.getX();
        		coo1[1] = b.getY();
        		coo1[2] = b.getZ();
        		wd = b.getWorld();
        		p.sendMessage(String.format("Position 1 établie temporairement en %i,%i,%i", coo1[0],coo1[1],coo1[2]));
        	}else {
        		coo2[0] = b.getX();
        		coo2[1] = b.getY();
        		coo2[2] = b.getZ();
        		p.sendMessage(String.format("Position 2 établie temporairement en %i,%i,%i", coo2[0],coo2[1],coo2[2]));
        	}
        	e.setCancelled(true);
        }else if(p.getGameMode().equals(GameMode.CREATIVE) && e.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.WOODEN_AXE))) {
        	mc.getConfig().set("base1.x", coo1[0]);
        	mc.getConfig().set("base1.y", coo1[1]);
        	mc.getConfig().set("base1.z", coo1[2]);
        	mc.getConfig().set("base1.world", wd);
        	mc.getConfig().set("base2.x", coo2[0]);
        	mc.getConfig().set("base2.y", coo2[1]);
        	mc.getConfig().set("base2.z", coo2[2]);
        	mc.getConfig().set("base2.world", wd);
        }
    }
}
