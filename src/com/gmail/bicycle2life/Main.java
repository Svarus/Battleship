package com.gmail.bicycle2life;

public class Main {

    public static void main(String[] args) {
        int rows = 10;
        int columns = 10;
        int maxShipSize = 4;

        GameTable gameTable = new GameTable(rows, columns, maxShipSize);
        gameTable.generateShips();
        gameTable.printTable();
    }
}
