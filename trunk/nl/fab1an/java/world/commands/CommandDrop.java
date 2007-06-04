/*
 * CommandDrop.java
 * 
 * Created on 29-mei-2007, 20:12:21
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
public class CommandDrop extends Command {
    
    public CommandDrop() {
        setTrigger("drop");
    }
    
    public void realExecute() {
        getPlayer().drop(getWords()[1]);
    }
}
