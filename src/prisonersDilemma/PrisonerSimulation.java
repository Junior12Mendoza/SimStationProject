package prisonersDilemma;

import mvc.*;
import simstation.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the main method and populate()
 *
 * - Junior 4/17
 * Added Override for getStats() to show relevant info also added "add.setWorld(this);"
 * to populate() so that the prisoners would actually move
 */

public class PrisonerSimulation extends Simulation {
    public void populate() {
        for(int i = 0; i < 10; i++) {
            Prisoner add = new Prisoner("Cheat");
            add.setWorld(this);
            addAgent(add);
        }

        for(int i = 0; i < 10; i++){
            Prisoner add = new Prisoner("Cooperate");
            add.setWorld(this);
            addAgent(add);
        }

        for(int i = 0; i < 10; i++){
            Prisoner add = new Prisoner("Random");
            add.setWorld(this);
            addAgent(add);
        }

        for(int i = 0; i < 10; i++) {
            Prisoner add = new Prisoner("Tit4Tat");
            add.setWorld(this);
            addAgent(add);
        }
    }

    @Override
    public String getStats() {
        StringBuilder stats = new StringBuilder();
        for(int i = 1; i <= agents.size(); i++){
            Prisoner currentPrisoner = (Prisoner)agents.get(i - 1);
            stats.append("Prisoner " + i + ": Strategy = " + currentPrisoner.strategy + ", Fitness = " + currentPrisoner.fitness + "       ");
            if(i % 2 == 0)
                stats.append("\n");
        }
        return stats.toString();
}

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
