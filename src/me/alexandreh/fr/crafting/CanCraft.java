package me.alexandreh.fr.crafting;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import me.alexandreh.fr.utils.Teams;

public class CanCraft {
	
	
	public static boolean canCraft(Player p, Integer phase){
		
		Team team = Teams.getPlayerTeam(p);
		
		Integer phase_team = Teams.team_phase.get(team);
		
		if(phase == phase_team){
			return true;
			
		}else{
			return false;
		}
		
		
	}
	
	

}
