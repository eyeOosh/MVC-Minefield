package minefield;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {

    Minefield m;
    private int dim, row, col;
    private Cell cells[][];
    public MineFieldView(Minefield m, int dimension, int row, int col) {
        super(m);
        this.m = m;
        dim = dimension;
        cells = new Cell[row][col];
    }

    public void draw(Graphics2D gc) {
        setLayout(new GridLayout(dim, dim));
        for (int r = 0; r < dim; r++) {
            for (int c = 0; c < dim; c++) {
                cells[r][c] = new Cell();
                cells[r][c].setText("?");
                //cells[r][c].sq = m.getSq(r, c);
                cells[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (cells[r][c].sq.isOccupied()) {
                    cells[r][c].setBackground(Color.RED);
                    cells[r][c].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    cells[r][c].setText("" + cells[r][c].sq.getNumMinesAround());
                }
                if (cells[r][c].sq.isGoal()) {
                    cells[r][c].setBackground(Color.GREEN);
                    cells[r][c].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                }
                this.add(cells[r][c]);
            }
        }

    }
}
