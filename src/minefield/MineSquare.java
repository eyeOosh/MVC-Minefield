package minefield;

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

    public MineSquare(int x, int y, int w, int h, boolean isMined, boolean hasMine) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.isMined = isMined;
        this.hasMine = hasMine;
        mine = new Rectangle2D.Double(x, y, w, h);
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

    public void draw(Graphics2D gc) {
        Color oldColor = gc.getColor();
        gc.setColor(Color.GRAY);
        gc.draw(mine);
    }

}
