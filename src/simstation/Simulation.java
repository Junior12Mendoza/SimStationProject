package simstation;
/**
 *
 * Edits:
 * Martin 4/11:
 * -In this file I created the run method to increment the clock in the agent loop and to sleep for 20 milliseconds
 */
import mvc.*;

import java.util.ArrayList;

public class Simulation extends Model {
    int clock = 0;
    ArrayList<Agent> agents = new ArrayList<>();

    public Simulation() {

    }

    public void start() {
        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).start();
        }
    }

    public void suspend() {
        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).suspend();
        }
    }

    public void resume() {
        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).resume();
        }
    }

    public void stop() {
        for (int i = 0; i < agents.size(); i++) {
            agents.get(i).stop();
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
        return null;
    }

    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Agent());
    }

    public void addAgent(Agent a){
        agents.add(a);
    }


}
