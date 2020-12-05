package fr.sl.main;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sl.command.Base;
import fr.sl.event.BreakBlock;
import fr.sl.event.HitDude;
import fr.sl.event.JoinQuitEvent;
import fr.sl.event.PoseBlock;
import fr.sl.game.GameManager;
import fr.sl.game.Start;
import fr.sl.scoreboard.ScoreBoardManager;
import fr.sl.scoreboard.Timer;
import fr.sl.team.TeamLoader;
import fr.sl.team.TeamUnload;
import fr.sl.zone.AreaList;
import fr.sl.zone.SetTeamBase;

public class MainClass extends JavaPlugin {

    public static Logger LOGGER;

    public AreaList Areas = new AreaList();
    public Timer timer;
    public ScoreBoardManager sbm;
    public GameManager gm;
    
    @Override
    public void onEnable() {
        this.getLogger().info("plugin loaded");
        this.saveDefaultConfig();

        LOGGER = getLogger();

        getServer().getPluginManager().registerEvents(new BreakBlock(this), this);
        getServer().getPluginManager().registerEvents(new PoseBlock(this), this);
        getServer().getPluginManager().registerEvents(new HitDude(), this);
        getServer().getPluginManager().registerEvents(new JoinQuitEvent(this), this);

        this.getCommand("fkstart").setExecutor(new Start(this));
        this.getCommand("base").setExecutor(new Base(this));
        this.getCommand("fkteambase").setExecutor(new SetTeamBase(this));
        TeamLoader teamLoader = new TeamLoader(this);
        teamLoader.registerTeamSystem();
        
        sbm = new ScoreBoardManager(this);
        timer = new Timer(this);
        gm = new GameManager(this);
        
    }

    public void onDisable() {
        TeamUnload unload = new TeamUnload(this);
        unload.unload();

        this.saveConfig();
    }
}
