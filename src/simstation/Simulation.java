package simstation;

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
