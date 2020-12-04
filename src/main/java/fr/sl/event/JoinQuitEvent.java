package fr.sl.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.sl.main.MainClass;

public class JoinQuitEvent implements Listener{

	private MainClass mc;
	
	public JoinQuitEvent(MainClass mc) {
		this.mc = mc;
	}
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		mc.sbm.PrintSb();
		Player p = e.getPlayer();
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
	}
	
}
