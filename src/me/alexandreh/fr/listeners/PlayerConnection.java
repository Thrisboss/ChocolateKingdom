package me.alexandreh.fr.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.alexandreh.fr.chat.Prefix;
import me.alexandreh.fr.utils.Locations;
import me.alexandreh.fr.utils.State;
import me.alexandreh.fr.utils.Teams;


public class PlayerConnection implements Listener {


	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e){
		
		
		Player p = e.getPlayer(); 
		
		if(State.isState(State.WAITING)){
			p.getInventory().clear();
			p.setGameMode(GameMode.ADVENTURE);
			p.teleport(Locations.lobby);
		
		}
		
		e.setJoinMessage(Prefix.prefix + ChatColor.GREEN + p.getName() +ChatColor.GRAY + " a rejoint la partie");
		

		
		
		
		
	}
	
	
}
