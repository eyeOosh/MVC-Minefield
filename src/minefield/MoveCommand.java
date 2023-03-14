package minefield;

import mvc.*;
//100% of this class was written by Danny Matlob
class MoveCommand extends Command {
    Heading heading;
    public MoveCommand(Model m, Heading h) {
        super(m);
        heading = h;
    }

}