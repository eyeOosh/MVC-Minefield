package minefield;

import mvc.Model;

public class Minefield extends Model {

    // 2d array of patches/squares
    private MineSquare sq[][];

    // pX = player X, pY = player Y
    private int dim, pX, pY;
    int width, height;

    public Minefield(int dim) {
        // dimensions
        sq = new MineSquare[dim][dim];
        this.dim = dim;
        // sets adjacent mines
        setAdjMines();
        // sets goal mine to be bottom right
        sq[dim][dim].setGoal();

        // initializes player x and y to 0
        pX = 0;
        pY = 0;
        // set the top left square to be both mined and occupied
        sq[pX][pY].setOccupied(true);
        sq[pX][pY].setMined(true);
        sq[pX][pY].setHasMine(false);
    }

    public int getDim() {
        return dim;
    }

    public MineSquare getSq(int row, int col) {
        return sq[row][col];
    }

    private void setAdjMines () {
        for (int i = 0; i < sq.length; i ++) {
            for (int j = 0; j < sq[j].length; j++) {
                if (sq[i][j].hasMine()) {
                    continue;
                }

                int count = 0;

                for (int ii = Math.max(0, i - 1); ii <= Math.min(sq.length - 1, i + 1); ii++) {
                    for (int jj = Math.max(0, j - 1); jj <= Math.min(sq[j].length - 1, j + 1); jj++) {
                        if (ii == i && jj == j) {
                            continue;
                        }

                        if (sq[ii][jj].hasMine()) {
                            count++;
                        }
                    }
                }

                // set the num of mines around to count
                sq[i][j].setNumMinesAround(count);
            }
        }

    }

    public int getPlayerX() {
        return pX;
    }

    public int getPlayerY() {
        return pY;
    }

    // add methods here
    public void movePlayer(int moveX, int moveY) throws Exception{
        int newX = pX + moveX;
        int newY = pY+ moveY;

        MineSquare newSq = sq[newX][newY];
        newSq.setMined(true);
        if (newSq.hasMine()) {
            throw new Exception("Mine blown! Game End!");
        }

        if (newX < 0 || newY < 0 || newX > dim || newY > dim) {
            throw new Exception("Out of bounds! Game End!");
        }

        pX = newX;
        pY = newY;
    }



}
