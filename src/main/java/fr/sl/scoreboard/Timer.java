package fr.sl.scoreboard;

import org.bukkit.Bukkit;
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
            		mc.sbm.removeLine("" + seconde + " sec");
            		seconde++;
                    if(seconde == 60) {
                    	mc.sbm.removeLine("" + minute + " min");
                    	seconde = 0;
                    	minute++;
                    	mc.sbm.addLine("" + minute + " min", 1);
                    }
                    if(minute == 20) {
                    	mc.sbm.removeLine("" + jour + " jour");
                    	minute = 0;
                    	jour ++;
                    	mc.sbm.addLine("" + jour + " jour", 2);
                    }
                    mc.sbm.addLine("" + seconde + " sec", 0);
            	}
            }
        }, 20,20);
	}
}
