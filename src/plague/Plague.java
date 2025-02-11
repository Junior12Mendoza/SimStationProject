package plague;

import simstation.*;
import mvc.*;

/**
 * Edits:
 * Junior Mendoza 2/10/25:
 * This file appears to have been deleted at some point, so I rewrote it
 */
public class Plague extends Agent {
    private boolean infected;

    public Plague() {
        super();
        this.heading = Heading.random();
        infected = false;
    }

    public void infect() {
        infected = true;
    }
    public boolean isInfected(){
        return infected;
    }

    @Override
    public void update() {
        // If an agent is not infected, or they recover, then they can't infect any other agent
        if(!infected || Utilities.rng.nextInt(100) + 1 <= PlagueSimulation.RECOVERY_RATE){
            infected = false;
        }
        else{
            Plague partner = (Plague) world.getNeighbor(this, PlagueSimulation.INFECTION_RADIUS);
            boolean infectPartner = Utilities.rng.nextInt(100) + 1 <= PlagueSimulation.VIRULENCE;
            boolean partnerResist = Utilities.rng.nextInt(100) + 1 <= PlagueSimulation.RESISTANCE;
            if (infectPartner && !partnerResist){
                partner.infect();
            }
        }
        heading = Heading.random();
        move(Utilities.rng.nextInt(10) + 1); // move() calls world.changed()
    }
}