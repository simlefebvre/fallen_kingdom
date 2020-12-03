package fr.sl.team;

import fr.sl.main.MainClass;

public class TeamLoader {

    private final MainClass main;

    public TeamLoader(MainClass main) {
        this.main = main;
    }

    public void registerTeamSystem() {
        main.getCommand("fkteam").setExecutor(new TeamCommand());
    }

}
