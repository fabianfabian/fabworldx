/*
 * CommandGo.java
 *
 * Created on 29-mei-2007, 19:55:55
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
public class CommandGo extends Command {
    
    public CommandGo() {
        setTrigger("go");
    }
    
    public void realExecute() {
        getPlayer().go(getWords()[1]);
        //getPlayer().look();
    }
}

