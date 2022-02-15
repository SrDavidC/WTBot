package wtbot.wtbot.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Syntax;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import wtbot.wtbot.utils.PlayerData;
import wtbot.wtbot.utils.PlayerUtils;
import wtbot.wtbot.utils.Utils;

import java.util.Locale;

@CommandAlias("respawn")
public class Respawn extends BaseCommand {

    PlayerUtils playerUtils = PlayerUtils.getInstance();
    @Default
    @Syntax("Player i")
    public void onSend(CommandSender sender, Player player, String inventory){
        if (!sender.hasPermission("withering.respawn")){
            sender.sendMessage(Utils.prefix + Utils.noPerms);
            return;
        }

        String name = player.getName().toUpperCase(Locale.ROOT);
        PlayerData playerData = playerUtils.jugadores.get(name);
        if (playerData == null){
            sender.sendMessage(Utils.prefix + ChatColor.AQUA + "El jugador no existe");
            return;
        }
        if (playerData.getArmorI() == null && playerData.getStorageI() == null){
            sender.sendMessage(Utils.prefix + ChatColor.AQUA + "El jugador no tiene un inventario registrado");
            return;
        }
        ItemStack[] armor = playerData.getArmorI();
        ItemStack[] content = playerData.getStorageI();

        if (playerData.getStorageI() != null)
            player.getInventory().setContents(content);

        if (playerData.getArmorI() != null)
            player.getInventory().setArmorContents(armor);

        if (playerData.getOffhand() != null)
            player.getInventory().setItemInOffHand(playerData.getOffhand());

        player.updateInventory();
    }
}
