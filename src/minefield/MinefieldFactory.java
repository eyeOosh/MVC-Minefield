package minefield;
//

import mvc.AppFactory;

public class MinefieldFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Minefield();
    }

    @Override
    public View makeView(Model m) {
        return new MinefieldView((Minefield) m);
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
    public Command makeEditCommand(Model model, String name, Object source) {
        if (name == "North")
            return new MoveCommand(model);
        else if (name == "South")
            return new MoveCommand(model);
        else if (name == "East")
            return new MoveCommand(model);
        else if (name == "West")
            return new MoveCommand(model);
        else if (name == "NorthEast")
            return new MoveCommand(model);
        else if (name == "NorthWest")
            return new MoveCommand(model);
        else if (name == "SouthEast")
            return new MoveCommand(model);
        else if (name == "SouthWest")
            return new MoveCommand(model);
    }
}
