package minefield;

import mvc.*;

class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model m, Heading h) {
        super(m);
        heading = h;
    }

}