package prisonersDilemma;

/**
 * Edits
 * - Junior 4/13
 * Created the class, along with the constructor and cooperate() method
 *
 * - Junior 4/17
 * Added toString() for getStats() in PrisonerSimulation
 */
public class Tit4Tat extends Strategy{
    public Tit4Tat(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return !myPrisoner.partnerCheated;
    }

    @Override
    public String toString() {
        return "Tit4Tat";
    }
}
