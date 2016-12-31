package me.alexandreh.fr.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class TeamManager {

	public List<Team> getTeams() {
		
		return Teams.teams;
	}
	
	public void createTeamsRandom(int amount) {
        for (int times = 1; times <= amount; times++) {
            Team team = Teams.board.registerNewTeam(times + Teams.teams.size() + "");
            Teams.teams.add(team);
        }
        Bukkit.broadcastMessage("Debug " + Teams.teams.size() + " team created");
 
    }

}
