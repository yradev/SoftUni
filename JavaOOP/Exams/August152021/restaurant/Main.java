package Exams.August152021.restaurant;

import Exams.August152021.restaurant.core.ControllerImpl;
import Exams.August152021.restaurant.core.EngineImpl;
import Exams.August152021.restaurant.core.interfaces.Controller;
import Exams.August152021.restaurant.entities.drinks.interfaces.Beverages;
import Exams.August152021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import Exams.August152021.restaurant.entities.tables.interfaces.Table;

import Exams.August152021.restaurant.io.ConsoleReader;
import Exams.August152021.restaurant.io.ConsoleWriter;
import Exams.August152021.restaurant.repositories.BeverageRepositoryImpl;
import Exams.August152021.restaurant.repositories.HealthFoodRepositoryImpl;
import Exams.August152021.restaurant.repositories.TableRepositoryImpl;
import Exams.August152021.restaurant.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {
        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
