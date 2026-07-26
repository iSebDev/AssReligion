package org.asyn.asRelegion.commands;

import org.asyn.asRelegion.Main;
import org.asyn.asRelegion.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminMain implements CommandExecutor {

    private final Main plugin;

    public AdminMain(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.getColoredMessage("&cOnly players can use this command."));
            return true;
        }

        Player player = (Player) sender;

        if (!(player.isOp() || player.hasPermission("assreligion.admin"))) return false;

        if (args.length == 0) {
            sendGeneralHelp(player);
            return true;
        }

        String rama = args[0].toLowerCase();

        switch (rama) {
            case "religion":
                subcommandReligion(player, args);
                break;
            case "players":
                subcommandPlayer(player, args);
                break;
            case "reload":
                plugin.reloadConfig();
                break;
            default:
                player.sendMessage(Messages.getColoredMessage("&cSubcommand not found. Use /religionadmin for help."));
                break;
        }

        return true;
    }

    public void subcommandPlayer(Player player, String[] args) {
        String rama = args[1].toLowerCase();

        switch (rama) {
            case "data":
                break;
            default:
                subCommandPlayerHelp(player);
                break;
        }
    }

    public void subcommandReligion(Player player, String[] args) {
        String rama = args[1].toLowerCase();

        switch (rama) {
            case "data":
                break;
            default:
                subCommandReligionHelp(player);
                break;
        }
    }

    public void sendGeneralHelp(Player player) {
        player.sendMessage(Messages.getColoredMessage("&6====== &eReligión Admin Help Commands &6======"));
        player.sendMessage(Messages.getColoredMessage("&a/religionadmin religion - Manage religions"));
        player.sendMessage(Messages.getColoredMessage("&a/religionadmin player - Manage player"));
    }

    public void subCommandPlayerHelp(Player player) {
        player.sendMessage(Messages.getColoredMessage("&6====== &eReligión Admin Help Commands &6======"));
        player.sendMessage(Messages.getColoredMessage("&a/religionadmin player data - Get player data"));
    }

    public void subCommandReligionHelp(Player player) {
        player.sendMessage(Messages.getColoredMessage("&6====== &eReligión Admin Help Commands &6======"));
        player.sendMessage(Messages.getColoredMessage("&a/religionadmin religion data - Get religion data"));
    }
}
