package Reflеction.barracksWars;

import Reflеction.barracksWars.interfaces.Repository;
import Reflеction.barracksWars.interfaces.Runnable;
import Reflеction.barracksWars.interfaces.UnitFactory;
import Reflеction.barracksWars.core.Engine;
import Reflеction.barracksWars.core.factories.UnitFactoryImpl;
import Reflеction.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();

    }
}
