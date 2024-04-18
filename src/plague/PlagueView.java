package plague;

import mvc.Model;
import mvc.View;
import mvc.*;
import java.awt.*;
import java.util.ArrayList;
import simstation.*;

/**
 *
 *Edits
 * Martin 4/16
 * In this file I override the paint component method to get the color for
 * each of the agents. This method has a for loop to iterate each
 */

public class PlagueView extends View {
    public PlagueView(Model model) {
        super(model);
        setPreferredSize(new Dimension(500, 500));

    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        PlagueSimulation sim = (PlagueSimulation) model;
        ArrayList<Plague> agents =sim.getPlagueAgents();
        for (Plague agent : agents) {
            // Render each agent based on its state (infected or not)
            if (agent.isInfected()) {
                gc.setColor(Color.RED);
            } else {
                gc.setColor(Color.GREEN);
            }
            // Draw the agent
            gc.fillRect(agent.getXc(), agent.getYc(), 10, 10);
        }
    }
}