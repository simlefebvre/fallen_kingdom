package fr.sl.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.sl.main.MainClass;

public class Start implements CommandExecutor{
	public MainClass mc;
	public Start(MainClass mc) {
		this.mc = mc;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			if(args.length == 1 && args[0].equalsIgnoreCase("start")) {
				mc.gm.start();
			}
		}
		return false;
	}
}
