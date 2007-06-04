/*
 * MagicArea.java
 * 
 * Created on 28-mei-2007, 21:28:36
 * 
 * Magic area or beam room.
 * Teleports player to random area upon exit.
 */

package nl.fab1an.java.world;

/**
 *
 * @author Fabian
 */
public class MagicArea extends Area {

    public MagicArea(String name, String description, Game game) {
        super(name,description,game);
    }
    public Area getExit(String direction) {
            return (Area) getGame().getRandomArea();
    }
}
