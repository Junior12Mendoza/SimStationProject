package plague;

import simstation.Simulation;
import mvc.*;
import simstation.*;

import java.util.ArrayList;

/**
 *
 * Edits:
 * Martin Ceballos 4/16
 *
 *
 */


public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    @Override
    public void populate() {
        // Populate the simulation with Plague agents
        int numAgents=50;
        for (int i = 0; i < numAgents; i++) {
            Plague plagueAgent = new Plague();
            // Determine if the agent should be infected based on VIRULENCE
            if (Utilities.rng.nextInt(100) < VIRULENCE) {
                // Determine if the agent can resist infection based on RESISTANCE
                if (Utilities.rng.nextInt(100) < RESISTANCE) {
                    plagueAgent.infect();
                }
            }
            // Add the agent to the simulation
            addAgent(plagueAgent);
            //Set the world refrence for the agent
            plagueAgent.setWorld(this);
        }

    }
    // Rename the method to avoid clash
    public ArrayList<Plague> getPlagueAgents() {
        ArrayList<Plague> plagueAgents = new ArrayList<>();
        for (Agent agent : agents) {
            plagueAgents.add((Plague) agent);
        }
        return plagueAgents;
    }

    public ArrayList<Plague> getNeighborPlagueAgents(Plague agent, int radius) {
        // Iterate through all agents in the simulation

        ArrayList<Plague> neighbors = new ArrayList<>();
        for (Agent a : getAgents()) {
            // Exclude the provided agent from consideration

            if (a != agent) {
                // Calculate the distance between the provided agent and the current agent

                int distance = calculateDistance(agent, (Plague) a);
                // If the distance is within the specified radius, add the current agent to the list of neighbors

                if (distance <= radius) {
                    neighbors.add((Plague) a);
                }
            }
        }
        return neighbors;
    }

    @Override
    public String getStats() {
        // Get statistics from the superclass (if any)

        StringBuilder stats = new StringBuilder(super.getStats());
        int numInfected = 0;
        // Iterate through all plague agents in the simulation

        for (Plague agent : getPlagueAgents()) {
            // If the current agent is infected, increment the count of infected agents

            if (agent.isInfected()) {
                numInfected++;
            }
        }
        // Calculate the percentage of infected agents and append it to the statistics

        stats.append("%infected= ").append((double) numInfected / getNumAgents() * 100).append("\n");
        return stats.toString();
    }

    private int calculateDistance(Plague agent1, Plague agent2) {
        // Calculate the differences in coordinates between the two agents

        int dx = agent1.getXc() - agent2.getXc();
        int dy = agent1.getYc() - agent2.getYc();
        // Calculate and return the Euclidean distance

        return (int) Math.sqrt(dx * dx + dy * dy);
    }
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
