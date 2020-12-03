package fr.sl.zone;

import org.bukkit.Location;
import org.bukkit.World;

import fr.sl.team.TeamData;

public class Area {

	private int[] coo1 ;//tout au max;
	private int[] coo2;//tout au min
	private World w;
	private int id;
	private String team = null;
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
	public boolean hasTeam() {
		return team != null;
	}
	public void setTeam(String Team) {
		this.team = Team;
	}
	
	public boolean isInBase(Location l) {
		if(l.getWorld().equals(w) && l.getX() < coo1[0] && l.getX() > coo2[0] && l.getY() > coo2[0] - 20 &&  l.getZ() < coo1[0] && l.getZ() > coo2[0]) {
			return true;
		}else {
			return false;
		}
	}
}
