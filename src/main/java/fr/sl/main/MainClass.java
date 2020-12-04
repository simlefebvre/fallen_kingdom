package fr.sl.main;

import fr.sl.event.BreakBlock;
import fr.sl.team.TeamLoader;
import fr.sl.team.TeamUnload;
import fr.sl.zone.Area;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

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
        TeamUnload unload = new TeamUnload(this);
        unload.unload();

        this.saveConfig();
    }
}
