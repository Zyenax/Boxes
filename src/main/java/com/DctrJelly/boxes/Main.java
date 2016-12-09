package com.DctrJelly.boxes;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.DctrJelly.boxes.utils.CrateUtil;
import com.DctrJelly.boxes.utils.HologramUtil;
import com.DctrJelly.boxes.utils.Utils;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		registerListeners();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&cBoxes has been enabled!"));
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&cBoxes has been disabled!"));
	}
	
	public void registerListeners(){
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(new HologramUtil(this), this);
		manager.registerEvents(new Utils(this), this);
		manager.registerEvents(new CrateUtil(this), this);
	}
}
