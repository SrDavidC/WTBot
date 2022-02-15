package wtbot.wtbot.crafting.recipes;

import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import wtbot.wtbot.crafting.CustomRecipe;

public class EnchantedGoldBlock extends CustomRecipe {
    public EnchantedGoldBlock(NamespacedKey namespacedKey){
        super(namespacedKey);

        final ItemStack goldBlock = new ItemBuilder(Material.GOLD_BLOCK).name(ChatColor.LIGHT_PURPLE + "Enchanted Golden Block").enchant(Enchantment.VANISHING_CURSE).build();
        final ItemStack enchantedGold = new ItemBuilder(Material.GOLD_INGOT).name(ChatColor.LIGHT_PURPLE + "Enchanted Gold Ingot").enchant(Enchantment.VANISHING_CURSE).build();
        final ItemStack enchantedEmerald = new ItemBuilder(Material.EMERALD).name(ChatColor.LIGHT_PURPLE + "Enchanted Emerald").enchant(Enchantment.VANISHING_CURSE).build();
        RecipeChoice eGold = new RecipeChoice.ExactChoice(enchantedGold);
        RecipeChoice eEmerald = new RecipeChoice.ExactChoice(enchantedEmerald);

        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, goldBlock);
        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('A', eGold);
        recipe.setIngredient('B',eEmerald);

        setRecipe(recipe);
    }
}
