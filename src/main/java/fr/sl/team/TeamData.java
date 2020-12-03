package fr.sl.team;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamData {
    private static final TeamData instance = new TeamData();
    private final HashMap<String, ArrayList<Player>> teams;
    private final HashMap<Player, String> players;

    private TeamData() {
        teams = new HashMap<>();
        players = new HashMap<>();
    }

    public boolean teamExist(String name) {
        return teams.containsKey(name);
    }

    public void createTeam(String teamName) {
        teams.put(teamName, new ArrayList<>());
    }

    public static TeamData getInstance() {
        return instance;
    }

    public void addPlayerToTeam(Player player, String teamName) {
        if (!teams.containsKey(teamName)) {
            return;
        }
        if (!teams.get(teamName).contains(player)) {
            teams.get(teamName).add(player);
        }
        players.put(player, teamName);
    }

    public String getTeam(Player player) {
        return players.get(player);
    }

}
