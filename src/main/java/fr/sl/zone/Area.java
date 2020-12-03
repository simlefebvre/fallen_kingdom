package fr.sl.zone;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.sl.team.TeamData;

public class Area {

	private int[] coo1 ;//tout au max;
	private int[] coo2;//tout au min
	private World w;
	private int id;
	private String team;
	private TeamData td = TeamData.getInstance();
	
	public Area(int[] coo1,int[] coo2,int id, String team) {
		this.coo1 = coo1;
		this.coo2 = coo2;
		this.id = id;
		this.team = team;
	}
	public Area(int[] coo1,int[] coo2,int id) {
		this.coo1 = coo1;
		this.coo2 = coo2;
		this.id = id;
	}
	
	public void setTeam(String Team) {
		this.team = Team;
	}
	
	public boolean isPlayerInBase(Player p) {
		
		if(td.getTeam(p)==team && p.getWorld().equals(w) &&p.getLocation().getX() < coo1[0] && p.getLocation().getX() > coo2[0] && p.getLocation().getY() < coo1[0] && p.getLocation().getY() > coo2[0] &&  p.getLocation().getZ() < coo1[0] && p.getLocation().getZ() > coo2[0]) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
