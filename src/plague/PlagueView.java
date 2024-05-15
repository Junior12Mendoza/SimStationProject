package plague;

import mvc.Model;
import mvc.View;
import mvc.*;
import java.awt.*;
import java.util.ArrayList;
import simstation.*;

/**
 *
 * Edits Martin 4/16 In this file I override the paint component method to get
 * the color for each of the agents. This method has a for loop to iterate each
 *
 * Nathan 4/19:
 * added live adjusting so all agents are drawn in a square centered in the original frame
 */

public class PlagueView extends View {
    public PlagueView(Model model) {
        super(model);
        //setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        //added by Nathan
        int size = Math.min(getWidth(), getHeight());
        gc.setColor(Color.LIGHT_GRAY);
        gc.fillRect((getWidth() - size) / 2, (getHeight() - size) / 2, size, size);

        PlagueSimulation sim = (PlagueSimulation) model;
        ArrayList<Plague> agents = sim.getPlagueAgents();

        for (Plague agent : agents) {
            // Render each agent based on its state (infected or not)

            Color agentColor;

            if (agent.isInfected()) {
                //gc.setColor(Color.RED);
                agentColor = Color.RED;
            } else {
                //gc.setColor(Color.GREEN);
                agentColor = Color.GREEN;
            }
            // Draw the agent
            //gc.fillRect(agent.getXc(), agent.getYc(), 10, 10);

            //added by Nathan
            drawAgent(gc, agent, size, (getWidth() - size) / 2, (getHeight() - size) / 2, agentColor);
        }
    }

    public void update(Model model) {
        //changed by Nathan
        // Repaint the view when the model updates (e.g., when the infection status
        // changes)
        // repaint();
        super.update();
    }

    //added by Nathan
    private void drawAgent(Graphics gc, Agent agent, int size, int xOff, int yOff, Color color) {
        // Example: Draw a circle for each agent at its position
        gc.setColor(color);
        gc.fillRect((agent.getXc() * size / 500) + xOff, (agent.getYc() * size / 500) + yOff, 10, 10);
    }

}