package flocking;

/**
 * Nathan 4/19:
 * wrote this file
 */

import mvc.*;
import simstation.*;

public class FlockSimulation extends Simulation {

    public void populate() {
        for (int i = 0; i < 30; i++)
            addAgent(new Bird());
    }

    @Override
    public String getStats() {
        StringBuilder stats = new StringBuilder();
        stats.append("total birds: " + agents.size() + "\n");

        int[] speeds = new int[6]; //5 + 1, ignore [0]

        for (Agent a : agents) {
            Bird b = (Bird)a;
            speeds[b.getSpeed()]++;
        }

        for (int i = 1; i <= 5; i++) {
            stats.append("# of birds at speed " + i + ": " + speeds[i] + "\n");
        }

        stats.append("\n");

        return stats.toString();
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockFactory());
        panel.display();
    }

}