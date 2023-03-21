package minefield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class MineSquare {
    // width and height
    //int w, h;

    int x, y;

    // if it is mined
    // if it has a mine at this square
    private boolean isMined, hasMine;

    //private Rectangle2D.Double mine;

    // number of adjacent mines
    private String numMines;

    private boolean occupied;

    private Random random;

    //private JLabel text;

    private boolean goal;
    private int numMinesAround;

    public MineSquare() {
        isMined = false;
        random = new Random();
        hasMine = (random.nextDouble(0, 1) < 0.2);
        goal = false;
        //revealed = false;

        //mine = new Rectangle2D.Double(x, y, w, h);
        //numMines = "?";
        //text = new JLabel(numMines);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMined() {
        return isMined;
    }

    // revealed
    public void setMined(boolean mined) {
        isMined = mined;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isGoal() {
        return goal;
    }

    public void setGoal() {
        goal = true;
    }

    public int getNumMinesAround() {
        return numMinesAround;
    }

    public void setNumMinesAround(int numMinesAround) {
        this.numMinesAround = numMinesAround;
    }
}
