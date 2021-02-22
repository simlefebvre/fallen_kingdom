package fr.sl.utils;

import org.bukkit.command.CommandSender;

public class CommandUtils {

    private final static Localizer local = Localizer.getInstance();

    public static String getHelpMessage(String command) {
        return local.getLocalizedText(command.replaceAll(" ", "."));
    }

    public static boolean basicCommandTest(CommandSender sender, String command, String[] args, int minArgsNumber) {
        return basicCommandTest(sender, command, args, minArgsNumber, 2, true);
    }

    public static boolean basicCommandTest(CommandSender sender, String command, String[] args, int minArgsNumber, int helpLevel) {
        return basicCommandTest(sender, command, args, minArgsNumber, helpLevel, true);
    }

    public static boolean basicCommandTest(CommandSender sender, String command, String[] args, int minArgsNumber, int helpLevel, boolean strict) {
        if (args.length == helpLevel && args[helpLevel - 1].equals("help")) {
            sender.sendMessage(getHelpMessage(command));
        }
        if (strict) {
            if (args.length != minArgsNumber) {
                sender.sendMessage(String.format("Wrong command usage see /%s help for more information", command));
                return false;
            }
        } else {
            if (args.length < minArgsNumber) {
                sender.sendMessage(String.format("Wrong command usage see /%s help for more information", command));
                return false;
            }
        }
        return true;
    }
}
