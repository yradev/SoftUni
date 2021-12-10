package Reflеction.barracksWars.core.commands;

import Reflеction.barracksWars.interfaces.Repository;
import Reflеction.barracksWars.interfaces.UnitFactory;

public class Report extends Command{
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();
    }
}
