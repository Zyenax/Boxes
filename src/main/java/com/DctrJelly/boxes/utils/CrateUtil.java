package com.DctrJelly.boxes.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;

import com.DctrJelly.boxes.Main;

public class CrateUtil implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public CrateUtil(Main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<Integer, Material> CrateStorage = new HashMap<Integer, Material>();
	public static void createCrate(Location loc, Integer ID, String name, Material cratematerial, String worldname, BlockFace blockface){
		if(!CrateStorage.containsKey(ID)){
			CrateStorage.put(ID, cratematerial);
			
			
			
			
			HologramUtil.createHoloGram(loc.add(0, 0.5, 0), Utils.color(name), ID);
		}else{
			ConsoleCommandSender console = Bukkit.getConsoleSender();
			console.sendMessage(Utils.color("&cThe crate with the ID &e" + ID + " &cis already made!"));
		}
	}
}
