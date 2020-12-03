package fr.sl.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;

public class PoseBlock implements Listener{
	
	private TeamData team;
	private MainClass mc;
	
	public PoseBlock(MainClass main) {
		this.mc = main;
	}
	
	public void onPutBlock(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		
		
		
	}
}
