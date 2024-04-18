package prisonersDilemma;

import mvc.*;
import simstation.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor, cooperate(), updateFitness(),
 * and update() methods
 */

public class Prisoner extends Agent{
    protected int fitness = 0;
    protected boolean partnerCheated = false;
    protected Strategy strategy;

    public Prisoner(String strategy){
        super();

        if(strategy.equalsIgnoreCase("Cheat")){
            this.strategy = new Cheat(this);
        }
        else if(strategy.equalsIgnoreCase("Cooperate")){
            this.strategy = new Cooperate(this);
        }
        else if (strategy.equalsIgnoreCase("Random")) {
            this.strategy = new RandomlyCooperate(this);
        }
        else if (strategy.equalsIgnoreCase("Tit4Tat")){
            this.strategy = new Tit4Tat(this);
        }
    }

    public boolean cooperate(){
        return strategy.cooperate();
    }

    @Override
    public void update(){
        Agent partner = world.getNeighbor(this, 10);
        if(partner != null) {
            Prisoner prisonerPartner = (Prisoner)partner;

            boolean myResult = this.cooperate();
            partnerCheated = !prisonerPartner.cooperate();

            if (myResult && !partnerCheated){ // Both cooperate
                updateFitness(3);
                prisonerPartner.updateFitness(3);
            }
            else if(!myResult && !partnerCheated){ // I cheat and my partner cooperates
                updateFitness(5);
                prisonerPartner.updateFitness(0);
            }
            else if (myResult){ // I cooperate and my partner cheated
                updateFitness(0);
                prisonerPartner.updateFitness(5);
            }
            else{ // Both cheated
                updateFitness(1);
                prisonerPartner.updateFitness(1);
            }
        }

        heading = Heading.random();
        move(Utilities.rng.nextInt(10) + 1); // move() calls world.changed()
    }

    public void updateFitness(int amt){
        fitness += amt;
    }
}
