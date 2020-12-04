package fr.sl.command;

import org.bukkit.command.CommandSender;

public interface SubCommandHandler {

    boolean handleSubCommand(CommandSender sender, String[] args);

}
