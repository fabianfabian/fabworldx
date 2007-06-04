/*
 * CommandTake.java
 * 
 * Created on 29-mei-2007, 20:06:37
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
public class CommandTake extends Command {
    
    public CommandTake() {
        setTrigger("take");
    }
    
    public void realExecute() {
        getPlayer().take(getWords()[1]);
    }
}
