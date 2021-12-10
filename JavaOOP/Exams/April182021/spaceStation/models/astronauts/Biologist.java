package Exams.April182021.spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    public Biologist(String name) {
        super(name, 70);
    }

    @Override
    public void breath() {
        double oxygen = super.getOxygen()-5;
        if(oxygen<0){
            oxygen=0;
        }
        super.setOxygen(oxygen);
    }
}
