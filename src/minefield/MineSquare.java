package minefield;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MineSquare {
    // width and height
    int w, h;

    int x, y;

    // if it is mined
    // if it has a mine at this square
    boolean isMined, hasMine;

    private Rectangle2D.Double mine;

    // number of adjacent mines
    private char numMines;

    private JTextArea text;

    public MineSquare(int x, int y, int w, int h, boolean isMined, boolean hasMine) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isMined = isMined;
        this.hasMine = hasMine;
        mine = new Rectangle2D.Double(x, y, w, h);
        numMines = '?';
        text = new JTextArea(String.valueOf(numMines));
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

    public char getNumMines() {
        return numMines;
    }

    public void draw(Graphics2D gc) {
        Color oldColor = gc.getColor();
        gc.setColor(Color.GRAY);
        gc.draw(mine);
        gc.draw();
    }

}
