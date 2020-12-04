package fr.sl.main;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.sl.event.BreakBlock;
import fr.sl.event.HitDude;
import fr.sl.event.PoseBlock;
import fr.sl.scoreboard.ScoreBoardManager;
import fr.sl.team.TeamLoader;
import fr.sl.team.TeamUnload;
import fr.sl.zone.AreaList;
import fr.sl.zone.SetTeamBase;

public class MainClass extends JavaPlugin {

    public static Logger LOGGER;

    public AreaList Areas = new AreaList();
    
    public ScoreBoardManager sbm;
    @Override
    public void onEnable() {
        this.getLogger().info("plugin loaded");
        this.saveDefaultConfig();

        LOGGER = getLogger();

        getServer().getPluginManager().registerEvents(new BreakBlock(this), this);
        getServer().getPluginManager().registerEvents(new PoseBlock(this), this);
        getServer().getPluginManager().registerEvents(new HitDude(), this);

        this.getCommand("fkteambase").setExecutor(new SetTeamBase(this));
        TeamLoader teamLoader = new TeamLoader(this);
        teamLoader.registerTeamSystem();
        
        sbm = new ScoreBoardManager(this);
        
    }

    public void onDisable() {
        TeamUnload unload = new TeamUnload(this);
        unload.unload();

        this.saveConfig();
    }
}
