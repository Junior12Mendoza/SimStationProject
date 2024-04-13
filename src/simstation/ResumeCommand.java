package simstation;
import mvc.*;
/**
 *
 * Edits:
 * Martin 4/11:
 * -Implemented the resume command for the gui program which resumes the project
 */

public class ResumeCommand extends Command {

    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        simulation.resume();
    }
}
