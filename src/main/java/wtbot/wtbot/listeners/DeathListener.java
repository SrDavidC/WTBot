package wtbot.wtbot.listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.inventory.ItemStack;
import wtbot.wtbot.WTBot;
import wtbot.wtbot.discord.DiscordManager;
import wtbot.wtbot.files.WTFiles;
import wtbot.wtbot.utils.PlayerUtils;

import java.util.Random;

public class DeathListener implements Listener {
    PlayerUtils playerUtils = PlayerUtils.getInstance();
    @EventHandler
    public void playerDeath(EntityDeathEvent e){
        if (!(e.getEntity() instanceof Player))
            return;

        if (!WTBot.getPl().isDetectDeath())
            return;
        Player playerMuerto = (Player) e.getEntity();
        String name = playerMuerto.getName().toUpperCase();

        int x = (int)playerMuerto.getLocation().getX();
        int y = (int)playerMuerto.getLocation().getY();
        int z = (int)playerMuerto.getLocation().getZ();
        String coordenadas = "Coordenadas: " + x + " " + y + " "+ z + " "+  playerMuerto.getWorld().getName();
        String razon = e.getEntity().getLastDamageCause().getCause().name();
        DiscordManager.getInstance().deathAnnounce(name,razon,coordenadas,false,0);

        setPlayerHead(playerMuerto.getLocation(), Bukkit.getOfflinePlayer(playerMuerto.getUniqueId()));

        playerUtils.jugadores.get(name).setStorageI(saveInventory(playerMuerto,true));
        playerUtils.jugadores.get(name).setArmorI(saveInventory(playerMuerto,false));
        playerUtils.jugadores.get(name).setLocation(saveLocation(playerMuerto));
        if (playerMuerto.getInventory().getItemInOffHand() != null){playerUtils.jugadores.get(name).setOffhand((playerMuerto.getInventory().getItemInOffHand()));}

        int index = WTFiles.searchPlayer(name);
        WTFiles.chngState(name,"DEAD",index);

    }
    public void setPlayerHead(Location l, OfflinePlayer p){
        l.getBlock().setType(getRandomFence());
        Block head = l.getBlock().getRelative(BlockFace.UP);
        head.setType(Material.PLAYER_HEAD);

        if (head.getState() instanceof Skull){
            Skull skull = (Skull) head.getState();
            skull.setOwningPlayer(p);
            skull.update();
        }
    }

    @EventHandler
    public void onTotem(EntityResurrectEvent e){
        if (!(e.getEntity() instanceof Player))
            return;
        if ( isTotem((Player) e.getEntity()) ) {
            Player p = (Player) e.getEntity();
            int x = (int)p.getLocation().getX();
            int y = (int)p.getLocation().getY();
            int z = (int)p.getLocation().getZ();
            String name = p.getName();
            String coordenadas = x + " " + y + " " + z + " " + p.getWorld().getName();
            int cantTotem = p.getStatistic(Statistic.USE_ITEM,Material.TOTEM_OF_UNDYING)+1;

            String cause = p.getLastDamageCause().getCause().toString();
            DiscordManager.getInstance().deathAnnounce(name,cause,coordenadas,true,cantTotem);
        }
    }

    public boolean isTotem(Player player){
        return player.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING ||
                player.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING;
    }


    private Material getRandomFence() {
        return fences[new Random().nextInt(fences.length)];
    }

    Material[] fences = new Material[]{Material.CRIMSON_FENCE, Material.WARPED_FENCE, Material.NETHER_BRICK_FENCE};

    public ItemStack[] saveInventory(Player p, Boolean inv) {
        ItemStack[] inventario;
        if (inv) {inventario =  p.getInventory().getStorageContents();}

        else{inventario =  p.getInventory().getArmorContents(); }
        return inventario;
    }

    public Location saveLocation(Player p) {
        if (p != null)
            return p.getLocation();
        return new Location(p.getWorld(), 0, 80, 0);
    }

}
