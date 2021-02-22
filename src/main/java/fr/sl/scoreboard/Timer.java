package fr.sl.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitScheduler;

import fr.sl.main.MainClass;

public class Timer {

	private MainClass mc;
	private int seconde, jour, minute;
	
	public Timer(MainClass mc) {
		this.mc = mc;
		clock();
	}
	
	public void clock() {
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(mc, new Runnable() {
            @Override
            public void run() {
            	if(mc.gm.isStart()) {
            		mc.sbm.removeLine(minute + " : " + seconde);
            		mc.sbm.removeLine("" + jour + ChatColor.GREEN + " jour");
            		seconde++;
                    if(seconde == 60) {
                    	seconde = 0;
                    	minute++;
                    }
                    if(minute == 20) {
                    	
                    	minute = 0;
                    	jour ++;
                    	
                    }
                    if(jour == 1 && !mc.gm.isPvp()) {
                    	mc.gm.setPvp(true);
                		mc.sbm.removeLine(ChatColor.RED + "PvP : " + ChatColor.BOLD + "X");
                    	mc.sbm.addLine(ChatColor.GREEN + "PvP : " + ChatColor.BOLD + "V", -2);
                    }else if(jour == 4 && !mc.gm.isNether()) {
                    	mc.gm.setNether(true);
                    	mc.sbm.removeLine(ChatColor.RED + "Nether : " + ChatColor.BOLD + "X");
                    	mc.sbm.addLine(ChatColor.GREEN + "Nether : " + ChatColor.BOLD + "V", -3);
                    	
                    }else if(jour == 6 && !mc.gm.isAssaut()) {
                    	mc.gm.setPvp(true);
                		mc.sbm.removeLine(ChatColor.RED + "Assaut : " + ChatColor.BOLD + "X");
                    	mc.sbm.addLine(ChatColor.GREEN + "Assaut : " + ChatColor.BOLD + "V", -4);
                    }
                    mc.sbm.addLine(minute + " : " + seconde,0);
                    mc.sbm.addLine("" + jour + ChatColor.GREEN + " jour", 2);
            	}
            }
        }, 20,20);
	}
}
