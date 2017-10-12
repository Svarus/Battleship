package com.gmail.bicycle2life;

public class Cell {
    private Ship ship;
    private boolean hasShep;
    private boolean isFree;
    private String info;

    public Cell() {
        isFree = true;
        info = " ";
    }

    public void setShip(Ship ship){
        this.ship = ship;
        hasShep = true;
        isFree = false;
        info = "S";
    }

    public void setFree(boolean isFree){
        this.isFree = isFree;
        //info = "s";
    }

    public boolean hasShip() {
        return hasShep;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString(){
        return info;
    }
}
