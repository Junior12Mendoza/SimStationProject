package simstation;

import mvc.*;

public class SimulationFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model m) {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public String about() {
        return null;
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return null;
    }
}
