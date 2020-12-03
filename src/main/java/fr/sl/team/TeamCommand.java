package fr.sl.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TeamCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 1) {
            sender.sendMessage("Wrong command usage see /help fkteam for more information");
        }

        switch (args[0]) {
            case "addTeam": {
                if (args.length != 2) {
                    sender.sendMessage("Wrong command usage see /fkteam addTeam help for more information");
                }

                if (args[1].equals("help")) {
                    sender.sendMessage("Usage : /fkteam addTeam <team name>");
                    return true;
                }

                if (TeamData.getInstance().teamExist(args[1])) {
                    sender.sendMessage(String.format("§4Error : Team %s already exist !", args[1]));
                    return false;
                }

                TeamData.getInstance().createTeam(args[1]);
                sender.sendMessage(String.format("Team %s successfully created", args[1]));

                return true;
            }
            case "addPlayer": {
                if (args.length != 3) {
                    sender.sendMessage("Wrong command usage see /fkteam addPlayer help for more information");
                }
            }
            default: {
                sender.sendMessage(String.format("Unknown sub command: %s see /help fkteam for command list", args[1]));
            }
        }

        return true;
    }

}
