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
		System.out.println("X'" + this.coo1[0]);
		System.out.println("Y'" + this.coo1[1]);
		System.out.println("Z'" + this.coo1[2]);
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
		System.out.println(l.toString());
		System.out.println(coo1[0]);
		System.out.println(coo1[1]);
		System.out.println(coo1[2]);
		System.out.println(coo2[0]);
		System.out.println(coo2[1]);
		System.out.println(coo2[2]);
		System.out.println(l.getWorld().toString());
		System.out.println(l.getWorld().getName().equals(w.getName()));
		System.out.println(l.getX() < coo1[0] && l.getX() > coo2[0]);
		System.out.println(l.getY() > coo2[1] - 20);
		System.out.println(l.getZ() < coo1[2] && l.getZ() > coo2[2]); 		
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
