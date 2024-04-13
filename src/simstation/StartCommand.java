package simstation;
import mvc.*;
/**
 *
 * Edits:
 * Martin 4/11:
 * -Implemented the Start command for the gui program which resumes the project
 */
public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        simulation.start();
    }
}
