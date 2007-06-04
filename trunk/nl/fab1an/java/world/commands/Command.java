/*
 * Command.java
 * 
 * Created on 29-mei-2007, 19:27:42
 * 
 * Superclass of all the commands
 * Extend this class to add new commands
 * See other classes in this package as sample
 */

package nl.fab1an.java.world.commands;

import nl.fab1an.java.world.*;

/**
 *
 * @author Fabian
 */
public class Command {
    private String[] words;
    private Game game;
    private Player player;
    private String trigger;

    public Command() {
    }
    
    public void setTrigger(String trigger) { this.trigger = trigger; }
    public String getTrigger() { return trigger; }
    
    public void setGame(Game game) { this.game = game; }
    public Game getGame() { return game; }
    
    public void setPlayer(Player player) { this.player = player; }
    public Player getPlayer() { return player; }
    
    public void setWords(String[] words) { this.words = words; }
    public String[] getWords() { return words; }
    
    public void execute(String[] words, Game game, Player player) {
        this.words = words;
        this.game = game;
        this.player = player;
        realExecute();
    }
    
    public void realExecute() {  }

}
