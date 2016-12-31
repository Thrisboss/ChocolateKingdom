package me.alexandreh.fr.listeners;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import me.alexandreh.fr.chat.Prefix;
import me.alexandreh.fr.crafting.CanCraft;
import me.alexandreh.fr.utils.Teams;
import net.minecraft.server.v1_11_R1.CraftingManager;

public class ItemRecipe implements Listener {

	
	public static int extractInt(String str) {
		Matcher matcher = Pattern.compile("\\d+").matcher(str);

        if (!matcher.find())
            throw new NumberFormatException("For input string [" + str + "]");

        return Integer.parseInt(matcher.group());
      }
     
	
	@EventHandler
	public void CraftChocolat(CraftItemEvent e){
		// Si joueur
		if(e.getWhoClicked() instanceof Player){
		//Prend le materiel
		Material itemType = e.getRecipe().getResult().getType();
		// Prend le displayName
		String itemDisplayName = e.getRecipe().getResult().getItemMeta().getDisplayName();
		
		// Nomme le joueur
		Player p = (Player) e.getWhoClicked();	
		// La phase de la team
		Integer phase = Teams.team_phase.get(Teams.getPlayerTeam(p));
		Integer points = Teams.team_point.get(Teams.getPlayerTeam(p));
		
		// Si il ne peux pas craft (pas la meme phase, 1)et si l'item type est cocoa et si le displayname est #1 
		// On a PHASE DES TEAMS
		// Une team a le droit de craft un item du meme niveau donc phase = 1 et item = 1
		// Si phase = 2 et item = 1 non
		
		
		if(itemType == Material.INK_SACK){
			int id = extractInt(itemDisplayName);
			
		if(Teams.getPlayerTeam(p) == null){
			e.getInventory().setResult(new ItemStack(Material.AIR));
			p.sendMessage(Prefix.prefix + ChatColor.RED + "Erreur - 1, vous n'êtes pas dans une équipe, merci de vous reconnecter.");
		}
		else if(CanCraft.canCraft(p, id) == false && itemDisplayName.equalsIgnoreCase("Chocolat" + " #" + id)){
		
			e.getInventory().setResult(new ItemStack(Material.AIR));
			p.sendMessage(id + " " + Teams.team_phase.get(Teams.getPlayerTeam(p)));
			if(id < Teams.team_phase.get(Teams.getPlayerTeam(p))){
			p.sendMessage(Prefix.prefix + "Votre team a déjà craft ce chocolat!");
			}else if(id > Teams.team_phase.get(Teams.getPlayerTeam(p))){
				p.sendMessage(Prefix.prefix + "Votre team n'a pas encore le niveau pour craft ce chocolat");
			}
				
		}
		else if(CanCraft.canCraft(p, id) == true & itemType == Material.INK_SACK && itemDisplayName.equalsIgnoreCase("Chocolat" + " #" + id)){
			p.sendMessage(Prefix.prefix + "Votre team a crafter un chocolat!");
			Teams.team_point.replace(Teams.getPlayerTeam(p), points + 1);
			Teams.team_phase.replace(Teams.getPlayerTeam(p), phase + 1 );
		
		
		}
		}
		}
		}
	}


