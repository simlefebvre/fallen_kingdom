package fr.sl.team;

import fr.sl.main.MainClass;

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
            MainClass.LOGGER.info(String.format("Team found : %s", s.subSequence(s.indexOf(".") + 1, s.length())));
        }
    }

}
