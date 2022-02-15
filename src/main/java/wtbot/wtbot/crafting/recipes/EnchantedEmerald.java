package wtbot.wtbot.crafting.recipes;

import fr.mrmicky.fastinv.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import wtbot.wtbot.crafting.CustomRecipe;

public class EnchantedEmerald extends CustomRecipe {
    public final ItemStack enchantedEmerald = new ItemBuilder(Material.EMERALD).name(ChatColor.LIGHT_PURPLE + "Enchanted Emerald").enchant(Enchantment.VANISHING_CURSE).build();

    public EnchantedEmerald(NamespacedKey namespacedKey){
        super(namespacedKey);

        final ShapedRecipe recipe = new ShapedRecipe(namespacedKey, enchantedEmerald);
        recipe.shape("AAA","ABA","AAA");
        recipe.setIngredient('B',Material.GOLD_INGOT);
        recipe.setIngredient('A',Material.EMERALD);

        setRecipe(recipe);
    }

    public ItemStack getEnchantedEmerald() {
        return enchantedEmerald;
    }
}
