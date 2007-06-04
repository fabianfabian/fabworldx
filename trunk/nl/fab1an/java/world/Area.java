/*
 * Area.java
 *
 * Created on 22-mei-2007, 12:41:41
 *
 * Rooms, places, cities, locations are all defined in the game as Areas
 */
package nl.fab1an.java.world;
import java.util.HashMap;

/**
 *
 * @author Fabian
 */
 public class Area {
     private String name;
     private String description;
     private HashMap exits;
     private Game game;
     
     public Area(String name, String description, Game game) {
         this.name = name;
         this.description = description;
         this.game = game;
         exits = new HashMap();
     }
     
     public void setName(String name) { this.name = name; }
     public String getName() { return name; }
     public String toString() { return name; }
     public void setGame(Game game) { this.game = game; }
     public Game getGame() { return game; }
     public void setDescription(String description) { this.description = description; }
     public String getDescription() { return description; }
     
     public void addExit(String direction, Area area) {
         exits.put(direction,area);
         exits.put(area,direction);
     }
     public void removeExit(String direction) {
         exits.remove(getExit(direction));
         exits.remove(direction);
     }
     public Area getExit(String direction) {
         return (Area) exits.get(direction);
     }
     public String getExit(Area key) {
         return (String) exits.get(key);
     }
     public HashMap getExits() { return exits; }
 }
