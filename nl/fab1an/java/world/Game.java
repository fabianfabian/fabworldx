package nl.fab1an.java.world;

import nl.fab1an.java.world.commands.Command;
import nl.fab1an.java.world.items.Item;
import java.util.HashMap;
import java.util.Random;
import java.util.*;

/**
 * The Game object knows about everything in the game,
 * Areas, Items, Players, Doors and Commands are added to
 * the Game object to create a (virtual) world.
 *
 * @author Fabian
 * @version 0.1
 */
 public class Game {
     private HashMap areas;
     private HashMap items;
     private HashMap players;
     private HashMap doors;
     private HashMap commands;
     
     public Game() {
         areas = new HashMap();
         items = new HashMap();
         players = new HashMap();
         doors = new HashMap();
         commands = new HashMap();
     }
     
     
             
     // add/get player
     public Player getPlayer(String key) { return (Player) players.get(key); }
     public void addPlayer(Player player) { players.put(player.getName().toLowerCase(),player); }
     public HashMap getPlayers() { return players; }
     
     // add/get area
     public void addArea(Area area) { areas.put(area.getName(),area); }
     public Area getArea(String name) { return (Area) areas.get(name); }
     
     public void addDoor(Door door) { doors.put(door.getName(),door); }
     public Door getDoor(String door) { return (Door) doors.get(door); }
     public HashMap getDoors() { return doors; }
     
     public void addItem(Item item) { items.put(item.getName(),item); }
     public Item getItem(String name) { return (Item) items.get(name); }
     public HashMap getItems() { return items; }
     
     public void addCommand(Command command) { commands.put(command.getTrigger(),command); }
     public Command getCommand(String command) { return (Command) commands.get(command); }
     public HashMap getCommands() { return commands; }
     
     // return random area
     // TODO: create getAreas method here and move getRandomArea() to the beamroom (MagicArea) class
     public Area getRandomArea() {
         Iterator iter = areas.values().iterator();
         ArrayList areasArray = new ArrayList();
         while (iter.hasNext()) {
             areasArray.add(iter.next());
         }
         int max = areasArray.size();
         Random r = new java.util.Random();
         return (Area) areasArray.get(r.nextInt(max));
     }
 }
