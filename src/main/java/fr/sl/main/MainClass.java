package fr.sl.main;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sl.event.BreakBlock;
import fr.sl.team.TeamLoader;
import fr.sl.zone.Area;

public class MainClass extends JavaPlugin {

    public static Logger LOGGER;

    public ArrayList<Area> Areas = new ArrayList<Area>();
    
    @Override
    public void onEnable() {
        this.getLogger().info("plugin loaded");
        this.saveDefaultConfig();

        LOGGER = getLogger();

        getServer().getPluginManager().registerEvents(new BreakBlock(this), this);
        
        TeamLoader teamLoader = new TeamLoader(this);
        teamLoader.registerTeamSystem();
    }

    public void onDisable() {

    }
}
