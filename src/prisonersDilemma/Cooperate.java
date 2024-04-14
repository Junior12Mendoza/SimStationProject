package prisonersDilemma;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 */
public class Cooperate extends Strategy{

    public Cooperate(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return true;
    }
}
