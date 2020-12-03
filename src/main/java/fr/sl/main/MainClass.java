package main.java.fr.sl.main;

import org.bukkit.plugin.java.JavaPlugin;

import main.java.fr.sl.event.BreakBlock;

public class MainClass extends JavaPlugin {

    @Override

    public void onEnable() {
        System.out.println("[FALLEN KINGDOM] le plugin est bien lance");
        this.saveDefaultConfig();
        //this.getCommand("fk").setExecutor(new CommandeManager());
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
    }

    public void onDisable() {

    }

}
