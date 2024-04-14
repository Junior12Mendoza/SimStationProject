package simstation;
/**
 *
 * Edits:
 * Martin 4/11:
 * -In this file I created the run method to increment the clock in the agent loop and to sleep for 20 milliseconds
 *
 * Junior 4/13:
 * Implemented getNeighbor() and the default constructor
 */
import mvc.*;

import java.util.ArrayList;

public class Simulation extends Model {
    int clock = 0;
    ArrayList<Agent> agents;

    public Simulation() {
        agents = new ArrayList<>();
        populate();
    }

    public void start() {
        for (Agent agent : agents) {
            agent.start();
        }
    }

    public void suspend() {
        for (Agent agent : agents) {
            agent.suspend();
        }
    }

    public void resume() {
        for (Agent agent : agents) {
            agent.resume();
        }
    }

    public void stop() {
        for (Agent agent : agents) {
            agent.stop();
        }
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public int getTime() {
        return clock;
    }

    public int getNumAgents() {
        return agents.size();
    }

    public void incrementClock() {
        clock++;
    }
    public Agent getNeighbor(Agent agent, int radius) {
        int viewSize = 500;

        int minx = (agent.xc - radius + viewSize) % viewSize;
        int maxx = (agent.xc + radius + viewSize) % viewSize;
        int miny = (agent.yc - radius + viewSize) % viewSize;
        int maxy = (agent.yc + radius + viewSize) % viewSize;

        int startPos = Utilities.rng.nextInt(agents.size());

        // If anyone can make this look any better, please do LMAO
        for(int i = 0; i < agents.size(); i++){
            int index = (i + startPos) % viewSize;

            if (minx < maxx && miny < maxy && agents.get(index).xc > minx && agents.get(index).xc < maxx && agents.get(index).yc > miny && agents.get(index).yc < maxy){
                return agents.get(index);
            }
            else if (minx > maxx && miny < maxy && agents.get(index).yc > miny && agents.get(index).yc < maxy && (agents.get(index).xc > minx || agents.get(index).xc < maxx)){
                return agents.get(index);
            }
            else if (minx < maxx && miny > maxy && agents.get(index).xc > minx && agents.get(index).xc < maxx && (agents.get(index).yc > miny || agents.get(index).yc < maxy)){
                return agents.get(index);
            }
            else if (minx > maxx && miny > maxy && (agents.get(index).xc > minx || agents.get(index).xc < maxx) && (agents.get(index).yc > miny || agents.get(index).yc < maxy)){
                return agents.get(index);
            }
        }
        return null;
    }

    // Each extension of simstation should override This
    public void populate() {}

    public void addAgent(Agent a){
        agents.add(a);
    }
}
