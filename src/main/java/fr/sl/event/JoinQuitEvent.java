package fr.sl.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;
import fr.sl.team.TeamLoader;
import fr.sl.zone.Area;

public class JoinQuitEvent implements Listener{

	private MainClass mc;
	
	public JoinQuitEvent(MainClass mc) {
		this.mc = mc;
	}
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		mc.sbm.PrintSb();
		Player p = e.getPlayer();
		String t = TeamData.getInstance().getTeam(p);
		if(t!=null) {
			if(t.equalsIgnoreCase("rouge") || t.equalsIgnoreCase("red")) {
				p.setPlayerListName(ChatColor.RED + p.getName());
				p.setDisplayName(ChatColor.RED + p.getName());
			}else if(t.equalsIgnoreCase("bleu") || t.equalsIgnoreCase("blue")) {
				p.setPlayerListName(ChatColor.BLUE + p.getName());
				p.setDisplayName(ChatColor.BLUE + p.getName());
			}else if(t.equalsIgnoreCase("vert") || t.equalsIgnoreCase("green")) {
				p.setPlayerListName(ChatColor.GREEN + p.getName());
				p.setDisplayName(ChatColor.GREEN + p.getName());
			}else if(t.equalsIgnoreCase("jaune") || t.equalsIgnoreCase("yellow")) {
				p.setPlayerListName(ChatColor.YELLOW + p.getName());
				p.setDisplayName(ChatColor.YELLOW + p.getName());
			}	
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
	}
	
}
