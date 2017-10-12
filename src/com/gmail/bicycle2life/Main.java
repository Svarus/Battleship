package com.gmail.bicycle2life;

public class Main {

    public static void main(String[] args) {
        int rows = 10;
        int columns = 10;

        GameTable gameTable = new GameTable(rows,columns);
        gameTable.generateShips();
        gameTable.printTable();
    }
}
