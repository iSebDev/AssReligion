package org.asyn.asRelegion;

import io.lumine.mythic.lib.api.player.MMOPlayerData;
import io.lumine.mythic.lib.api.stat.StatInstance;
import io.lumine.mythic.lib.api.stat.StatMap;
import net.Indyuce.mmocore.api.player.PlayerData;
import org.asyn.asRelegion.commands.AdminMain;
import org.asyn.asRelegion.commands.PlayerMain;
import org.asyn.asRelegion.listeners.PlayerJoin;
import org.asyn.asRelegion.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

import static org.asyn.asRelegion.utils.Messages.asciiart;

public final class Main extends JavaPlugin {

    public static String prefix = "&bAsReligion &7>>";
    public static String ingameprefix = "&e[Religion] &7>> ";

    Player player = Bukkit.getPlayer(Bukkit.getName());

    // MMOCore (https://docs.phoenixdevt.fr/mmocore/api/api)
    PlayerData datammo = PlayerData.get(player);
    int plevel = datammo.getLevel();

    // MythicLib (https://docs.phoenixdevt.fr/mythiclib/api/stats)

    MMOPlayerData mythdata = MMOPlayerData.get(player);
    StatMap statMap = mythdata.getStatMap();
    StatInstance magicDamageStat = statMap.getInstance("MAGIC_DAMAGE" ); // Dentro del parentesis puedes poner cualquier stat existente.

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getConsoleSender().sendMessage(asciiart);

        Bukkit.getConsoleSender().sendMessage(Messages.getColoredMessage(prefix + " &eAssReligion Enabled!"));
    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " &cdisabled"));
    }

    public void registerCommands() {
        this.getCommand("religionadmin").setExecutor(new AdminMain(this));
        this.getCommand("religion").setExecutor(new PlayerMain(this));
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }
}
