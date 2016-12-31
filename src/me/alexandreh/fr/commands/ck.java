package me.alexandreh.fr.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.alexandreh.fr.chat.Prefix;
import me.alexandreh.fr.crafting.CanCraft;
import me.alexandreh.fr.crafting.Chocolate;
import me.alexandreh.fr.scoreboard.CustomScoreboardManager;
import me.alexandreh.fr.utils.Locations;
import me.alexandreh.fr.utils.Starter;
import me.alexandreh.fr.utils.TeamManager;
import me.alexandreh.fr.utils.Teams;
import me.alexandreh.fr.utils.Time;

public class ck implements CommandExecutor {
	
	private final static TeamManager TeamManagerClass = new TeamManager();
	
	public static TeamManager getClassName(){
		return TeamManagerClass;
	}
	private final static Teams TeamsClass = new Teams();
	
	public static Teams getClassName2(){
		return TeamsClass;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("ck")){
			if(args.length == 1){
				String command_1 = args[0].toString();
				if(command_1.equalsIgnoreCase("help")){
					p.sendMessage(ChatColor.GRAY + "---------------------");
					p.sendMessage(ChatColor.GOLD + "   Chocolate Kingdom  ");
					p.sendMessage(ChatColor.GRAY + "");
					p.sendMessage(ChatColor.RED + "   Command List:     ");
					p.sendMessage(ChatColor.GREEN + "   </ck help> (to see the list of commands)");
					p.sendMessage(ChatColor.GREEN + "   </ck join> (to join the game)");
					p.sendMessage(ChatColor.GREEN + "   </ck leave> (to leave the game)");
					p.sendMessage(ChatColor.GREEN + "   </ck team> (to get the team you're on)");
					p.sendMessage(ChatColor.GREEN + "   </ck time> (to get the time of the game)");
					p.sendMessage(ChatColor.GREEN + "");
					if(p.isOp() || p.hasPermission("ck.admin")){
					p.sendMessage(ChatColor.RED +   "   </ck start> (to start the game)");
					p.sendMessage(ChatColor.RED +   "   </ck stop> (to stop the game)");
					p.sendMessage(ChatColor.RED +   "   </ck spawn lobby> (to set the lobby)");
					p.sendMessage(ChatColor.RED +   "   </ck team solo> (to set the gamemode to solo)");
					p.sendMessage(ChatColor.RED +   "   </ck team duo> (to set the gamemode to duo)");
					}
					p.sendMessage(ChatColor.GRAY + "---------------------");
				}
				if(command_1.equalsIgnoreCase("join")){
					
					Teams.players.add(p);
					
				}
				if(command_1.equalsIgnoreCase("leave")){
					
					Teams.players.remove(p);
				}
				if(command_1.equalsIgnoreCase("team")){
					p.sendMessage(Prefix.prefix + ChatColor.GRAY + "Vous êtes dans l'équipe " + ChatColor.GREEN + Teams.players_team.get(p));
					
				}
				if(command_1.equalsIgnoreCase("debug")){
				       Bukkit.broadcastMessage(Teams.board.getPlayerTeam(p) + "");
				}
				if(command_1.equalsIgnoreCase("time")){
					p.sendMessage(Prefix.prefix + ChatColor.GRAY + "Le temps est " + ChatColor.GREEN + Time.time + ChatColor.GRAY +  
							" secondes, " + ChatColor.GREEN + Time.days + ChatColor.GRAY + " jours" );
				}
				if(p.hasPermission("ck.admin") || p.isOp()){
					if(command_1.equalsIgnoreCase("start")){
						
						TeamManagerClass.createTeamsRandom(Teams.teamAmount());
						Starter.StartGame();
						TeamsClass.addPlayersRandom();
						TeamsClass.addColorsRandom();
						
					}
					if(command_1.equalsIgnoreCase("stop")){
						for(Player pall : Bukkit.getOnlinePlayers()){
							CustomScoreboardManager.sb.remove(pall);
							pall.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
						}
						
						Bukkit.getServer().reload();
						
					}
				}
				
			}
			// Ne fonctionne pas en dessous! //
			
			if(args.length == 2){
				String command_2 = args[1].toString();
				String command_1 = args[0].toString();
				if(p.hasPermission("ck.admin") || p.isOp()){
				
				if(command_2.equalsIgnoreCase("lobby") && command_1.equalsIgnoreCase("spawn")){
					Locations.lobby = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 2, p.getLocation().getZ());
					p.sendMessage(Prefix.prefix + ChatColor.GRAY + "Le " + ChatColor.GREEN + "spawn " + ChatColor.GRAY + "pour le lobby à été choisit");
					
				}
				if(command_2.equalsIgnoreCase("solo") && command_1.equalsIgnoreCase("team")){
					Teams.solo_duo = 1;
					p.sendMessage(Prefix.prefix + ChatColor.GRAY + "GameMode set to " + ChatColor.GREEN + "solo");
				}
				if(command_2.equalsIgnoreCase("duo") && command_1.equalsIgnoreCase("team")){
					Teams.solo_duo = 2;
					p.sendMessage(Prefix.prefix + ChatColor.GRAY + "GameMode set to " + ChatColor.GREEN +  "duo");
				}
				}
			}
			
		}
	
		return false;

}
	
}
