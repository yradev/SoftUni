package Reflеction.barracksWars.core.commands;

import Reflеction.barracksWars.interfaces.Repository;
import Reflеction.barracksWars.interfaces.UnitFactory;

public class Fight extends Command{
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
