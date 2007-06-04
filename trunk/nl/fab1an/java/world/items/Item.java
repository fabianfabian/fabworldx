/*
 * Item.java
 *
 * Created on 22-mei-2007, 12:11:41
 *
 * Superclass for all Items in the game
 * Extend this class to add new Items to the game
 * See other classes in this pacakage for samples.
 */
package nl.fab1an.java.world.items;
import nl.fab1an.java.world.*;

/**
 *
 * @author Fabian
 */
public class Item {
    private String name;
    private String description;
    private Object currentLocation;
    private int weight;
    private Game game;

    
    public Item(String name, String description, int weight, Object areaOrPlayer, Game game) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.game = game;
        if (areaOrPlayer instanceof Area) { this.currentLocation = (Area) areaOrPlayer; }
        if (areaOrPlayer instanceof Player) { this.currentLocation = (Player) areaOrPlayer; }
    }
    
    public Object getLocation() { return currentLocation; }
    public void setLocation(Object areaOrPlayer) { currentLocation = areaOrPlayer; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public String toString() { return name; }
    
    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }
    
    public void use() { }
    
    public void setGame(Game game) { this.game = game; }
    public Game getGame() { return game; }
    
}
