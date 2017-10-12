package com.gmail.bicycle2life;

import java.util.ArrayList;
import java.util.Random;

/** Class for game field
 * @version 1.0
 */
public class GameTable {
    private int sizeRows;
    private int sizeColumns;
    private int maxShipSize;

    private Cell[][] gameGrid;
    private ArrayList<Ship> ships;

    /** Constructor creates new Game Table (game field) initialized by provided data
     * @param sizeRows - number of game field rows
     * @param sizeColumns - number of game field columns
     * @param maxShipSize - size of biggest ship. Biggest ship is only one. Smaller ships are bigger quantity
     */
    public GameTable(int sizeRows, int sizeColumns, int maxShipSize) {
        this.sizeRows = sizeRows;
        this.sizeColumns = sizeColumns;
        this.maxShipSize = maxShipSize;

        gameGrid = new Cell[sizeRows + 2][sizeColumns + 2];

        for(int i = 0; i < gameGrid.length; i++){
            for (int j = 0; j < gameGrid[i].length; j++){
                gameGrid[i][j] = new Cell();
            }
        }

        ships = new ArrayList<>();
    }

    /** Method Generate Ships to game field
     * Assumes biggest ship is only one. Quantity of the smallest ship equals to size of biggest ship
     */
    public void generateShips(){
        int positionRow;
        int positionColumn;
        int size;
        boolean isHorizontal;

        Random rnd = new Random();
        for (int i = maxShipSize; i > 0; i-- ){
            for (int j = 0; j <= maxShipSize - i; j++){
                do {
                    positionRow = rnd.nextInt(sizeRows -1) + 1;
                    positionColumn = rnd.nextInt(sizeColumns - 1) + 1;
                    isHorizontal = rnd.nextBoolean();
                    size = i;
                } while (! checkShipSpaceAvailable(positionRow, positionColumn, size, isHorizontal));
                ships.add(new Ship(positionRow, positionColumn, size, isHorizontal, gameGrid));
            }
        }
    }

    /** Method check it it's possible to create such kind of ship
     * Need to call it before creating Ship
     * @param positionRow - number of row to insert "head" of ship
     * @param positionColumn - number of column to insert "head" of ship
     * @param size - size of ship to insert
     * @param isHorizontal - describes if ship should be placed horizontally
     * @return returns true if space for creating ship is available
     */
    private boolean checkShipSpaceAvailable(int positionRow, int positionColumn, int size, boolean isHorizontal){
        boolean spaceAvailable = true;

        if (isHorizontal) {
            for (int i = positionColumn; i < positionColumn + size; i++) {
                if(positionColumn + size > gameGrid[0].length - 1 | !gameGrid[positionRow][i].isFree()){
                    spaceAvailable = false;
                    break;
                }
            }
        } else {
            for (int i = positionRow; i < positionRow + size; i++){
                if( positionRow + size > gameGrid.length - 1 | !gameGrid[i][positionColumn].isFree()){
                    spaceAvailable = false;
                    break;
                }
            }
        }

        return spaceAvailable;
    }

    /** Method display game field to users screen */
    public void printTable() {
        System.out.format("%2.2s", "");
        for (int i = 1; i <= sizeColumns; i++){
            System.out.format("%2.2s", (char)('A' + i - 1));
        }
        System.out.println();
        for (int i = 1; i <= sizeRows; i++){
            System.out.format("%2.2s" , i);
            for (int j = 1; j <= sizeColumns; j++){
                System.out.format("%2.2s", gameGrid[i][j]);
            }
            System.out.print(System.lineSeparator());
        }
    }

}
