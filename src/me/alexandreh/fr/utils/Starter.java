package me.alexandreh.fr.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import me.alexandreh.fr.Main;
import me.alexandreh.fr.chat.Prefix;

public class Starter {
	
	
	@SuppressWarnings("deprecation")
	public static void StartGame(){
		
		State.setState(State.PREGAME);
		
		Bukkit.broadcastMessage(Prefix.prefix + ChatColor.GRAY + "Début de la partie");
		Bukkit.getWorld("world").setTime(0);		
		
		Main.getClassName().Countdown();
		Main.getClassName().Days();
		
		
		
		for(Player p : Bukkit.getOnlinePlayers()){
			new me.alexandreh.fr.scoreboard.CustomScoreboardManager(p);
			me.alexandreh.fr.scoreboard.ScoreboardRunnable.sendLine();
			p.setScoreboard(me.alexandreh.fr.scoreboard.CustomScoreboardManager.getScoreboard(p).getMainScoreboard());
			
		
		}
		
		
		
	}
	
	
	
	
	
	

}
