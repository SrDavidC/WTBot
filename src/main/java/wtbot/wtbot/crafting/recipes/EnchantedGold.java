package wtbot.wtbot.crafting.recipes;

import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import wtbot.wtbot.crafting.CustomRecipe;

public class EnchantedGold extends CustomRecipe {
    public EnchantedGold(NamespacedKey namespacedKey){
        super(namespacedKey);
        final ItemStack enchantedGold = new ItemBuilder(Material.GOLD_INGOT).name(ChatColor.LIGHT_PURPLE + "Enchanted Gold Ingot").enchant(Enchantment.VANISHING_CURSE).build();


        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, enchantedGold);
        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A',Material.GOLD_INGOT);
        recipe.setIngredient('B',Material.EMERALD);

        setRecipe(recipe);
    }

}
