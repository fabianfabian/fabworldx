/*
 * Parser.java
 * 
 * Created on 27-mei-2007, 14:52:14
 * 
 * The parsers takes text input from the GUI and
 * figures out what to do with it (commands).
 */

package nl.fab1an.java.world;
import nl.fab1an.java.world.commands.Command;

/**
 *
 * @author Fabian
 */;
 public class Parser {
     private Game game;
     private Player player;
     
     public Parser(Game game,Player player) {
         this.game = game;
         this.player = player;
     }
     
     /**
      * If a command is recognized, execute it.
      * Otherwise pass the input to the "say" command
      * for chatting.
      * 
      * @param textFromInput - command or chat message
      */
     public void command(String textFromInput) {
         String[] words = textFromInput.toLowerCase().split(" ");
         if (game.getCommand(words[0]) != null) {
             Command command = (Command) game.getCommand(words[0]);
             command.execute(words,game,player);
         }
         else {
            Command command = (Command) game.getCommand("say");
            String[] newwords = new String[words.length+1];
            newwords[0] = "say";
            for (int i = 0; i < words.length; i++) {
                newwords[i+1] = words[i];
            }
            command.execute(newwords,game,player);
         }
         player.getGui().updateInterface();
     }
        
 }
