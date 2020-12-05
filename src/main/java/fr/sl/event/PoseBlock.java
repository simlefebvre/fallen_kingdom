package fr.sl.event;

import java.awt.Color;
import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;
import fr.sl.zone.Area;

public class PoseBlock implements Listener{
	
	private TeamData team = TeamData.getInstance();
	private MainClass mc;
	
	public PoseBlock(MainClass main) {
		this.mc = main;
	}
	
	@EventHandler
	public void onPutBlock(BlockPlaceEvent e) {
				
		Player p = e.getPlayer();
		Block b = e.getBlock();
		String teamp = team.getTeam(p);
		
		Iterator<Area> li = mc.Areas.getList().iterator();
		boolean test = true;
	    while (li.hasNext() && test) {
	    	Area a = li.next();
	    	if(teamp.equals(a.getTeam())) {
	    		//a vaut la base de la team du joueur
	    		if(!a.isInBase(b.getLocation())) {
	    			if(!b.getType().equals(Material.TNT) && !b.getType().equals(Material.TORCH) && !b.getType().equals(Material.WALL_TORCH)&& !b.getType().equals(Material.REDSTONE_TORCH) && !b.getType().equals(Material.LEVER) && !b.getType().equals(Material.WATER) && !b.getType().equals(Material.LAVA) && !b.getType().equals(Material.FIRE)) {
	    				e.setCancelled(true);
	    				p.sendMessage(ChatColor.RED + "[FK] Vous ne pouvez pas posez le bloc "+b.getType().toString()+" en dehors de votre base !");
	    			}
	    		}	    		
	    	}
	    }
	}
}
