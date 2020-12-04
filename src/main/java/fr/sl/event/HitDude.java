package fr.sl.event;

import fr.sl.team.TeamData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitDude implements Listener {

    public HitDude() {
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            if (TeamData.getInstance().getTeam((Player) e.getEntity()) == TeamData.getInstance().getTeam((Player) e.getDamager())) {
                e.setCancelled(true);
                e.setDamage(0);
            }
        }
    }

}
