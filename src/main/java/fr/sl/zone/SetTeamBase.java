package fr.sl.zone;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sl.main.MainClass;

public class SetTeamBase implements CommandExecutor{

	private MainClass mc;
	
	public SetTeamBase(MainClass mc) {
		this.mc = mc;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 2) {
				
			}else {
				
			}
		}
		return false;
	}

}
