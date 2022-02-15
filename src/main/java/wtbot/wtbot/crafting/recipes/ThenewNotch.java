package wtbot.wtbot.crafting.recipes;

import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.SkullMeta;
import wtbot.wtbot.crafting.CustomRecipe;

import java.util.UUID;


public class ThenewNotch extends CustomRecipe {
    public ThenewNotch(NamespacedKey namespacedKey){
        super(namespacedKey);

        ItemStack notch = new ItemStack(Material.PLAYER_HEAD,1);
        SkullMeta meta = (SkullMeta) notch.getItemMeta();

        meta.setCustomModelData(428);
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("3c893d05-3535-342f-809e-8937a8d4602d")));
        meta.setUnbreakable(true);
        meta.setUnbreakable(true);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "OVERPOWERED PLAYER HEAD");

        notch.setItemMeta(meta);
        notch.addUnsafeEnchantment(Enchantment.DURABILITY,10);

        final ItemStack goldBlock = new ItemBuilder(Material.GOLD_BLOCK).name(ChatColor.LIGHT_PURPLE + "Enchanted Golden Block").enchant(Enchantment.VANISHING_CURSE).build();
        RecipeChoice goldBlockR = new RecipeChoice.ExactChoice(goldBlock);
        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, notch);

        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A', goldBlockR);
        recipe.setIngredient('B',Material.PLAYER_HEAD);

        setRecipe(recipe);
    }

}
