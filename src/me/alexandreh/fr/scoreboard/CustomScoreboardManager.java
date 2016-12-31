package me.alexandreh.fr.scoreboard;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.alexandreh.fr.utils.State;
import me.alexandreh.fr.utils.Teams;
import me.alexandreh.fr.utils.Time;


public class CustomScoreboardManager implements ScoreboardManager{
	   
    public Player player;
    public Scoreboard scoreboard;
    public Objective objective;
    public static HashMap<Player, CustomScoreboardManager> sb = new HashMap<>();
   
    private String name = "uhcrun";
   
    public CustomScoreboardManager(Player p){
       
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.player = p;
       
        //SI IL EST DANS LA MAP ON NE FAIT RIEN
        if(sb.containsKey(p)) return;
       
        //SINON SI IL NA PAS DE SCOREBOARD ON LUI EN CREER MAIS CUSTOMISER
        sb.put(p, this);
       
        Random r = new Random();
       
        this.name = "sb."+r.nextInt(1000000);
       
        objective = scoreboard.registerNewObjective(name, "dummy");
        objective = scoreboard.getObjective(name);
        objective.setDisplayName("§e" + "ChocoKingdom");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
       
    }
 
    //ON MET A JOUR UNIQUEMENT LES ELEMENTS DYNAMIQUE
    public void refresh(){

            int timer = Time.time;
            int lastTimer = timer - 1;
            String lastS = new SimpleDateFormat("mm:ss").format(lastTimer * 1000);
            String S = new SimpleDateFormat("mm:ss").format(timer * 1000);
            
            String day = Time.days + "";
            String last_day = Time.days - 1 + "";
            
            objective.getScoreboard().resetScores(lastS);
            objective.getScore(S).setScore(3);
            
            objective.getScoreboard().resetScores(last_day);
            objective.getScore(day).setScore(1);;
            
            
           
        }
 
 
    
   
    //ON PLACE LES ELEMENTS QUI NE VONT PAS BOUGER
    public void getLine(){
       
        objective.getScore("§7 Temps").setScore(4);
        objective.getScore("§7 Jours: ").setScore(2);
        objective.getScore("§e" + "Alexandreh.fr").setScore(0);
       
    }
   
    //ON RECUP LE SCOREBOARD CUSTOM DU JOUEUR
    public static CustomScoreboardManager getScoreboard(Player p){
        return sb.get(p);
    }
   
    @Override
    public Scoreboard getMainScoreboard() {
        return scoreboard;
    }
 
    @Override
    public Scoreboard getNewScoreboard() {
        return null;
    }
 
}