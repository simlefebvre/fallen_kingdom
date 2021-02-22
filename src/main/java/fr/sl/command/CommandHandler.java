package fr.sl.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandHandler implements CommandExecutor, TabCompleter {

    private final String prefix;
    private final ArrayList<String> aliases = new ArrayList<>();
    private final ArrayList<CommandHandler> subCommands = new ArrayList<>();
    private final CompletionProvider[] providers;
    private final CommandFunction function;

    public CommandHandler(String prefix, List<String> aliases, CompletionProvider[] providers, JavaPlugin plugin) {
        this(prefix, aliases, providers, plugin, null);
    }

    public CommandHandler(String prefix, List<String> aliases, CompletionProvider[] providers, JavaPlugin plugin, CommandFunction function) {
        if (plugin != null && aliases != null) {
            Command command = plugin.getCommand(prefix);
            assert command != null;
            command.setAliases(aliases);
        }

        if (aliases != null)
            this.aliases.addAll(aliases);
        this.aliases.add(prefix);
        this.prefix = prefix;
        this.providers = providers;
        this.function = function;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return onTabComplete(sender, command, alias, args, null);
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args, String[] argsTrace) {
        ArrayList<String> possibilities = new ArrayList<>();

        if (getSubCommands().size() != 0) {
            if (args.length == 1) {
                getSubCommands().forEach(subCommand -> possibilities.add(subCommand.getPrefix()));
                return possibilities;
            }

            for (CommandHandler cmd : getSubCommands()) {
                if (cmd.matches(args[0])) {
                    return cmd.onTabComplete(sender, command, alias, truncateArgs(args), generateArgsTrace(args, argsTrace));
                }
            }
        }

        if (providers != null && args.length < providers.length) {
            return providers[args.length].getPossibilities();
        }

        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return onCommand(sender, command, label, args, null);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args, String[] argsTrace) {
        for (CommandHandler cmd : getSubCommands()) {
            if (cmd.matches(args[0])) {
                return cmd.onCommand(sender, command, label, truncateArgs(args), generateArgsTrace(args, argsTrace));
            }
        }
        if (function != null) {
            return function.execute(sender, command, label, args, argsTrace, this);
        }
        return false;
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

    public boolean matches(String alias) {
        return aliases.contains(alias);
    }

    public void addSubCommand(CommandHandler subCommand) {
        subCommands.add(subCommand);
    }

    public CompletionProvider[] getProviders() {
        return providers;
    }

    public List<CommandHandler> getSubCommands() {
        return subCommands;
    }

    public String getPrefix() {
        return prefix;
    }

}
