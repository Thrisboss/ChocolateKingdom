package me.alexandreh.fr.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.alexandreh.fr.chat.Prefix;
import me.alexandreh.fr.scoreboard.CustomScoreboardManager;
import me.alexandreh.fr.utils.Teams;

public class PlayerLeave implements Listener{
		
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e){
		
		Player p = e.getPlayer(); 
		
		e.setQuitMessage(Prefix.prefix + ChatColor.GREEN + p.getName() +ChatColor.GRAY + " a quitté la partie");
		
		Teams.players.remove(p);
		Teams.players_in.remove(p);
		Teams.players_team.remove(p);
		
		CustomScoreboardManager.sb.remove(p);
	
	}
	
	@EventHandler
	public void PlayerKick(PlayerKickEvent e){
		
		Player p = e.getPlayer();
		
		e.setLeaveMessage(Prefix.prefix + ChatColor.GREEN + p.getName() +ChatColor.GRAY + " a quitté la partie");
		
		Teams.players.remove(p);
		Teams.players_in.remove(p);
		Teams.players_team.remove(p);
		
		CustomScoreboardManager.sb.remove(p);
		
	}
	
	
	
	
}
