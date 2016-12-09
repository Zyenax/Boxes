package com.DctrJelly.boxes.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;

import com.DctrJelly.boxes.Main;

public class HologramUtil implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;
	public HologramUtil(Main listener) {
		HologramUtil.plugin = listener;		
	}
	
	public static HashMap<Integer, Entity> HoloStorage = new HashMap<Integer, Entity>();
	public static void createHoloGram(Location loc, String Name, Integer ID){
		if(!HoloStorage.containsKey(ID)){
		final ArmorStand hologram = (ArmorStand) loc.getWorld().spawn(loc, ArmorStand.class);
		hologram.setVisible(false);
		hologram.setCustomName(Utils.color(Name));
		hologram.setCustomNameVisible(true);
		hologram.setGravity(false);
		HoloStorage.put(ID, hologram);
		}else{
			ConsoleCommandSender console = Bukkit.getConsoleSender();
			console.sendMessage(Utils.color("&cThe hologram with the ID &e" + ID + " &cis already made!"));
		}
	}
	
	public static void removeHoloGram(Integer ID){
		HoloStorage.get(ID).remove();
		HoloStorage.remove(ID);
	}
	
	public static void teleportHoloGram(Integer ID, Location loc){
		HoloStorage.get(ID).teleport(loc.add(0.5, 0, 0.5));
	}
	
	public static void renameHoloGram(String Name, Integer ID){
		HoloStorage.get(ID).setCustomName(Utils.color(Name));
		HoloStorage.get(ID).setCustomNameVisible(true);
	}

}
