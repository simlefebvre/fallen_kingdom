package fr.sl.command.completion;

import fr.sl.command.CompletionProvider;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class PlayerNameProvider implements CompletionProvider {

    @Override
    public List<String> getPossibilities() {
        ArrayList<String> players = new ArrayList<>();
        Bukkit.getServer().getOnlinePlayers().forEach(player -> players.add(player.getName()));
        return players;
    }
}
