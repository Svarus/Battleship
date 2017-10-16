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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (hasShip != cell.hasShip) return false;
        if (free != cell.free) return false;
        if (ship != null ? !ship.equals(cell.ship) : cell.ship != null) return false;
        return info != null ? info.equals(cell.info) : cell.info == null;
    }

    @Override
    public int hashCode() {
        int result = ship != null ? ship.hashCode() : 0;
        result = 31 * result + (hasShip ? 1 : 0);
        result = 31 * result + (free ? 1 : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
