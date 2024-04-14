package simstation;

import mvc.*;

import java.io.Serializable;
/**
 *
 * Edits:
 * -Martin 4/10:
 * I created a constructor to initialize the heading variable, a getter and setter method
 *
 * -Martin 4/11:
 * -I created the code for the run method which define the behavior of the agent
 * when it is executed in its own thread and sleep for 20 millisecond(I think that the right time)
 *
 * -Junior 4/12:
 * Made update() abstract and implemented the move() method (Also made each agent start in a random position)
 */

public abstract class Agent implements Serializable, Runnable {
    protected String name;
    protected int xc = Utilities.rng.nextInt(500);
    protected int yc = Utilities.rng.nextInt(500);
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

    public abstract void update();

    public void move(int steps){
        int viewSize = 500;

        if(heading == Heading.NORTH){
            yc = (yc + steps) % viewSize;
        }
        else if(heading == Heading.WEST){
            xc = (xc - steps + viewSize) % viewSize;
        }
        else if(heading == Heading.EAST){
            xc = (xc + steps) % viewSize;
        }
        else if(heading == Heading.SOUTH){
            yc = (yc - steps + viewSize) % viewSize;
        }
    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }
}
