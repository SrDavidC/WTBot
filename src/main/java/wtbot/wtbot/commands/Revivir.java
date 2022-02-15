package wtbot.wtbot.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import wtbot.wtbot.utils.Utils;

@CommandAlias("revivir")
public class Revivir extends BaseCommand {
    @Default
    @Syntax("<Player> <QuitarTormenta>")
    public void revivir(Player sender, Player revivido){
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "function pd:help/no_storm");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "tag " + revivido.getName() + " add revivir");
        sender.sendMessage(Utils.prefix + ChatColor.DARK_GRAY + " Jugador: " + revivido.getName() + " ha sido revivido. La tormenta ha sido removida");
    }

}
