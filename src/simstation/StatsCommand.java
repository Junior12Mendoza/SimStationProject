package simstation;
import mvc.*;
/**
 *
 * Edits:
 * Martin 4/11:
 * -Implemented the Stats command for the gui program which resumes the project
 *
 * Junior 4/17
 * - Added statement Utilities.inform(stats) so that stats would appear in a popup menu
 */
public class StatsCommand extends Command {
    public StatsCommand(Model model){
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        String stats = simulation.getStats();
        Utilities.inform(stats);
    }
}
