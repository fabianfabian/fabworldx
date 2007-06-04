/*
 * NonPlayerCharacter.java
 * 
 * Created on 28-mei-2007, 19:49:22
 * 
 * Creature controlled by the computer.
 */

package nl.fab1an.java.world;

/**
 *
 * @author Fabian
 */
public class NonPlayerCharacter extends Player {

    public NonPlayerCharacter(String name, int maxWeight, Game game, Area currentArea) { 
        setCurrentArea(currentArea);
        setGame(game);
        setName(name);
        setMaxWeight(maxWeight);
        setAlive(true);
    }
    
    public void hear(String message, Player player) {
        speak("Hello " + player + ", can you help me get some food?");
    }   
    
    public void receive(String keyOfPlayerReceivedFrom, String keyOfItemReceived) {
        if (keyOfItemReceived.equals("bread")) {
            tell(keyOfPlayerReceivedFrom,"Thank you! Here, take this key as a reward.");
            give(keyOfPlayerReceivedFrom,"key");
        }
    }
}
