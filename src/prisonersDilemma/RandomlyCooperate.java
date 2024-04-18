package prisonersDilemma;

import mvc.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 *
 * - Junior 4/17
 * Added toString() for getStats() in PrisonerSimulation
 */

public class RandomlyCooperate extends Strategy{
    public RandomlyCooperate(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return Utilities.rng.nextInt(2) == 0;
    }
    @Override
    public String toString() {
        return "Randomly Cooperate";
    }
}
