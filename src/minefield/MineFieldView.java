package minefield;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MineFieldView extends View {

    Minefield m;
    private int dim, row, col;
    private Cell cells[][];
    public MineFieldView(Minefield m) {
        super(m);
        this.m = m;
        dim = m.getDim();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                MineSquare square = m.getSq(row, col);
                cells[row][col] = new Cell(square);
                cells[row][col].setText("?");
                //cells[r][c].sq = m.getSq(r, c);
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (cells[row][col].sq.isOccupied()) {
                    cells[row][col].setBackground(Color.RED);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    cells[row][col].setText("" + cells[row][col].sq.getNumMinesAround());
                }
                if (cells[row][col].sq.isGoal()) {
                    cells[row][col].setBackground(Color.GREEN);
                    cells[row][col].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                }
                this.add(cells[row][col]);
            }
        }

        //Command makeEditCommand
    }

    public void draw(Graphics2D gc) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (cells[i][j].getSq().isMined()) {
                    //cells[i][j].setText("" + cells[i][j].getSq().getNumMinesAround());

                }
            }
        }
    }
}
