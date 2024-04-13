package simstation;

import mvc.*;
/**
 *
 * Edits:
 * Martin 4/11:
 * -In this file I created a switch case senario which gets eahc possible outcome for the buttons
 * -I also created the basic stuff for the program like the get help,edit commands,and about.
 */
public class SimulationFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model model) {
        return new SimulationView((Simulation) model);
    }

    @Override
    public String getTitle() {
        return "Simulation Project";
    }

    @Override
    public String[] getHelp() {
        return new String[]{
                "Click on the buttons to make the program run"
        };
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Run","Stop","Suspend","Resume","Stats"};
    }

    @Override
    public String about() {
        return "Simulation Version 1.0 for Cs151";
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {

        switch(type){
            case "Start":
                return new StartCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Suspend":
                return new SuspendCommand(model);
            case "Stats":
                return new SuspendCommand(model);
            default:
                return null;
        }
    }
}
