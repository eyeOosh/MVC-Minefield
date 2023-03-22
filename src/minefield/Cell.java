package minefield;

import javax.swing.*;

public class Cell extends JLabel {

    public MineSquare sq;

    public Cell(MineSquare sq) {
        this.sq = sq;
    }

    public MineSquare getSq() {
        return sq;
    }
}
