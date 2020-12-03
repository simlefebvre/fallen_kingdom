package fr.sl.main;

import fr.sl.event.BreakBlock;
import fr.sl.team.TeamLoader;
import fr.sl.zone.Area;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MainClass extends JavaPlugin {

    public Area Area1;
    public Area Area2;
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        this.getLogger().info("plugin loaded");
        this.saveDefaultConfig();

        LOGGER = getLogger();

        //this.getCommand("fk").setExecutor(new CommandeManager());
        getServer().getPluginManager().registerEvents(new BreakBlock(this), this);
        TeamLoader teamLoader = new TeamLoader(this);
        teamLoader.registerTeamSystem();
    }

    public void onDisable() {

    }
}
