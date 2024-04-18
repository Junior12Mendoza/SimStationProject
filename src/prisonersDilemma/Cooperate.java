package prisonersDilemma;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 *
 * - Junior 4/17
 * Added toString() for getStats() in PrisonerSimulation
 */
public class Cooperate extends Strategy{

    public Cooperate(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return true;
    }

    @Override
    public String toString() {
        return "Always Cooperate";
    }
}
