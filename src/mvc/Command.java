package mvc;

public class Command {

    protected Model model;
    public Command(Model m) {
        model = m;
    }
    public void execute() throws Exception{}
}
