package com.gmail.bicycle2life;

public class Ship {
    private Cell[] body;
    private int positionRow;
    private int positionColumn;
    private int size;
    private boolean isHorizontal;
    private String name;

    public Ship(int positionRow, int positionColumn, int size, boolean isHorizontal, Cell[][] grid){
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
        this.size = size;
        this.isHorizontal = isHorizontal;

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
                name = "unknown";
                break;
        }

        body = new Cell[size];

        int idx = 0;
        if (isHorizontal) {
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

}
