package com.gmail.bicycle2life;

/** Main Class
 * @version 1.0
 * rows is height of game field (default is 10)
 * columns is width of game field (default is 10)
 * maxShipSize is size of biggest ship
 * Please notice! For now while changing maxShipSize be sure also to change
 * size of game field (rows or/and columns). If game field is too small
 * program will enter to infinity loop trying to create ships without free space.
 * By default Ship displays by "S" sign @see Cell#info to operate
 */
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
