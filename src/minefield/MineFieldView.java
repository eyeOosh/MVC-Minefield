package minefield;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;

public class MineFieldView extends View {

    Minefield minefield;
    private int dim, cellSize;
    private Cell cells[][];
    public MineFieldView(Minefield m) {
        super(m);
        this.minefield = m;
        dim = m.getDim();
        cells = new Cell[dim][dim];
        setLayout(new GridLayout(dim, dim));
        cellSize = 40;

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
    }

    public void draw(Graphics2D gc) {
        for (int y = 0; y < minefield.getDim(); y++) {
            for (int x = 0; x < minefield.getDim(); x++) {
                Cell cell = cells[x][y];
                gc.setColor(Color.GRAY);
                gc.fillRect(x * dim, y * cellSize, cellSize, cellSize);
                gc.setColor(Color.BLACK);
                gc.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
        // Draw the player
        gc.setColor(Color.GREEN);
        gc.fillRect(minefield.getPlayerX() * cellSize, minefield.getPlayerY() * cellSize, cellSize, cellSize);
    }
}
