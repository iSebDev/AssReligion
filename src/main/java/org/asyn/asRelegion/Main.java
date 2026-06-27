package org.asyn.asRelegion;

import org.asyn.asRelegion.commands.ReligionMain;
import org.asyn.asRelegion.listeners.PlayerJoin;
import org.asyn.asRelegion.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import static org.asyn.asRelegion.utils.Messages.asciiart;

public final class Main extends JavaPlugin {

    public static String prefix = "&bAsReligion &7>>";
    public static String ingameprefix = "&e[Religion] &7>> ";

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getConsoleSender().sendMessage(asciiart);

        Bukkit.getConsoleSender().sendMessage(Messages.getColoredMessage(prefix + " &eAssReligion Enabled!"));
    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+" &cdisabled"));
    }

    public void registerCommands(){
        this.getCommand("religion").setExecutor(new ReligionMain(this));
    }

    public void registerListeners(){
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }
}
