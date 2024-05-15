package simstation;

/**
 *
 * Edits:
 * Martin 4/11:
 * -In this file I created the run method to increment the clock in the agent loop and to sleep for 20 milliseconds
 *
 * Junior 4/13:
 * Implemented getNeighbor() and the default constructor
 *
 * Nathan 4/18:
 * Added Juniors fix for agent's world being null, looping through all agents in Simulation() constructor
 * Added Pearce's methods for real-time clock
 * changed start, stop, suspend, resume to include new clock, removed it from agent run() loop
 *
 * Nathan 4/19:
 * bug: running a simulation then pressing New then pressing Stop --> timer is null, cannot call stop
 * fix: move timer = new Timer() from startTimer() to the constructor
 * bug: pressing New doesn't start a new timer
 * fix: call startTimer when a new model is created
 *
 */
import mvc.*;
import java.util.*;

import java.util.ArrayList;

public class Simulation extends Model {
    private int clock = 0;
    public ArrayList<Agent> agents;

    transient private Timer timer; // timers aren't serializable

    public Simulation() {
        agents = new ArrayList<>();
        populate();
        for (Agent a : agents){
            a.world = this;
        }
        timer = new Timer();
    }

    public void start() {
        for (Agent agent : agents) {
            agent.start();
        }
        startTimer();
    }

    public void suspend() {
        for (Agent agent : agents) {
            agent.suspend();
        }
        stopTimer();
    }

    public void resume() {
        for (Agent agent : agents) {
            agent.resume();
        }
        startTimer();
    }

    public void stop() {
        for (Agent agent : agents) {
            agent.stop();
        }
        stopTimer();
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public int getTime() {
        return clock;
    }

    public Timer getTimer() {
        return timer;
    }

    public int getNumAgents() {
        return agents.size();
    }

    // commented out by Nathan: matching UML. instead following his hints
    // https://www.cs.sjsu.edu/faculty/pearce/modules/projects/ood/simStation/Simulation.java
//    public void incrementClock() {
//        clock++;
//    }

    // from Pearce
    public void startTimer() {	//originally was private
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    public void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

    public Agent getNeighbor(Agent agent, int radius) {
        int viewSize = 500;

        int minx = (agent.xc - radius + viewSize) % viewSize;
        int maxx = (agent.xc + radius + viewSize) % viewSize;
        int miny = (agent.yc - radius + viewSize) % viewSize;
        int maxy = (agent.yc + radius + viewSize) % viewSize;

        int startPos = Utilities.rng.nextInt(agents.size());

        // If anyone can make this look any better, please do LMAO
        for (int i = 0; i < agents.size(); i++) {
            int index = (i + startPos) % agents.size();

            if (minx < maxx && miny < maxy && agents.get(index).xc > minx && agents.get(index).xc < maxx
                    && agents.get(index).yc > miny && agents.get(index).yc < maxy) {
                return agents.get(index);
            } else if (minx > maxx && miny < maxy && agents.get(index).yc > miny && agents.get(index).yc < maxy
                    && (agents.get(index).xc > minx || agents.get(index).xc < maxx)) {
                return agents.get(index);
            } else if (minx < maxx && miny > maxy && agents.get(index).xc > minx && agents.get(index).xc < maxx
                    && (agents.get(index).yc > miny || agents.get(index).yc < maxy)) {
                return agents.get(index);
            } else if (minx > maxx && miny > maxy && (agents.get(index).xc > minx || agents.get(index).xc < maxx)
                    && (agents.get(index).yc > miny || agents.get(index).yc < maxy)) {
                return agents.get(index);
            }
        }
        return null;
    }

    public String getStats() {
        StringBuilder stats = new StringBuilder();
        stats.append("Clock= ").append(clock).append(" seconds\n");
        stats.append("#agents= ").append(getNumAgents()).append("\n");
        // Add more statistics if needed
        return stats.toString();
    }

    // Each extension of simstation should override This
    public void populate() {
    }

    public void addAgent(Agent a) {
        agents.add(a);

    }
}
