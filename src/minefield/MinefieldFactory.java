package minefield;
//

import mvc.AppFactory;
import mvc.*;


public class MinefieldFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Minefield(20);
    }

    @Override
    public View makeView(Model m) {
        return new MineFieldView((Minefield) m);
    }

    @Override
    public String getTitle() {
        return "Minefield Project Team 4";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Click on a button to move in that direction."};
    }

    @Override
    public String about() {
        return "CS151 Minefield Project Team 4";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"North", "South", "East", "West", "NorthEast", "NorthWest", "SouthEast", "SouthWest"};
    }

    @Override
    public Command makeEditCommand(Model model, String name, Object source) throws Exception {
        if (name == "N")
            return new MoveCommand(model, Heading.NORTH);
        else if (name == "S")
            return new MoveCommand(model, Heading.SOUTH);
        else if (name == "E")
            return new MoveCommand(model, Heading.EAST);
        else if (name == "W")
            return new MoveCommand(model, Heading.WEST);
        else if (name == "NE")
            return new MoveCommand(model, Heading.NORTHEAST);
        else if (name == "NW")
            return new MoveCommand(model, Heading.NORTHWEST);
        else if (name == "SE")
            return new MoveCommand(model, Heading.SOUTHEAST);
        else if (name == "SW")
            return new MoveCommand(model, Heading.SOUTHWEST);
        else
            throw new Exception();
    }
}
