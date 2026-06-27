package org.asyn.asRelegion.utils;

import org.bukkit.ChatColor;
import static org.asyn.asRelegion.Main.prefix;

public class Messages {



    public static String asciiart = """
                           _____      _ _       _            \s
                 /\\       |  __ \\    | (_)     (_)           \s
                /  \\   ___| |__) |___| |_  __ _ _  ___  _ __ \s
               / /\\ \\ / __|  _  // _ \\ | |/ _` | |/ _ \\| '_ \\\s
              / ____ \\\\__ \\ | \\ \\  __/ | | (_| | | (_) | | | |
             /_/    \\_\\___/_|  \\_\\___|_|_|\\__, |_|\\___/|_| |_|
                                           __/ |             \s
                                          |___/              \s
            """;

    public static String getColoredMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String ConsoleMessage() {
        return Messages.getColoredMessage(prefix+ " &cOnly players can use this command.");
    }

}
