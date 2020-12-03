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
	private void saveBaseConfig(int base) {
		mc.getConfig().set(String.format("base%d.pos1.x",base), coo1[0]);
    	mc.getConfig().set(String.format("base%d.pos1.y",base), coo1[1]);
    	mc.getConfig().set(String.format("base%d.pos1.z",base), coo1[2]);
    	mc.getConfig().set(String.format("base%d.world",base), wd.getName());
    	mc.getConfig().set(String.format("base%d.pos2.x",base), coo2[0]);
    	mc.getConfig().set(String.format("base%d.pos2.y",base), coo2[1]);
    	mc.getConfig().set(String.format("base%d.pos2.z",base), coo2[2]);
    	mc.saveConfig();
    	
    	
    	coo1[0] = 0;
		coo1[1] = 0;
		coo1[2] = 0;
		coo2[0] = 0;
		coo2[1] = 0;
		coo2[2] = 0;
	}
    @EventHandler
    public void onBreakBlockEvent(BlockBreakEvent e) {
    	Player p = e.getPlayer();
    	Block b = e.getBlock();
        if (p.getGameMode().equals(GameMode.CREATIVE) && e.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.COMMAND_BLOCK))) {
        	if((coo1[0] == 0 && coo1[1]==0 && coo1[2]==0) ||(coo2[0] != 0 && coo2[1] != 0 && coo2[2]!=0)) {
        		coo1[0] = b.getX();
        		coo1[1] = b.getY();
        		coo1[2] = b.getZ();
        		coo2[0] = 0;
        		coo2[1] = 0;
        		coo2[2] = 0;
        		wd = b.getWorld();
        		p.sendMessage(String.format("Position 1 etabli temporairement en %d,%d,%d", coo1[0],coo1[1],coo1[2]));
        	}else {
        		coo2[0] = b.getX();
        		coo2[1] = b.getY();
        		coo2[2] = b.getZ();
        		p.sendMessage(String.format("Position 2 etabli temporairement en %d,%d,%d", coo2[0],coo2[1],coo2[2]));
        	}
        	e.setCancelled(true);
        }else if(p.getGameMode().equals(GameMode.CREATIVE) && e.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.WOODEN_AXE))) {
        	e.setCancelled(true);
        	saveBaseConfig(1);
        	p.sendMessage("Le fichier de config a bien etait mis a jours");
        }else if(p.getGameMode().equals(GameMode.CREATIVE) && e.getPlayer().getInventory().getItemInMainHand().equals(new ItemStack(Material.STONE_AXE))) {
        	e.setCancelled(true);
        	saveBaseConfig(2);
        	p.sendMessage("Le fichier de config a bien etait mis a jours");
        }
        
    }
}
