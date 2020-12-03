package fr.sl.main;

import org.bukkit.plugin.java.JavaPlugin;

import fr.sl.commande.CommandeManager;

public class MainClass extends JavaPlugin {

	@Override
	
	public void onEnable() {
		System.out.println("[FALLEN KINGDOM] le plugin est bien lancé");
		this.getCommand("fk").setExecutor(new CommandeManager());
	}
	
	public void onDisable() {
		
	}
	
}
