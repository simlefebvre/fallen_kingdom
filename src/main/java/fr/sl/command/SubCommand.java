package fr.sl.command;

import org.bukkit.command.TabCompleter;

public abstract class SubCommand implements TabCompleter {
    private final String prefix;

    public SubCommand(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
