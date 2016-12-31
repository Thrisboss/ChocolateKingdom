package me.alexandreh.fr.crafting;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.alexandreh.fr.utils.Teams;

public class Chocolate {


	public void Recipe(){
	
	@SuppressWarnings("deprecation")	
	ItemStack  chocolat = new ItemStack(351,1,(byte)3);
	ItemMeta metaChoco = chocolat.getItemMeta();
	metaChoco.addEnchant(Enchantment.DIG_SPEED, 1, false);
	metaChoco.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	
	metaChoco.setDisplayName("Chocolat" + " #1");
	chocolat.setItemMeta(metaChoco);
	
	//Phase 1
	ShapelessRecipe chocolatRecipe = new ShapelessRecipe(chocolat);
	chocolatRecipe.addIngredient(4, Material.DIRT);
	chocolatRecipe.addIngredient(4, Material.APPLE);
	chocolatRecipe.addIngredient(1, Material.WOOD_PICKAXE);
	
	
	
	Bukkit.getServer().addRecipe(chocolatRecipe);
	
	//Phase 2
	metaChoco.setDisplayName("Chocolat" + " #2");
	chocolat.setItemMeta(metaChoco);
	
	ShapelessRecipe chocolatRecipe1 = new ShapelessRecipe(chocolat);
	chocolatRecipe1.addIngredient(4, Material.DIAMOND);
	chocolatRecipe1.addIngredient(4, Material.APPLE);
	chocolatRecipe1.addIngredient(1, Material.DIAMOND_PICKAXE);
	
	Bukkit.getServer().addRecipe(chocolatRecipe1);

	
	}
	
	
	
}
