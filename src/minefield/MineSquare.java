package minefield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class MineSquare {
    // width and height
    int w, h;

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

    public MineSquare() {
        isMined = false;
        random = new Random();
        hasMine = (random.nextDouble(0, 1) < 0.2);

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

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public boolean isMined() {
        return isMined;
    }

    public void setMined(boolean mined) {
        isMined = mined;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void draw(Graphics2D gc) {

    }

}
