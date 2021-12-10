package Exams.April182021.spaceStation;


import Exams.April182021.spaceStation.core.Controller;
import Exams.April182021.spaceStation.core.ControllerImpl;
import Exams.April182021.spaceStation.core.Engine;
import Exams.April182021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
