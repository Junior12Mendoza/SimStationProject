package simstation;

import mvc.*;

import java.io.Serializable;

/**
 *
 * Edits: -Martin 4/10: I created a constructor to initialize the heading
 * variable, a getter and setter method
 *
 * -Martin 4/11: -I created the code for the run method which define the
 * behavior of the agent when it is executed in its own thread and sleep for 20
 * millisecond(I think that the right time)
 *
 * -Junior 4/12: Made update() abstract and implemented the move() method (Also
 * made each agent start in a random position)
 *
 * -Junior 4/17: Fixed bugs in checkSuspended() and resume() that caused the
 * resume button to throw an exception
 *
 * -Nathan: 4/18:
 * removed clock update in Agent's run method, since clock is now real-time
 * changed run() to match professors run(), calling checkSuspended() twice
 * suspend calls onInterrupted()
 * added empty methods onStart() onInterrupted() and onExit() like professor does
 */

public abstract class Agent implements Serializable, Runnable {
    protected String name;
    protected Heading heading;
    protected int xc = Utilities.rng.nextInt(500);
    protected int yc = Utilities.rng.nextInt(500);
    protected boolean suspended = false;
    protected boolean stopped = false;
    transient protected Thread myThread;
    protected Simulation world;

    public Agent() {

        this.heading = Heading.random();
        //Nathan: Drunk writes this again in its constructor, but idk if yours do so i'm leaving it
    }

    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    @Override
    public void run() {
        myThread = Thread.currentThread();
        checkSuspended();
        onStart();
        while (!stopped) {


            //world.incrementClock(); // Increment clock in each agent's update loop
            try {
                update();
                Thread.sleep(20); // Sleep for 20 milliseconds for smooth graphics
                checkSuspended();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                Utilities.error(e);
            }
        }
        onExit();
    }

    private void onStart() {}
    private void onInterrupted() {}
    private void onExit() {}


    public void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    public void checkSuspended() {
        try {
            while (!stopped && suspended) {
                synchronized (this) {
                    wait();
                    suspended = false;
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            Utilities.error(e);
        }
    }

    public synchronized void suspend() {
        onInterrupted();
        suspended = true;
    }

    public void stop() {
        stopped = true;
    }

    public void resume() {
        synchronized (this) {
            notify();
        }
    }

    public abstract void update();

    public void move(int steps) {
        int viewSize = 500;

        if (heading == Heading.NORTH) {
            yc = (yc + steps) % viewSize;
        } else if (heading == Heading.WEST) {
            xc = (xc - steps + viewSize) % viewSize;
        } else if (heading == Heading.EAST) {
            xc = (xc + steps) % viewSize;
        } else if (heading == Heading.SOUTH) {
            yc = (yc - steps + viewSize) % viewSize;
        }

        world.changed();
    }

    public void setWorld(Simulation world) {
        this.world = world;
    }

    public void getWorld(Simulation world) {
        this.world = world;
    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

}
