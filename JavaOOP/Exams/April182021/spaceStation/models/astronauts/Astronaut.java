package Exams.April182021.spaceStation.models.astronauts;

import Exams.April182021.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
