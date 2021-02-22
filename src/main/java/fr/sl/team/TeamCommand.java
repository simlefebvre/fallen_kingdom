package fr.sl.team;

import fr.sl.command.CommandHandler;
import fr.sl.command.CompletionProvider;
import fr.sl.command.completion.PlayerNameProvider;
import fr.sl.utils.CommandUtils;
import org.bukkit.Bukkit;
<<<<<<<HEAD
import org.bukkit.OfflinePlayer;
=======
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
>>>>>>>570a9d89ba742f6cb3b9613cf81b65f23dfc6f0c
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class TeamCommand {
    public static CommandHandler getCommandHandler(JavaPlugin plugin) {
        TeamData data = TeamData.getInstance();
        CommandHandler command = new CommandHandler("fkTeam", null, null, plugin);

        CommandHandler addTeam = new CommandHandler("addTeam", null, null, null,
                (sender, command1, label, args, argsTrace, handler) -> {
                    if (!CommandUtils.basicCommandTest(sender, "fkteam addTeam", args, 1))
                        return false;

                    if (data.teamExist(args[0])) {
                        sender.sendMessage(format("§4Error : Team %s already exist !", args[0]));
                        return false;
                    }

                    data.createTeam(args[1]);
                    sender.sendMessage(format("Team %s successfully created", args[0]));

                    return true;
                });

        CommandHandler addPlayer = new CommandHandler("addPlayer", null, new CompletionProvider[]{new PlayerNameProvider(),
                () -> Arrays.asList(data.getTeams())},
                null,
                (sender, command1, label, args, argsTrace, handler) -> {
                    if (!CommandUtils.basicCommandTest(sender, "fkteam Player", args, 2))
                        return false;

                    OfflinePlayer player = Bukkit.getServer().getPlayer(args[0]);

                    if (player == null) {
                        sender.sendMessage(format("Unknown player %s", args[0]));
                        return false;
                    }
                    if (!data.teamExist(args[2])) {
                        sender.sendMessage(format("Unknown team %s", args[1]));
                        return false;
                    }

                    data.addPlayerToTeam(player, args[2]);
                    sender.sendMessage(format("Successfully added %s to team %s", args[0], args[1]));
                    return true;
                });

        command.addSubCommand(addTeam);
        command.addSubCommand(addPlayer);

        return command;
    }
}
