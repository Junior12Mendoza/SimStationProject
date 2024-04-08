package simstation;

import mvc.*;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {
    protected String name;
    protected int xc, yc;
    protected boolean suspended = false;
    protected boolean stopped = false;
    transient protected Thread myThread;
    protected Simulation world;


    @Override
    public void run() {

    }

    public void start(){

    }

    public void suspend(){
        suspended = true;
    }

    public void stop(){
        stopped = true;
    }

    public void resume(){
        suspended = false;
    }

    public void update(){

    }

    public void move(int steps){

    }
}
