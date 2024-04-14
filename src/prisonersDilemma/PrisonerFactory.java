package prisonersDilemma;

import mvc.*;
import simstation.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the makeModel() and getTitle() methods
 */

public class PrisonerFactory extends SimulationFactory {
    public Model makeModel() { return new PrisonerSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma";}
}
