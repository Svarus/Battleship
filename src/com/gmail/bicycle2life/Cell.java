package com.gmail.bicycle2life;

/** Class for each item of {@link GameTable}
 * @version 1.0
 */
public class Cell {
    private Ship ship;
    private boolean hasShip;
    private boolean free;
    private String info;

    public Cell() {
        super();
        free = true;
        info = " ";
    }

    public void setShip(Ship ship){
        this.ship = ship;
        hasShip = true;
        free = false;
        info = "S";
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isHasShip() {
        return hasShip;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "ship=" + ship +
                ", hasShip=" + hasShip +
                ", free=" + free +
                ", info='" + info + '\'' +
                '}';
    }
}
