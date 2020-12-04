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
	
	public Area(int[] coo1,int[] coo2,int id,World w, String team) {
		this.coo1 = coo1.clone();
		this.coo2 = coo2.clone();
		this.w = w;
		this.id = id;
		this.team = team;
	}
	public Area(int[] coo1,int[] coo2,World w,int id) {
		System.out.println("X" + coo1[0]);
		this.coo1 = coo1.clone();
		this.coo2 = coo2.clone();
		this.w = w;
		this.id = id;
	}
	public boolean hasTeam() {
		return team != null;
	}
	public void setTeam(String Team) {
		this.team = Team;
	}
	
	public String toString() {
		return "X : " + coo1[0] + "Y : " + coo1[1] + " Z : " +coo1[2];
	}
	
	public boolean isInBase(Location l) {
		if(l.getWorld().equals(w) && l.getX() < coo1[0] && l.getX() > coo2[0] && l.getY() > coo2[1] - 20 &&  l.getZ() < coo1[2] && l.getZ() > coo2[2]) {
			return true;
		}else {
			return false;
		}
	}
	public String getTeam() {
		// TODO Auto-generated method stub
		return this.team;
	}
	public int getIndex() {
		return id;
	}
}
