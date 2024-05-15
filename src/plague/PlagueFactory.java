package plague;
import mvc.*;
import simstation.*;
import java.awt.*;
import java.util.Iterator;
/**
 *
 *
 * -Edits:
 * Martin 4/16
 * - I added the basic information that the plague factory needs like the title and etc
 * -I also added a switch case senario to get which button the use presses in the make edit command method
 */


public class PlagueFactory extends SimulationFactory {

    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public View makeView(Model model) {
        return new PlagueView((PlagueSimulation) model);
    }

    @Override
    public String getTitle() {
        return "Plague Simulation";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Click on any of the buttons to control the plague Simulation "};
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{
                "Start","Stats","Stop","Suspend","Resume"};
    }

    @Override
    public String about() {
        return "Plague Simulation for CS-151";
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Start":
                return new StartCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Suspend":
                return new SuspendCommand(model);
            case "Stats":
                return new StatsCommand(model); // Needs implementation
            default:
                return null;
        }
    }
}
