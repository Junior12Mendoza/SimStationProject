package prisonersDilemma;

import mvc.*;
import simstation.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the main method and populate()
 */

public class PrisonerSimulation extends Simulation {
    public void populate() {
        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner("Cheat"));

        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner("Cooperate"));

        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner("Random"));

        for(int i = 0; i < 10; i++)
            addAgent(new Prisoner("Tit4Tat"));
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
