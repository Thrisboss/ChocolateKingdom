package me.alexandreh.fr.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import me.alexandreh.fr.chat.Prefix;

public class Teams {
	
	
	
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
    public static Scoreboard board = manager.getNewScoreboard();
	
	
    //	public static Team blue = board.registerNewTeam("Blue");
    //	public static Team red = board.registerNewTeam("Red");
	
	//	public static int blue_size = blue.getSize();
	//public static int red_size = red.getSize();
	
	public static int solo_duo = 1;
	private int teamID;
	private ChatColor color;
	
	public static HashMap<Team, Integer> team_phase = new HashMap<Team, Integer>();
	public static HashMap<Team, Integer> team_point = new HashMap<Team, Integer>();
	//All Players Joined with no team
	public static List<Player> players = new ArrayList<Player>();
	// ALl players in team
	public static List<Player> players_in = new ArrayList<Player>();
	// All Teams
	public static List<Team> teams = new ArrayList<Team>();
	// All Players in which teams
	public static HashMap<Player, Team> players_team = new HashMap<Player, Team>();
	
  
    

    public static Team getPlayerTeam(Player p) {
    	
    	return players_team.get(p);
    	
    }

    public ChatColor getChatColor(){
    	
    	return color;
    	
    }
    
    public void addPlayersRandom() {

        int timesDone = 0;

        for (Team team : teams) {

            if (players.size() != 0) {

                for (int times = 0; times < solo_duo; times++) {

                    if (players.size() != 0) {
                    	
                        timesDone++;
                        // SI il manque joueurs dans team
                        if(timesDone != solo_duo) {
                        	//Random dans tout les players size
                            int random = new Random().nextInt(players.size());
                            // Si random = 1 alors Player p = players.get
                            Player name = players.get(random);
                            team.addPlayer(name);
                            players.remove(name);
                            players_in.add(name);
                            Bukkit.broadcastMessage("§b" + timesDone + "§8/§b" + players.size() + " §ahave been added to a team!");
                            timesDone++;
                        }
                        else {
                            timesDone = 0;

                        }

                    } else {
                        break;

                    }


                }
            }
            else {
                break;
            }
        
        }
    }
    
    public void addColorsRandom() {

        for (Team team : teams) {

            int count = 0;
            int offset = 16;
            ChatColor format = null;

            for (Player name : players_in) {

                Player members = name;

                ChatColor[] colors = ChatColor.values();

                ChatColor color = colors[count];

                if (format != null) {
                    members.setPlayerListName(format + members.getName());
                }

                members.setPlayerListName(color + members.getPlayerListName());

                count++;
                if (count == 16) {
                    count = 0;
                    format = colors[offset];
                    offset++;
                    if (offset == 21) {
                        format = null;
                        offset = 16;
                    }
                }
            }
        }
    }
	//static String blue_name = "blue";
	//static String red_name = "red";
	
	//@SuppressWarnings("deprecation")
	//public static void TeamSetup(){
		
	//	blue.setAllowFriendlyFire(false);
		//	red.setAllowFriendlyFire(false);
		
	//	team_phase.put(blue_name, 1);
	//	team_phase.put(red_name, 1);
		//
	//	team_point.put(blue_name, 0);
	//	team_point.put(red_name, 0);
		//	
	//	blue.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
	//	red.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
		
	//	blue.setPrefix("[" + ChatColor.BLUE + "Bleu" + ChatColor.RESET + "]");
		//	red.setPrefix("[" + ChatColor.RED + "Rouge" + ChatColor.RESET + "]");
		
	//}
	public static String getGameMode(){
		if(solo_duo == 1){
			return "solo";
		}
		else if(solo_duo == 2){
			return "duo";
		}
		return null;
	}
	public static int teamAmount(){
		if(getGameMode() == "solo"){
			return players.size();
		}
		if(getGameMode() == "duo"){
			
			if(Teams.players.size()%2 == 0){
				return players.size() / 2;
			}else{
				return players.size() / 2 + 1;
			}
			
		}
		return 0;
	}
	
	//@SuppressWarnings("deprecation")
	//public static void AddPlayer(Player p){
	//if(getPlayer(p) != "blue" && getPlayer(p) != "red"){	
	//	if(blue.getSize() == 0){
			//		blue.addPlayer(p);
	//	setup(p);
			//}else if(red.getSize() == 0){
	//	red.addPlayer(p);
	//	setup(p);
	//	}else{
	//	if(blue.getSize() < red.getSize()){
				//		red.addPlayer(p);
				//		setup(p);
				//}else if(red.getSize() < blue.getSize()){
				//		blue.addPlayer(p);
				//		setup(p);
				//	}else if(blue.getSize() <= red.getSize()){
				//		Random r = new Random();
				//		int team_number = r.nextInt(2);
				//	if(team_number == 1){
					//			blue.addPlayer(p);
				//		setup(p);
					//	}else{
				//		red.addPlayer(p);
				//setup(p);
					//	}
				
				
	//	}
	//	}
	//}
		
	//}
	
	//@SuppressWarnings("deprecation")
	//public static String getPlayer(Player p){
		
	//	if(blue.getPlayers().contains(p)){
			//		return blue_name;
	//	}else if(red.getPlayers().contains(p)){
	//		return red_name;
			//	}
	//return null;
		//	
		//}
	
	//public static void setup(Player p){
		
	//	String team = getPlayer(p);
	//	ChatColor color = ChatColor.GRAY;
		
	//	if(team == "blue"){
	//	color = ChatColor.BLUE;
	//	}else if(team == "red"){
	//	color = ChatColor.RED;
	//}
		
		
		
	//	p.sendMessage(Prefix.prefix + ChatColor.GRAY + "Vous avez rejoint l'équipe " + color + team + ChatColor.RESET + ".");
	//	p.setPlayerListName(color + p.getDisplayName());
		
		
	
	//	}
	
	//@SuppressWarnings("deprecation")
	//public static void removePlayer(Player p){
	//	if(getPlayer(p) != null){
			
		
	//	if(getPlayer(p) == "blue"){
	//	blue.removePlayer(p);
			//	}else if(getPlayer(p) == "red"){
	//	red.removePlayer(p);
	//	}
	//	p.setPlayerListName(p.getDisplayName());
		//	
	//	}
	//}
	
	
	
}
