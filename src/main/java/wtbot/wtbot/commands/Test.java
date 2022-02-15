package wtbot.wtbot.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;

import co.aikar.commands.annotation.Syntax;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


@CommandAlias("test")
public class Test extends BaseCommand {

    @Default
    @Syntax("si")
    public void onTest(Player sender) {
       //sender.sendMessage(ChatColor.RED + " ASD " +  sender.getUniqueId());
    }

}
