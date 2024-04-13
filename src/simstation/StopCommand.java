package simstation;
import mvc.*;
/**
 *
 * Edits:
 * Martin 4/11:
 * -Implemented the Stop command for the gui program which resumes the project
 */
public class StopCommand extends Command{
    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        simulation.stop();
    }
}
