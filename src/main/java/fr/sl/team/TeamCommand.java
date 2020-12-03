package fr.sl.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static class TeamData {
        private static final TeamData instance = new TeamData();
        private final HashMap<String, ArrayList<Player>> Teams;

        private TeamData() {
            Teams = new HashMap<>();
        }

        public boolean teamExist(String name) {
            return Teams.containsKey(name);
        }

        public List<Player> getTeamPlayerList(String teamName) {
            return Teams.get(teamName);
        }

        public void createTeam(String teamName) {
            Teams.put(teamName, new ArrayList<>());
        }

        public static TeamData getInstance() {
            return instance;
        }
    }
}
