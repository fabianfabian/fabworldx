/*
 * CommandHelp.java
 * 
 * Created on 29-mei-2007, 19:39:13
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
public class CommandHelp extends Command {
        
    public CommandHelp() {
        setTrigger("help");
    }
    
    public void realExecute() {
        getPlayer().println("You cry out for help...");
        getPlayer().println("Some tips:");
        getPlayer().println("Don't shoot Blubber");
        getPlayer().println("Give him some food instead.");
        getPlayer().println("Use the command 'look' to see what is in each area");
        getPlayer().println("-");
    }
}
