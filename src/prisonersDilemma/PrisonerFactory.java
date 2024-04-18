package prisonersDilemma;

import mvc.*;
import simstation.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the makeModel() and getTitle() methods
 *
 * - Junior 4/17
 * Added about()
 */

public class PrisonerFactory extends SimulationFactory {
    @Override
    public Model makeModel() { return new PrisonerSimulation(); }

    @Override
    public String getTitle() { return "Prisoner's Dilemma";}

    @Override
    public String about() {
        return "Prisoner's Dilemma 1.0 for CS151";
    }
}
