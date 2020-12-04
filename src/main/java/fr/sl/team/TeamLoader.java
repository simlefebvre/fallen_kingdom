package fr.sl.team;

import fr.sl.main.MainClass;

public class TeamLoader {

    private final MainClass main;

    public TeamLoader(MainClass main) {
        this.main = main;
    }

    public void registerTeamSystem() {
        main.getCommand("fkteam").setExecutor(new TeamCommand());

        for (String s : main.getConfig().getKeys(false)) {
            MainClass.LOGGER.info(String.format("non deep key :%s", s));
        }

        for (String s : main.getConfig().getKeys(true)) {
            MainClass.LOGGER.info(String.format("deep key :%s", s));
        }
    }

}
