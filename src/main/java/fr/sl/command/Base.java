package fr.sl.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;
import fr.sl.zone.Area;

public class Base implements CommandExecutor{

	MainClass mc;
	public Base(MainClass mc) {
		this.mc = mc;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			TeamData td = TeamData.getInstance();
			String team = td.getTeam(p);
			
			for(Area a : mc.Areas.getList()) {
				if(a.hasTeam() && a.getTeam().equalsIgnoreCase(team)) {
					p.sendMessage("Votre base est en " + a.getCoo1()[0] + ", " + a.getCoo1()[1] + ", " + a.getCoo1()[2]);
				}
			}
		}
		return false;
	}
}
