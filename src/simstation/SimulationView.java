package simstation;

import mvc.*;

/**
 *
 * Edits:
 * Martin 4/11:
 * -In this file I implemented a method to draw each of the agents
 *
 * Nathan 4/19:
 * AppPanel sets the window size to to 500x x 300y
 * Changes:
 * paintComponent: Draw a square inside SimulationView that is the largest square that fits inside of it
 * update: Get the new size the square needs to be
 * drawAgent: Draw the agents inside this square with their position relative to this size
 *
 */

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class SimulationView extends View {
    public SimulationView(Model model) {
        super(model);

        setBackground(Color.WHITE);

        //setPreferredSize(new Dimension(500, 500)); // Set preferred size of the view
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        int size = Math.min(getWidth(), getHeight());
        gc.setColor(Color.LIGHT_GRAY);
        gc.fillRect((getWidth() - size) / 2, (getHeight() - size) / 2, size, size);

        Simulation sim = (Simulation) model; // Cast the model to Simulation
        ArrayList<Agent> agents = sim.getAgents(); // Get the list of agents from the simulation

        for (Agent agent : agents) {
            drawAgent(gc, agent, size, (getWidth() - size) / 2, (getHeight() - size) / 2); // Draw each agent
        }
    }

    public void update() {
        //Junior's MVC View doesn't call revalidate so I can't just call super.update();
        this.repaint();
        this.revalidate();
    }

    private void drawAgent(Graphics gc, Agent agent, int size, int xOff, int yOff) {
        // Example: Draw a circle for each agent at its position
        gc.setColor(Color.WHITE);
        gc.fillOval((agent.getXc() * size / 500) + xOff, (agent.getYc() * size / 500) + yOff, 10, 10);
    }
}
