/*
 * Backpack.java
 * 
 * Created on 27-mei-2007, 1:06:45
 * 
 * Backpack increases player weight by 5 when picked up
 */

package nl.fab1an.java.world.items;

import nl.fab1an.java.world.*;

/**
 *
 * @author Fabian
 */
public class Backpack extends Item {

    public Backpack(String name, String description, int weight, Object areaOrPlayer, Game game) {
        super(name,description,weight,areaOrPlayer, game);
    }
    
    public void setLocation(Object areaOrPlayer) { 
        super.setLocation(areaOrPlayer);
        if (areaOrPlayer instanceof Player) {
        Player player = (Player) areaOrPlayer;
        player.setMaxWeight(player.getMaxWeight() + 5);
        }
    }

}
