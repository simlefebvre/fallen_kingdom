package fr.sl.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;

public class PoseBlock implements Listener{
	
	private TeamData team = TeamData.getInstance();
	private MainClass mc;
	
	public PoseBlock(MainClass main) {
		this.mc = main;
	}
	
	public void onPutBlock(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		String teamp = TeamData.getInstance().getTeam(p);
		
		//if(mc.Areas.get(0).isInBase(b.getLocation())){
			//if(!teamp.equals(mc.Areas.get(0).getTeam())) {
				//e.setCancelled(cancel);
		//	}
		//}
		
	}
}
