/*
 * Player.java
 *
 * Created on 22-mei-2007, 11:55:17
 *
 * The actual players that play this game.
 * Each player has his own GUI
 */
package nl.fab1an.java.world;
import nl.fab1an.java.world.items.Item;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Fabian
 */
 public class Player {
     
     private String name;
     private Area currentArea;
     private int maxWeight;
     private Game game;
     private Gui gui;
     private Parser parser;
     private boolean alive;
     private ArrayList path;
     private String description;
     
     public Player() {
         
     }
     
     public Player(String name, int maxWeight, Game game, Area currentArea) {
         this.path = new ArrayList();
         this.currentArea = currentArea;
         this.game = game;
         this.name = name;
         this.maxWeight = maxWeight;
         gui = new Gui(game,this);
         gui.setVisible(true);
         this.parser = new Parser(game,this);
         alive = true;
     }
     
     public boolean isAlive() { return alive; }
     public void setAlive(boolean alive) {
         this.alive = alive;
         if ((!alive) && (getGui() != null)) {
             getGui().disableInterface();
         }
     }
     public Parser getParser() { return parser; }
     public void setParser(Parser parser) { this.parser = parser; }
     
     public Gui getGui() { return gui; }
     public void setGui(Gui gui) { this.gui = gui; }
     
     public String getName() { return name; }
     public String toString() { return name; }
     public void setName(String name) { this.name = name; }
     
     public Game getGame() { return game; }
     public void setGame(Game game) { this.game = game; }
     
     public Area getCurrentArea() { return currentArea; }
     public void setCurrentArea(Area area) { this.currentArea = area; }
     
     /**
      * Use this method to simulate walking from area to area.
      * This method also stores the area for use with the goBack() method
      * @param direction where to go (should be an existing exit in the current Area of the player)
      */
     public void go(String direction) {
         path.add(getCurrentArea());
         if (getCurrentArea().getExit(direction) == null) throw new NullPointerException();
         setCurrentArea(getCurrentArea().getExit(direction));
         println("You are now in: " + getCurrentArea().getName());
         println(getCurrentArea().getDescription());
     }
     
     /**
      * Go back to previous room and remove last stored area from path
      */
     public void goBack() {
         setCurrentArea((Area) path.get(path.size() - 1));
         path.remove(path.size() -1);
         println("You are now in: " + getCurrentArea().getName());
     }
     
     public void drop(String itemKey) {
         game.getItem(itemKey).setLocation(getCurrentArea());
         println("You dropped: " + itemKey);
     }
     
     /**
      * Method for picking up items.
      * Checks if the player does not carry too much weight before actually 
      * picking up the item
      * @param itemKey shortname for the item to pick ip
      */
     public void take(String itemKey) {
         if (game.getItem(itemKey).getLocation() == getCurrentArea()) {
             if ((game.getItem(itemKey).getWeight() + getCurrentWeight()) <= getMaxWeight()) {
                 game.getItem(itemKey).setLocation(this);
                 println("You picked up: " + itemKey);
             } else { println("You can't carry any more weight"); }
         }
     }
     
     public void setMaxWeight(int maxWeight) { this.maxWeight = maxWeight; }
     public int getMaxWeight() { return maxWeight; }
     
     /**
      * Get current weight that the player is carrying (adds up all items)
      * @return weight weight of all items carried combined.
      */
     public int getCurrentWeight() {
         int currentWeight = 0;
         HashMap items = game.getItems();
         Iterator iter = items.values().iterator();
         while (iter.hasNext()) {
             Item currentItem = (Item) iter.next();
             if (currentItem.getLocation() == this)
                 currentWeight = currentWeight + currentItem.getWeight();
         }
         return currentWeight;
     }
     
     /**
      * Iterates through all items, players and doors and prints them to the GUI
      */
     public void look() {
         println("You look around and see:");
         boolean seenSomething = false;
         
         // iterate through items
         HashMap items = game.getItems();
         Iterator iter = items.values().iterator();
         while (iter.hasNext()) {
             Item currentItem = (Item) iter.next();
             if (currentItem.getLocation() == getCurrentArea()) {
                 println(currentItem.getName() + " - " + currentItem.getDescription());
                 seenSomething = true; }
         }
         
         // iterate through players
         HashMap players = game.getPlayers();
         Iterator iter2 = players.values().iterator();
         while (iter2.hasNext()) {
             Player currentPlayer = (Player) iter2.next();
             if ((currentPlayer.getCurrentArea() == getCurrentArea()) && (currentPlayer != this)) {
                 println(currentPlayer.getName() + " - " + currentPlayer.getDescription());
                 seenSomething = true; }
         }

         // iterate through doors
         HashMap doors = game.getDoors();
         Iterator iter3 = doors.values().iterator();
         while (iter3.hasNext()) {
             Door currentDoor = (Door) iter3.next();
             if ((currentDoor.getAreaFrom() == currentArea) || (currentDoor.getAreaTo() == currentArea)) {
                 println(currentDoor.getName() + " - " + currentDoor.getDescription());
                 seenSomething = true; }
         }
         
         if (!seenSomething) {
             println("Nothing special.");
         }
     }
     
     public void showInventory() {
         println("You are carrying the following items:");
         HashMap items = game.getItems();
         Iterator iter = items.values().iterator();
         while (iter.hasNext()) {
             Item currentItem = (Item) iter.next();
             if (currentItem.getLocation() == this)
                 println(currentItem.getName() + " - " + currentItem.getDescription());
         }
     }
     
     public void setDescription(String description) { this.description = description; }
     public String getDescription() { return description; }
     
     //TODO: rename to useItem maybe?
     public void use(String keyOfItemToUse) {
         if (game.getItem(keyOfItemToUse).getLocation() == this) {
             game.getItem(keyOfItemToUse).use();
         }
     }
     
     /**
      * Enables you to speak to other players in the game.
      * Sends the message to the hear() method of each Player/NPC in the same
      * Area
      * @param message message to send to other players.
      */
     public void speak(String message) {
         println("You say: " + message);
         HashMap players = game.getPlayers();
         Iterator iter = players.values().iterator();
         while (iter.hasNext()) {
             Player currentPlayer = (Player) iter.next();
             if ((currentPlayer.getCurrentArea() == getCurrentArea()) && (currentPlayer != this)) {
                 if (currentPlayer.isAlive()) {
                     currentPlayer.hear(message,this);
                 }
             }
         }
     }
     
     /**
      * When a player "hears" something it is displayed in the GUI
      * @param message the message that is heard
      * @param player the player that sent the message
      */
     public void hear(String message, Player player) {
         println(player + " says: " + message);
     }
     
     /**
      * Enables you to whisper to other players in the game.
      * Sends the message to the hear() method of specified Player/NPC.
      * The difference from speak() is that tell() does not require the 
      * player to be in the same Area.
      * 
      * TODO/IDEA: Maybe only allow this if player picked up mobile phone or something?
      * 
      * @param keyOfPlayerToSpeakTo player to send the message to.
      * @param message message to send to the other player.
      */
     public void tell(String keyOfPlayerToSpeakTo, String message) {
         Player playerToSpeakTo = game.getPlayer(keyOfPlayerToSpeakTo);
         println("You whisper to " + playerToSpeakTo + ": " + message);
         playerToSpeakTo.println(this + " whispers to you: " + message);
     }
     
     /**
      * Players can give items to other players with this method.
      * @param keyOfPlayerToGiveTo player that you want to give the item to
      * @param keyOfItemToGive item you want to give away
      */
     public void give(String keyOfPlayerToGiveTo, String keyOfItemToGive) {
         Player to = game.getPlayer(keyOfPlayerToGiveTo);
         if ((game.getItem(keyOfItemToGive).getLocation() == this) && (to.getCurrentArea() == getCurrentArea())) {
             if ((game.getItem(keyOfItemToGive).getWeight() + to.getCurrentWeight()) <= to.getMaxWeight()) {
                 println("You gave " + to + ": " + game.getItem(keyOfItemToGive));
                 game.getItem(keyOfItemToGive).setLocation(to);
                 to.receive(getName().toLowerCase(),keyOfItemToGive);
             } else {
                 println(to + " can't carry any more items");
             }
         }
     }
     
     /**
      * When you receive a message it is displayed in the GUI
      * @param keyOfPlayerReceivedFrom player from who the item is received
      * @param keyOfItemReceived the item that is being received
      */
     public void receive(String keyOfPlayerReceivedFrom, String keyOfItemReceived) {
             println(game.getPlayer(keyOfPlayerReceivedFrom).getName() + " gave you: " + game.getItem(keyOfItemReceived));
     }
     
     public void println(String message) {
         if (gui != null) gui.println(message);
     }
 }
