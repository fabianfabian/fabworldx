/*
 * CommandUse.java
 * 
 * Created on 29-mei-2007, 19:57:58
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
public class CommandUse extends Command {

    public CommandUse() {
        setTrigger("use");
    }
    
    public void realExecute() {
        getPlayer().use(getWords()[1]);
    }
}
