package com.gmail.bicycle2life;

import java.util.Arrays;

/** Class for Ships items
  * @version 1.0
 */
public class Ship {
    private Cell[] body;
    private int positionRow;
    private int positionColumn;
    private int size;
    private boolean horizontal;
    private String name;

    public Ship() {
    }

    /** Constructor creates new Ship initialized by provided and checked data
     * @param positionRow - number of row to insert "head" of ship
     * @param positionColumn - number of column to insert "head" of ship
     * @param size - size of ship to insert
     * @param horizontal - describes if ship should be placed horizontally
     * @param grid - game table which is array of {@link Cell} items. Each ship mark itself to appropriate Cells were it placed
     */
    public Ship(int positionRow, int positionColumn, int size, boolean horizontal, Cell[][] grid){
        super();
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.size = size;
        this.horizontal = horizontal;

        initData(positionRow, positionColumn, size, horizontal, grid);
    }

    private final void initData(int positionRow, int positionColumn, int size, boolean horizontal, Cell[][] grid){
        switch (size){
            case 1:
                name = "single-decker";
                break;
            case 2:
                name = "double-decker";
                break;
            case 3:
                name = "three-decker";
                break;
            case 4:
                name = "four-decker";
                break;
            default:
                name = "five-decker or bigger";
                break;
        }

        body = new Cell[size];

        int idx = 0;
        if (horizontal) {
            for (int i = positionColumn; i < positionColumn + size; i++){
                grid[positionRow][i].setShip(this);
                body[idx] = grid[positionRow][i];

                grid[positionRow - 1][i].setFree(false);    //to top
                grid[positionRow + 1][i].setFree(false);    //to bottom

                idx++;
            }
            grid[positionRow][positionColumn - 1].setFree(false);   //to left
            grid[positionRow][positionColumn + size].setFree(false);    //to right
            grid[positionRow - 1][positionColumn - 1].setFree(false);   //to top-left
            grid[positionRow + 1][positionColumn - 1].setFree(false);   //to bottom-left
            grid[positionRow - 1][positionColumn + size].setFree(false);   //to top-right
            grid[positionRow + 1][positionColumn + size].setFree(false);   //to bottom-right

        } else {
            for (int i = positionRow; i < positionRow + size; i++){
                grid[i][positionColumn].setShip(this);
                body[idx] = grid[i][positionColumn];

                grid[i][positionColumn - 1].setFree(false);    //to left
                grid[i][positionColumn + 1].setFree(false);    //to right

                idx++;
            }
            grid[positionRow - 1][positionColumn - 1].setFree(false);   //to top-left
            grid[positionRow - 1][positionColumn + 1].setFree(false);   //to top-right
            grid[positionRow - 1][positionColumn].setFree(false);   //to top center
            grid[positionRow + size][positionColumn - 1].setFree(false);   //to bottom-left
            grid[positionRow + size][positionColumn].setFree(false);    //to bottom center
            grid[positionRow + size][positionColumn + 1].setFree(false);    //to bottom right
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (positionRow != ship.positionRow) return false;
        if (positionColumn != ship.positionColumn) return false;
        if (size != ship.size) return false;
        if (horizontal != ship.horizontal) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        // Changed to deepEquals instead
        if (!Arrays.deepEquals(body, ship.body)) return false;
        return name != null ? name.equals(ship.name) : ship.name == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(body);
        result = 31 * result + positionRow;
        result = 31 * result + positionColumn;
        result = 31 * result + size;
        result = 31 * result + (horizontal ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
