package fr.sl.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CommandHandler implements CommandExecutor, TabCompleter {

    private final String prefix;
    private ArrayList<String> aliases;
    private final ArrayList<CommandHandler> subCommands = new ArrayList<>();

    public CommandHandler(String prefix, List<String> aliases, JavaPlugin plugin) {
        if (plugin != null) {
            Command command = plugin.getCommand(prefix);
            assert command != null;
            command.setAliases(aliases);
        }

        this.aliases = (ArrayList<String>) aliases;
        this.prefix = prefix;
    }

    public void addSubCommand(CommandHandler subCommand) {
        subCommands.add(subCommand);
    }

    public List<CommandHandler> getSubCommands() {
        return subCommands;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return onTabComplete(sender, command, alias, args, null);
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args, String[] argsTrace) {
        ArrayList<String> possibilities = new ArrayList<>();


        if (args.length == 0) {
            if (getSubCommands() == null) {
                return null;
            }
            getSubCommands().forEach(subCommand -> possibilities.add(subCommand.getPrefix()));
            return possibilities;
        }

        for (CommandHandler cmd : getSubCommands()) {
            if (cmd.matches(args[0])) {
                return cmd.onTabComplete(sender, command, alias, truncateArgs(args), generateArgsTrace(args, argsTrace));
            }
        }


        return null;
    }

    private String[] generateArgsTrace(String[] args) {
        return generateArgsTrace(args, null);
    }

    private String[] generateArgsTrace(String[] args, String[] argsTrace) {
        ArrayList<String> trace = new ArrayList<>();
        trace.add(args[0]);
        if (argsTrace != null)
            Collections.addAll(trace, argsTrace);
        return trace.toArray(new String[0]);
    }

    public String[] truncateArgs(String[] args) {
        ArrayList<String> arg = new ArrayList<>();
        Collections.addAll(arg, args);
        arg.remove(args[0]);
        return arg.toArray(new String[0]);
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean matches(String alias) {
        return aliases.contains(alias);
    }
}
