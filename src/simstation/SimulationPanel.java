package simstation;

import java.awt.*;
import javax.swing.*;
import mvc.*;

public class SimulationPanel extends AppPanel {
    private JButton resume;
    private JButton start;
    private JButton stats;
    private JButton stop;
    private JButton suspend;
    public SimulationPanel(AppFactory factory) {
        super(factory);
        start = new JButton("Start");
        start.addActionListener(this);
        controlPanel.add(start);

        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        controlPanel.add(suspend);

        resume = new JButton("Resume");
        resume.addActionListener(this);
        controlPanel.add(resume);

        stop = new JButton("Stop");
        stop.addActionListener(this);
        controlPanel.add(stop);

        stats = new JButton("Stats");
        stats.addActionListener(this);
        controlPanel.add(stats);
    }

    public static void main(String[] args){
        AppFactory factory= new SimulationFactory();
        AppPanel panel=new SimulationPanel(factory);
        panel.display();
    }
}
