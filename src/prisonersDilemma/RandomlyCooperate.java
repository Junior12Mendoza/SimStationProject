package prisonersDilemma;

import mvc.*;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 */

public class RandomlyCooperate extends Strategy{
    public RandomlyCooperate(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return Utilities.rng.nextInt(2) == 0;
    }
}
