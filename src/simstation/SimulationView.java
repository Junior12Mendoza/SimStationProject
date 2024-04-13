package simstation;

import mvc.*;

/**
 *
 * Edits:
 * Martin 4/11:
 * -In this file I inpelemented a method to draw each of the agents
 */
import java.awt.*;
import java.util.ArrayList;
public class SimulationView extends View{
    public SimulationView(Model model) {
        super(model);
        setPreferredSize(new Dimension(500, 500)); // Set preferred size of the view

        // Display each of the Agents in the Simulation
    }
    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Simulation sim = (Simulation) model; // Cast the model to Simulation

        ArrayList<Agent> agents = sim.getAgents(); // Get the list of agents from the simulation

        for (Agent agent : agents) {
            drawAgent(gc, agent); // Draw each agent
        }
    }
    private void drawAgent(Graphics gc, Agent agent) {
        // Example: Draw a circle for each agent at its position
        gc.setColor(Color.BLUE);
        gc.fillOval(agent.getXc(), agent.getYc(), 10, 10);
    }
}
