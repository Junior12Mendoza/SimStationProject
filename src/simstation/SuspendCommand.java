package simstation;
import mvc.*;
/**
 *
 * Edits:
 * Martin 4/11:
 * -Implemented the Suspend command for the gui program which resumes the project
 */
public class SuspendCommand extends Command{
    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        simulation.suspend();
    }
}
