package minefield;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class MineFieldView extends View {

    Model m;
    private int dim, row, col;
    private Cell cells[][];
    public MineFieldView(Model m, int dimension, int row, int col) {
        super(m);
        this.m = m;
        dim = dimension;
        cells = new Cell[row][col];
    }

    public void draw(Graphics2D gc) {
        setLayout(new GridLayout(dim, dim));

    }
}
