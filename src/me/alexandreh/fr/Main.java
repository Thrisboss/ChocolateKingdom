package me.alexandreh.fr;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.alexandreh.fr.commands.ck;
import me.alexandreh.fr.crafting.Chocolate;
import me.alexandreh.fr.listeners.ItemRecipe;
import me.alexandreh.fr.listeners.PlayerConnection;
import me.alexandreh.fr.listeners.PlayerLeave;
import me.alexandreh.fr.scoreboard.ScoreboardRunnable;
import me.alexandreh.fr.utils.Starter;
import me.alexandreh.fr.utils.State;
import me.alexandreh.fr.utils.Teams;
import me.alexandreh.fr.utils.Time;


public class Main extends JavaPlugin{
	
	public static PluginManager pm;
	Server server = this.getServer();
	
	@Override
	public void onEnable() {
		pm = Bukkit.getPluginManager();
		regListeners();
		registerCommands();
	    instance = this;
		State.setState(State.WAITING);
		new ScoreboardRunnable().runTaskTimer(this, 20L, 20L);	
		ChocolateClass.Recipe();
		
		
	}
		
	public void regListeners(){
		pm.registerEvents(new PlayerConnection(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new ItemRecipe(), this);
        
	}
	
	
	@Override
	public void onDisable(){
	}
	
	public void registerCommands(){
		getCommand("ck").setExecutor(new ck());
		
	}
	public static Main instance;
	public static Main getPlugin(){
		return instance;
	}
	private final static Chocolate ChocolateClass = new Chocolate();
	
	public static Chocolate getClassName2(){
		return ChocolateClass;
	}
	
	private final static Time Timeclass = new Time();
	 
	public static Time getClassName()
	{
	return Timeclass;
	}
	
}
	


