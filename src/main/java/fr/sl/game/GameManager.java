package fr.sl.game;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;
import fr.sl.zone.Area;

public class GameManager {

	
	private MainClass mc;
	private boolean start = false;
	
	public GameManager(MainClass mc) {
		this.mc = mc; 
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
	
	public void start() {
		setStart(true);
		for(Player p : Bukkit.getOnlinePlayers()) {
			String team = TeamData.getInstance().getTeam(p);
			for(Area a : mc.Areas.getList()) {
				if(a.getTeam().equalsIgnoreCase(team)) {
					p.teleport(new Location(a.getW(), a.getCoo1()[0], a.getCoo1()[1]+2, a.getCoo1()[2]));
				}
			}
			p.setGameMode(GameMode.SURVIVAL);
			p.setHealth(20);
			p.setFoodLevel(20);
		}
	}
	
}
