package Exams.August222021.glacialExpedition;

import Exams.August222021.glacialExpedition.core.Controller;
import Exams.August222021.glacialExpedition.core.ControllerImpl;
import Exams.August222021.glacialExpedition.core.Engine;
import Exams.August222021.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
