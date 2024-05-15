package prisonersDilemma;

import java.io.Serializable;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 *
 * - Junior 4/17
 * Added toString() for getStats() in PrisonerSimulation
 */
public abstract class Strategy implements Serializable {
    protected Prisoner myPrisoner;
    public Strategy(Prisoner myPrisoner){
        this.myPrisoner = myPrisoner;
    }
    public abstract boolean cooperate();
    public abstract String toString();
}
