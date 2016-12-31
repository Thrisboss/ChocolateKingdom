package me.alexandreh.fr.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.alexandreh.fr.chat.Prefix;


public class Time {

	private int taskid;
	private int taskid2;
	
	public static int days;
	public static int time;
	
	public void Countdown(){
		
		
			this.taskid = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(me.alexandreh.fr.Main.instance, new Runnable() {
			
			
			
			public void run() {
			
			if(time < 12000){	
			time++; 			
			
			}else{
				
			Bukkit.broadcastMessage(Prefix.prefix + ChatColor.GRAY + "La partie est terminée !");
			
			cancelTaskCountdown();
			}
			}
			
			},20L,20L);
		
		}
	
	public void Days(){
		
		this.taskid2 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(me.alexandreh.fr.Main.instance, new Runnable() {
			
			public void run(){
					
				if(days < 10){
					days ++;
					Bukkit.broadcastMessage(Prefix.prefix + ChatColor.GRAY + "Nous sommes maitenant au " +  ChatColor.GREEN + days +  ChatColor.GRAY + " jours");
				}else{
					cancelTaskDays();
				}
			}
			},20L, 24000L);
			}
			
		
		
	public void cancelTaskCountdown(){
		// This will cancel the task
		Bukkit.getServer().getScheduler().cancelTask(this.taskid);
		}
	public void cancelTaskDays(){
		Bukkit.getServer().getScheduler().cancelTask(this.taskid2);
	}
	
	}




	



