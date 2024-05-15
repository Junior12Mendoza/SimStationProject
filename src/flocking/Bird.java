package flocking;

/**
 * Nathan 4/19:
 * wrote this file
 */

import mvc.*;
import simstation.*;

class Bird extends Agent {

    int speed;

    public Bird() {
        super();
        speed = Utilities.rng.nextInt(5) + 1;
        heading = Heading.random();
    }


    /**
     * approximately,
     * choose neighbor within 1/6th of the playing field
     * separated chance to choose speed and heading for better animation
     * but then I just wanted them to be the same anyway
     */

    public void update() {
        Bird neighbor = (Bird) world.getNeighbor(this, 80);

        if (Utilities.rng.nextInt(8) == 1) {
            this.heading = neighbor.getHeading();
        }
        if (Utilities.rng.nextInt(8) == 1) {
            this.speed = neighbor.getSpeed();
            move(speed);
        }
    }

    int getSpeed() {
        return this.speed;
    }

}