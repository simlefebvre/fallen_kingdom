package fr.sl.team;

import fr.sl.main.MainClass;
import org.bukkit.Bukkit;

import java.util.UUID;
import java.util.stream.Collectors;

public class TeamLoader {

    private final MainClass main;

    public TeamLoader(MainClass main) {
        this.main = main;
    }

    public void registerTeamSystem() {
        main.getCommand("fkteam").setExecutor(new TeamCommand());

        for (String s : main.getConfig().getKeys(true).stream().filter(s -> s.startsWith("team")).collect(Collectors.toList())) {
            if (!s.contains("."))
                continue;
            String team = (String) s.subSequence(s.indexOf(".") + 1, s.length());
            TeamData.getInstance().createTeam(team);
            
            main.getConfig().getList(s).forEach(uuid -> {
                TeamData.getInstance().addPlayerToTeam(Bukkit.getServer().getPlayer(UUID.fromString((String) uuid)), team);
            });
        }
    }

}
