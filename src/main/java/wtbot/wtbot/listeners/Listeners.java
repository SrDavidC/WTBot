package wtbot.wtbot.listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class Listeners implements Listener {

    @EventHandler
    public void onPlayerJoins(PlayerJoinEvent e){
        String blackB = ChatColor.BLACK + "" + ChatColor.BOLD;
        Player p = e.getPlayer();
        p.playSound(p.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH,SoundCategory.AMBIENT ,8,0.7F);
        p.sendTitle(blackB + "WITHERING SOULS", blackB + "Welcome " + ChatColor.DARK_RED + ChatColor.BOLD +  p.getName(),10,40,50 );
    }

    @EventHandler
    public void onPigmanSpawn(EntitySpawnEvent e){
        if (!(e.getEntity() instanceof PigZombie))
            return;
        PigZombie pz = (PigZombie) e.getEntity();
        pz.setAngry(true);
    }
    @EventHandler
    public void onEntitySpawn(EntityDeathEvent e){
        if (e.getEntity() instanceof Phantom){
            World w = e.getEntity().getWorld();
            final TNTPrimed tnt = (TNTPrimed) w.spawnEntity(e.getEntity().getLocation(), EntityType.PRIMED_TNT);
            tnt.setIsIncendiary(false);
            tnt.setCustomName("TNT PHANTOM");
        }
    }
    @EventHandler
    public void onTNTEntityExplodes(EntityExplodeEvent e){
        if (e.getEntity().getName().equalsIgnoreCase("TNT PHANTOM")){
            e.setCancelled(true);
            World  w = e.getEntity().getWorld();
            w.createExplosion(e.getEntity().getLocation(),6,false,false);
        }
    }
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR))
            return;

        ArrayList<Material> items = new ArrayList<>();
        items.add(Material.PLAYER_HEAD);
        ItemStack item = e.getItem();

        if (item != null) {
            if (!(items.contains(item.getType())))
                return;
            Player p = e.getPlayer();
            if (item.hasItemMeta()) {
                if (item.getItemMeta().hasCustomModelData()) {
                    if (item.getItemMeta().getCustomModelData() == 428) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 4));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 6000, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 400, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1800, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1800, 1));
                        p.playSound(p.getLocation(),Sound.ENTITY_GENERIC_EAT,100,0.5f);
                        if (e.getItem().getAmount() > 1)
                            e.getItem().setAmount(item.getAmount()-1);
                        else
                            e.getItem().setAmount(0);
                    }
                }
            }
        }
    }
}
