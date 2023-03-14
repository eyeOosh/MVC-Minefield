package minefield;

import javax.swing.*;
import java.awt.*;
import mvc.*;

public class MinefieldPanel extends appPanel {
    private static final long serialVersionUID = 1L;
    private Jbutton NW;
    private Jbutton N;
    private Jbutton NE;
    private Jbutton W;
    private Jbutton E;
    private Jbutton SW;
    private Jbutton S;
    private Jbutton SE;


    public MinefieldPanel(AppFactory factory) {

        super(factory);
        NW = new JButton("NW");
        NW.addActionListener(this);
        cp.add(NW);

        N = new JButton("N");
        N.addActionListener(this);
        cp.add(N);

        NE = new JButton("NE");
        NE.addActionListener(this);
        cp.add(NE);

        W = new JButton("W");
        W.addActionListener(this);
        cp.add(W);

        E = new JButton("E");
        E.addActionListener(this);
        cp.add(E);

        SW = new JButton("SW");
        SW.addActionListener(this);
        cp.add(SW);

        S = new JButton("S");
        S.addActionListener(this);
        cp.add(S);

        SE = new JButton("SE");
        SE.addActionListener(this);
        cp.add(SE);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }
}
