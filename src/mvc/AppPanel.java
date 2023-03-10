package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {
    private AppFactory factory;
    private Model model = factory.makeModel();
    private View view = factory.makeView();
    private AppPanel.ControlPanel controls = new AppPanel.ControlPanel();

    public AppPanel() {
        this.setLayout(new GridLayout());

        add(controls);
        add(view);
        SafeFrame frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Save As", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }


    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        System.out.println(cmmd);
        try {
            switch (cmmd) {
                //File Functions
                case "Save As": {
                    String fName = Utilities.getFileName((String) null, false);
                    model.setFileName(fName);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }
                case "Save": {
                    if (model.getFileName()==null) {
                        String fName = Utilities.getFileName((String) null, false);
                        model.setFileName(fName);
                    }
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(model.getFileName()));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }
                case "Open": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        model.setFileName(fName);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        model = (Model) is.readObject();
                        view.setModel(model);
                        is.close();
                    }
                    break;
                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        model = factory.makeModel();
                        view.setModel(model);
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform(factory.about());
                    break;
                }

                case "Help": {
                    Utilities.inform(factory.getHelp());
                    break;
                }
                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    class ControlPanel extends JPanel {
        public ControlPanel() {
            setBackground(Color.PINK);
            //Container Panels
            JPanel northPanel = new JPanel();
            JPanel southPanel = new JPanel();
            JPanel headings = new JPanel();
            JPanel drawing = new JPanel();
            JPanel textField = new JPanel();
            //Actual Buttons
            JButton north = new JButton("North");
            JButton west = new JButton("West");
            JButton east = new JButton("East");
            JButton south = new JButton("South");
            JButton clear = new JButton("Clear");
            JButton pen = new JButton("Pen");
            JButton color = new JButton("Color");

            JLabel stepsLabel = new JLabel("# steps:");
            JTextField steps = new JTextField("10");
            steps.setPreferredSize(new Dimension(100, 20));

            //event listeners
            north.addActionListener(AppPanel.this);
            east.addActionListener(AppPanel.this);
            west.addActionListener(AppPanel.this);
            south.addActionListener(AppPanel.this);
            clear.addActionListener(AppPanel.this);
            pen.addActionListener(AppPanel.this);
            color.addActionListener(AppPanel.this);

            steps.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int steps;
                    try {
                        steps = Integer.parseInt(e.getActionCommand());
                        if (steps < 0) {
                            steps = 0;
                            stepError();
                        } else {
                            turtle.moveTurtle(steps);
                            System.out.println(steps);
                        }
                    } catch (Exception error) {
                        stepError();
                    }
                }
            });
            //Compose panels
            northPanel.add(north);
            headings.add(west);
            headings.add(east);
            southPanel.add(south);

            drawing.add(clear);
            drawing.add(pen);
            drawing.add(color);

            textField.add(stepsLabel);
            textField.add(steps);
            //Add panels
            add(northPanel);
            add(headings);
            add(southPanel);
            add(drawing);
            add(textField);
        }
    }

    public static void main(String[] args) {
        AppPanel app = new AppPanel();
    }
}