package fr.sl.team;

import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamData {
    private static final TeamData instance = new TeamData();
    private final HashMap<String, ArrayList<OfflinePlayer>> teams;
    private final HashMap<OfflinePlayer, String> players;

    private TeamData() {
        teams = new HashMap<>();
        players = new HashMap<>();
    }

    public boolean teamExist(String name) {
        return teams.containsKey(name);
    }

    public String[] getTeams() {
        return teams.keySet().toArray(new String[0]);
    }

    public OfflinePlayer[] getPlayer(String team) {
        return teams.get(team).toArray(new OfflinePlayer[0]);
    }

    public void createTeam(String teamName) {
        teams.put(teamName, new ArrayList<>());
    }

    public static TeamData getInstance() {
        return instance;
    }

    public void addPlayerToTeam(OfflinePlayer player, String teamName) {
        if (!teams.containsKey(teamName)) {
            return;
        }
        if (players.containsKey(player)) {
            teams.get(players.get(player)).remove(player);
        }
        if (!teams.get(teamName).contains(player)) {
            teams.get(teamName).add(player);
        }
        players.put(player, teamName);
    }

    public String getTeam(OfflinePlayer player) {
        return players.get(player);
    }

}
