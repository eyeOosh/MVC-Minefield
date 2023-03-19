package minefield;

import mvc.Model;

public class Minefield extends Model {

    private MineSquare sq[][];
    private int dim;

    public Minefield(int dim) {
        sq = new MineSquare[dim][dim];
        this.dim = dim;
        setMines(sq);
    }

    public int getDim() {
        return dim;
    }

    public MineSquare getSq(int row, int col) {
        return sq[row][col];
    }

    private void setMines(MineSquare[][] squares) {
        for (int row = 0; row < sq.length; row ++) {
            for (int col = 0; col < sq[row].length; col++) {
                MineSquare mineSquare = new MineSquare();
            }
        }
    }



}
