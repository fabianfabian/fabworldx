/*
 * Key.java
 *
 * Created on 29-mei-2007, 15:31:05
 *
 * Keys can unlock doors in the game.
 */

package nl.fab1an.java.world.items;

import nl.fab1an.java.world.*;

/**
 *
 * @author Fabian
 */
public class Key extends Item {
    
    Door keyFor;
    
    public Key(String name, String description, int weight, Object areaOrPlayer, Game game) {
        super(name,description,weight,areaOrPlayer, game);
    }
    
    public void setKeyFor(Door keyFor) { this.keyFor = keyFor; }
    public Door getKeyFor() { return keyFor; }
    
    public void use() {
        Player itemHolder = (Player) super.getLocation();
        if ((itemHolder.getCurrentArea() == keyFor.getAreaFrom()) || (itemHolder.getCurrentArea() == keyFor.getAreaTo())) {
            if (keyFor.isLocked()) {
                itemHolder.getGui().println("You have unlocked the door.");
                keyFor.unlock();
            } else {
                itemHolder.getGui().println("You have locked the door.");
                keyFor.lock();
            }
        }
    }
    
}
