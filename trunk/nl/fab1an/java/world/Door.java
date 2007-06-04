/*
 * Door.java
 * 
 * Created on 29-mei-2007, 14:31:59
 * 
 * Doors can be added in between any two Areas
 */

package nl.fab1an.java.world;

/**
 *
 * @author Fabian
 */
public class Door extends Area {
    
    boolean locked;
    Area areaTo;
    Area areaFrom;
    String directionTo;
    String directionFrom;

    public Door(String name, String description, Game game) {
        super(name,description,game);
        locked = true;
    }
    
    /**
     * Add a door between two areas.
     * If you add a door between A and B and B is east of A
     * then this method will remove the east exit of A and the 
     * west exit of B simulating a blocked (locked) path.
     * @param areaFrom - area from
     * @param areaTo - area to
     */
    public void addDoorBetween(Area areaFrom, Area areaTo) {
        this.areaTo = areaTo;
        this.areaFrom = areaFrom;
        
        // store TO
        // and remove from.TO exit
        this.directionTo = areaFrom.getExit(areaTo);
        areaFrom.removeExit(areaFrom.getExit(areaTo));
        
        // store FROM
        // and remove to.FROM exit
        this.directionFrom = areaTo.getExit(areaFrom);
        areaTo.removeExit(areaTo.getExit(areaFrom));
    }
    
    /**
     * Restores the original exits on the path that was
     * between the Areas where the door was added in between.
     */
    public void unlock() {
        //set exit FROM to TO
        setLocked(false);
        areaFrom.addExit(directionTo,areaTo);
        
        //set exit TO to FROM
        areaTo.addExit(directionFrom, areaFrom);
    }
    
    /**
     * Lock the door by removing the exits
     */
    public void lock() {
        setLocked(true);
        // remove exit TO from FROM
        areaFrom.removeExit(areaFrom.getExit(areaTo));
        // remove exit FROM from TO
        areaTo.removeExit(areaTo.getExit(areaFrom));
    }
    
    public Area getExit(String direction) {
       return (Area) getExits().get(direction);
    }
    
    public void setAreaTo(Area area) {
        this.areaTo = area;
    }
    public Area getAreaTo() {
        return areaTo;
    }
    
    public void setAreaFrom(Area area) {
        this.areaFrom = area;
    }
    public Area getAreaFrom() {
        return areaFrom;
    }
    
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    public boolean isLocked() { return locked; }
    
}
