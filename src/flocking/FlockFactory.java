package flocking;

/**
 * Nathan 4/19:
 * wrote this file
 */

import mvc.*;
import simstation.*;

public class FlockFactory extends SimulationFactory {
    public Model makeModel() {
        return new FlockSimulation();
    }

    public String getTitle() {
        return "Flock Simulation";
    }

}
