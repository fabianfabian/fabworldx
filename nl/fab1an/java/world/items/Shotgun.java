/*
 * Shotgun.java
 *
 * Created on 27-mei-2007, 4:24:44
 *
 * Shotgun can be used to kill other players.
 */

package nl.fab1an.java.world.items;
import nl.fab1an.java.world.*;
import java.util.*;
/**
 *
 * @author Fabian
 */
public class Shotgun extends Item {
    private int ammo;
    
    public Shotgun(String name, String description, int weight, Object areaOrPlayer, Game game) {
        super(name,description,weight,areaOrPlayer, game);
        ammo = 6;
    }
    
    /**
     * When used, iterates through all players in the same room and kills 
     * them (setAlive(false)) but stops when ammo reaches 0.
     */
    public void use() {
        Player itemHolder = (Player) super.getLocation();
        if (ammo > 0) {
            HashMap players = super.getGame().getPlayers();
            Iterator iter = players.values().iterator();
            boolean shotSomeone = false;
            while (iter.hasNext() && (ammo > 0)) {
                Player currentPlayer = (Player) iter.next();
                if ((currentPlayer.getCurrentArea() == itemHolder.getCurrentArea()) && (currentPlayer != itemHolder)) {
                    if (currentPlayer.isAlive()) {
                        ammo--;
                        itemHolder.getGui().println("You shot " + currentPlayer.getName());
                        if (currentPlayer.getGui() != null) {
                            currentPlayer.getGui().println("You got shot by " + itemHolder.getName() + " - Game Over.");
                        }
                        currentPlayer.setAlive(false);
                        shotSomeone = true;
                    }
                }
            }
            if (!shotSomeone) {
                ammo--;
                itemHolder.getGui().println("You shoot but hit nothing but air.");
            }
        } else {
            itemHolder.getGui().println("You pull the trigger but only hear a soft click, it's empty.");
        }
    }
}
