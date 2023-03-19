package minefield;

import mvc.Model;

public class Minefield extends Model {

    private Cell cells[][];

    public Minefield(int row, int col) {
        cells = new Cell[row][col];
    }

}
