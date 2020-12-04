package fr.sl.zone;

import fr.sl.main.MainClass;
import fr.sl.team.TeamData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTeamBase implements CommandExecutor {

    private MainClass mc;

    public SetTeamBase(MainClass mc) {
        this.mc = mc;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 2) {
                Area area = mc.Areas.getArea(args[0]);
                if (area != null) {
                    if (TeamData.getInstance().teamExist(args[1])) {
                        area.setTeam(args[1]);
                        p.sendMessage("La base" + args[0] + "a etait attribue a l'equipe " + args[1]);
                    } else {
                        p.sendMessage("La team n'a pas etait trouve");
                    }
                } else {
                    p.sendMessage("La base n'as pas etait trouve");
                }
            } else {
                p.sendMessage("La fonction n'est pas bien utilise ! il faut 2 arguments le numero de la base suivi du nom de l'equipe");
            }
        }
        return false;
    }

}
