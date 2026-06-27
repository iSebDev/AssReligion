package org.asyn.asRelegion.commands;

import org.asyn.asRelegion.Main;
import org.asyn.asRelegion.utils.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReligionMain implements CommandExecutor {

    private final Main plugin;

    public ReligionMain(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Messages.getColoredMessage("&cOnly players can use this command."));
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sendGeneralHelp(player);
            return true;
        }

        String rama = args[0].toLowerCase();

        switch (rama) {
            case "zone","z","zones":

                break;
            case "reload":
                plugin.reloadConfig();
                break;
            default:
                player.sendMessage(Messages.getColoredMessage("&cSubcommand not found. Use /religion for help."));
                break;
        }

        return true;
    }

    public void sendGeneralHelp(Player player) {
        player.sendMessage(Messages.getColoredMessage("&6====== &eReligión Help &6======"));
        player.sendMessage(Messages.getColoredMessage("&a/religion <subcommand> &7- Gestion of zones"));
    }

}
