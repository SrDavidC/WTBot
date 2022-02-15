package wtbot.wtbot.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;

import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import wtbot.wtbot.WTBot;

import wtbot.wtbot.utils.Utils;

@CommandAlias("detectDeath")
public class DetectDeaths extends BaseCommand {

    WTBot pl = WTBot.getPl();
    @Default
    @Syntax("boolean")
    @CommandCompletion("@bool")
    public void onDeathAnnOff(Player sender, Boolean bool) {
        if (!sender.hasPermission("withering.respawn")) {
            Bukkit.broadcastMessage(Utils.prefix + Utils.noPerms);
            return;
        }
        if (!bool) {
            pl.setDetectDeath(false);
            sender.sendMessage(Utils.prefix + ChatColor.DARK_GRAY + "Deteccion de muertes en Discord desactivado");
        }
        else {
            pl.setDetectDeath(true);
            sender.sendMessage(Utils.prefix + ChatColor.DARK_GRAY + "Deteccion de muertes en Discord activado");
        }
    }

}
