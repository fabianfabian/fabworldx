/*
 * CommandTell.java
 *
 * Created on 29-mei-2007, 20:09:59
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
public class CommandTell extends Command {
    
    public CommandTell() {
        setTrigger("tell");
    }
    
    public void realExecute() {
        String message = "";
        for (int i = 2; i < getWords().length; i++) { message = message + " " + getWords()[i]; }
        getPlayer().tell(getWords()[1],message);
    }
}
