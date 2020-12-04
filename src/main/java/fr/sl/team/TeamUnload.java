package fr.sl.team;

import fr.sl.main.MainClass;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeamUnload {

    private final MainClass mainClass;

    public TeamUnload(MainClass main) {
        mainClass = main;
    }

    public void unload() {

        for (String team : TeamData.getInstance().getTeams()) {
            ArrayList<String> playersUUID = new ArrayList<>();
            for (Player p : TeamData.getInstance().getPlayer(team)) {
                if (p != null)
                    playersUUID.add(p.getUniqueId().toString());
            }

            mainClass.getConfig().set(String.format("team.%s", team), playersUUID);
        }

    }

}
