package com.gmail.bicycle2life;

public class Main {

    public static void main(String[] args) {
        GameTable gameTable = new GameTable(10,10);
        gameTable.generateShips();
        gameTable.printTable();
    }
}
