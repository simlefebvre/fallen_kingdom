package fr.sl.team;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamData {
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
