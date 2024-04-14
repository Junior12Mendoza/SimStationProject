package prisonersDilemma;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 */
public abstract class Strategy {
    protected Prisoner myPrisoner;
    public Strategy(Prisoner myPrisoner){
        this.myPrisoner = myPrisoner;
    }
    public abstract boolean cooperate();
}
