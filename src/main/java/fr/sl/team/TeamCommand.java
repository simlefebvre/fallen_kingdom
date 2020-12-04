package fr.sl.team;

import fr.sl.utils.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static java.lang.String.format;

public class TeamCommand implements CommandExecutor {

    TeamData data;

    public TeamCommand() {
        super();
        data = TeamData.getInstance();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 1) {
            sender.sendMessage("Wrong command usage see /help fkteam for more information");
        }

        switch (args[0]) {
            case "addTeam": {
                if (!CommandUtils.basicCommandTest(sender, "fkteam addTeam", args, 2))
                    return false;

                if (data.teamExist(args[1])) {
                    sender.sendMessage(format("§4Error : Team %s already exist !", args[1]));
                    return false;
                }

                data.createTeam(args[1]);
                sender.sendMessage(format("Team %s successfully created", args[1]));

                return true;
            }
            case "addPlayer": {

                if (!CommandUtils.basicCommandTest(sender, "fkteam Player", args, 3))
                    return false;

                Player player = Bukkit.getServer().getPlayer(args[1]);
                if (player == null) {
                    sender.sendMessage(format("Unknown player %s", args[1]));
                    return false;
                }
                if (!data.teamExist(args[2])) {
                    sender.sendMessage(format("Unknown team %s", args[2]));
                    return false;
                }
                data.addPlayerToTeam(player, args[2]);
                sender.sendMessage(format("Successfully added %s to team %s", args[1], args[2]));
                return true;

            }
            case "list": {

                if (!CommandUtils.basicCommandTest(sender, "fkteam list", args, 2, 2, false))
                    return false;
                StringBuilder msg = new StringBuilder(format("List of %ss", args[1]));
                switch (args[1]) {
                    case "team": {
                        msg.append(" :");
                        for (String teamName : data.getTeams()) {
                            msg.append(teamName);
                            msg.append(" ");
                        }
                        sender.sendMessage(msg.toString());
                        return true;
                    }
                    case "player": {
                        if (!CommandUtils.basicCommandTest(sender, "fkteam list", args, 3))
                            return false;
                        if (data.teamExist(args[2])) {
                            msg.append(format(" in team %s :", args[3]));
                            for (Player p : data.getPlayer(args[3])) {
                                msg.append(format("%s ", p.getName()));
                            }
                        }
                        return true;
                    }
                }
            }
            default: {
                sender.sendMessage(format("Unknown sub command: %s see /help fkteam for command list", args[1]));
                return false;
            }
        }
    }
}
