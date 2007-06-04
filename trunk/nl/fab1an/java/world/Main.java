package nl.fab1an.java.world;

import nl.fab1an.java.world.*;
import nl.fab1an.java.world.items.*;
import nl.fab1an.java.world.commands.*;

/*
 * Main.java
 *
 * Created on 29-mei-2007, 1:27:01
 *
 * The game world is created here.
 */

/**
 *
 * @author Fabian
 */
public class Main {
    
    public Main() {
    }
    
    public static void main(String[] args) {
        // create game
        Game game = new Game();
        
        // create areas
        Area desert = new Area("desert","This is the desert, there is sand everywhere.",game);
        Area town = new Area("town","This is a town in the middle of the desert. It looks abandoned",game);
        Area airport = new Area("airport","This a small airport, there seem to be no planes",game);
        Area school = new Area("school","This looks like a school, the door is open",game);
        Area beach = new Area("beach","This is a beach, the water is clear.",game);
        Area mall = new Area("mall","This is a mall, the stores are open.",game);
        Area beamroom = new MagicArea("beamroom","WTF.. all the exits look like portals!",game);
        
        game.addArea(desert);
        game.addArea(town);
        game.addArea(airport);
        game.addArea(school);
        game.addArea(beach);
        game.addArea(mall);
        game.addArea(beamroom);
        
        // add area exits
        desert.addExit("east",town);
        desert.addExit("west",airport);
        
        town.addExit("west",desert);
        town.addExit("east",school);
        
        airport.addExit("east",desert);
        
        school.addExit("west",town);
        school.addExit("east",beach);
        
        beach.addExit("west",school);    
        beach.addExit("north",mall);
        //beach.addExit("east",beamroom);
        
        mall.addExit("south",beach);
        
        
        
        // create doors
        Door silverdoor = new Door("Silverdoor","A shiny silver door",game);
        silverdoor.addDoorBetween(desert,airport);
        
        game.addDoor(silverdoor);
        

        // create players
        String dfsfsdf = javax.swing.JOptionPane.showInputDialog(null,"Name of first player","Zuulian");
        String fedhfsjkd = javax.swing.JOptionPane.showInputDialog(null,"Name of second player?","John");
        
        Player playerone = new Player(dfsfsdf,5,game,desert);
        playerone.setDescription("Another player");
        playerone.println("Hello " + playerone + ", welcome to FabWorld!");
        
        Player playertwo = new Player(fedhfsjkd,5,game,desert);
        playertwo.setDescription("Another player");
        playertwo.println("Hello " + playertwo + ", welcome to FabWorld!");
        java.awt.Rectangle bounds = playertwo.getGui().getBounds();
        playertwo.getGui().setBounds(120, 20, 607, 409);
        
        game.addPlayer(playerone);
        game.addPlayer(playertwo);
        
        // create creatures
        NonPlayerCharacter blubber = new NonPlayerCharacter("Blubber",999,game,beach);
        blubber.setDescription("A weird looking creature");
        game.addPlayer(blubber);
        
        Item stone = new Item("stone","A small stone",2,desert,game);
        Item laptop = new Item("laptop","An old laptop",2,school,game);
        Item paper = new Item("paper","A piece of paper with some writings on it",2,school,game);
        Item bottle = new Item("bottle","A bottle of Bacardi, its seems unopened",2,airport,game);
        Backpack backpack = new Backpack("backpack","You can carry more items with this bag",2,town,game);
        Item beerglass = new Item("beerglass","A full glass of beer",2,mall,game);
        Beamer beamer = new Beamer("beamer","It looks like some kind of gadget",2,airport,game);
        Shotgun shotgun = new Shotgun("shotgun","A loaded shotgun",2,beach,game);
        Item bread = new Item("bread","A loaf of bread",2,mall,game);
        
        Key key = new Key("key","A small shiny silver key",2,blubber,game);
        key.setKeyFor(silverdoor);
        
        game.addItem(stone);
        game.addItem(laptop);
        game.addItem(paper);
        game.addItem(bottle);
        game.addItem(backpack);
        game.addItem(beerglass);
        game.addItem(beamer);
        game.addItem(shotgun);
        game.addItem(bread);
        game.addItem(key);
        
        // create commands
        Command help = new CommandHelp();
        Command go = new CommandGo();
        Command use = new CommandUse();
        Command clear = new CommandClear();
        Command drop = new CommandDrop();
        Command give = new CommandGive();
        Command inventory = new CommandInventory();
        Command look = new CommandLook();
        Command say = new CommandSay();
        Command take = new CommandTake();
        Command tell = new CommandTell();
        
        game.addCommand(help);
        game.addCommand(go);
        game.addCommand(use);
        game.addCommand(clear);
        game.addCommand(drop);
        game.addCommand(give);
        game.addCommand(inventory);
        game.addCommand(look);
        game.addCommand(say);
        game.addCommand(take);
        game.addCommand(tell);
    }
    
    
}
