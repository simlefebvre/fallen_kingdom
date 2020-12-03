package fr.sl.main;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sl.event.BreakBlock;
import fr.sl.team.TeamLoader;
import fr.sl.zone.Area;

public class MainClass extends JavaPlugin {

	public Area Area1;
	public Area Area2;
	
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
