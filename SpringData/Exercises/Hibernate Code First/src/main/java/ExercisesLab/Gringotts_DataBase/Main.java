package ExercisesLab.Gringotts_DataBase;

import Connector.DBConnector;
import ExercisesLab.Gringotts_DataBase.Entities.wizard_deposits;
import Include.Exercises;

import javax.persistence.EntityManager;

public class Main extends Exercises {
    private EntityManager em;

    @Override
    public void run() {
      em = super.connectToDB("Gringotts");
    }
}
