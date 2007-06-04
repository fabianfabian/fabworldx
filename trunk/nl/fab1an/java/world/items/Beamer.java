/*
 * Beamer.java
 * 
 * Created on 27-mei-2007, 1:29:12
 * 
 * Beamer stores current location when used for the first time (charge)
 * Beams player back to the stored location when used for the second time.
 */

package nl.fab1an.java.world.items;

import nl.fab1an.java.world.*;

/**
 *
 * @author Fabian
 */
public class Beamer extends Item {
    private final int UNCHARGED = 0;
    private final int CHARGED = 1;
    private int state;
    private Area beamArea;

    public Beamer(String name, String description, int weight, Object areaOrPlayer, Game game) {
        super(name,description,weight,areaOrPlayer, game);
        state = UNCHARGED;
    }
    
    public void use() {
        Player player = (Player) super.getLocation();
        switch (state) {
            case UNCHARGED:
                state = CHARGED;
                beamArea = (Area) player.getCurrentArea();
                player.getGui().println("You charged the beamer");
            break;
            case CHARGED:
                state = UNCHARGED;
                player.setCurrentArea(beamArea);
                player.getGui().println("You have been beamed to: " + beamArea);
            break;
         }
    }

}
