/*
 * CommandInventory.java
 * 
 * Created on 29-mei-2007, 20:11:31
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
public class CommandInventory extends Command {
    
    public CommandInventory () {
        setTrigger("inventory");
    }
    
    public void realExecute() {
        getPlayer().showInventory();
    }
}
