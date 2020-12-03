package fr.sl.main;

import fr.sl.event.BreakBlock;
import fr.sl.team.TeamLoader;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    @Override

    public void onEnable() {
        System.out.println("[FALLEN KINGDOM] le plugin est bien lance");
        this.saveDefaultConfig();
        //this.getCommand("fk").setExecutor(new CommandeManager());
        getServer().getPluginManager().registerEvents(new BreakBlock(this), this);
        TeamLoader teamLoader = new TeamLoader(this);
        teamLoader.registerTeamSystem();
    }

    public void onDisable() {

    }

}
