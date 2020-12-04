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
            String team1 = TeamData.getInstance().getTeam((Player) e.getEntity());
            String team2 = TeamData.getInstance().getTeam((Player) e.getDamager());
            if (team1 != null && team1.equals(team2)) {
                e.setCancelled(true);
                e.setDamage(0);
            }
        }
    }

}
