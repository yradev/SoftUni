package Exams.August222021.glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    public NaturalExplorer(String name) {
        super(name, 60);
    }

    @Override
    public void search() {
        double energy = getEnergy()-7;
        if(energy<0){
            setEnergy(0);
        }else{
           setEnergy(energy);
        }
    }
}
