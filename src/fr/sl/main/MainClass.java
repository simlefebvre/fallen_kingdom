package fr.sl.main;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sl.commande.CommandeManager;
import fr.sl.event.BreakBlock;

public class MainClass extends JavaPlugin {

	@Override
	
	public void onEnable() {
		System.out.println("[FALLEN KINGDOM] le plugin est bien lancé");
		this.saveDefaultConfig();
		//this.getCommand("fk").setExecutor(new CommandeManager());
		getServer().getPluginManager().registerEvents(new BreakBlock(), this);
	}
	
	public void onDisable() {
		
	}
	
}
