package simstation;

import mvc.*;

import java.io.Serializable;
/**
 *
 * Edits:
 * -Martin 4/10:
 * I created a constructor to initalize the heading variable, a getter and setter method
 *
 * -Martin 4/11:
 * -I created the code for the run method which define the behavior of the agent
 * when it is executued in its own thread and sleep for 20 milisecond(I think that the right time)
 */

public class Agent implements Serializable, Runnable {
    protected String name;
    protected int xc, yc;
    protected boolean suspended = false;
    protected boolean stopped = false;
    transient protected Thread myThread;
    protected Simulation world;

    protected Heading heading;

    public Agent(){
        this.heading=Heading.random();
    }

    public Heading getHeading(){
        return heading;
    }

    public void setHeading(Heading heading){
        this.heading=heading;
    }
    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                update();
                world.incrementClock(); // Increment clock in each agent's update loop
            }
            try {
                Thread.sleep(20); // Sleep for 20 milliseconds for smooth graphics
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        myThread = new Thread(this);
        myThread.start();

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

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }
}
