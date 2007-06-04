/*
 * CommandSpeak.java
 * 
 * Created on 29-mei-2007, 20:06:52
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.fab1an.java.world.commands;

import nl.fab1an.java.world.commands.Command;
import nl.fab1an.java.world.*;

/**
 *
 * @author Fabian
 */
public class CommandSay extends Command {

    public CommandSay() {
       setTrigger("say");
    }
    
    public void realExecute() {
        String message = "";
        for (int i = 1; i < getWords().length; i++) {
            message = message + getWords()[i] + " ";
        }
        getPlayer().speak(message);
    }
}
