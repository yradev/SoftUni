package Include;

import Connector.DBConnector;

import javax.persistence.EntityManager;

public abstract class Exercises {

    public void run(){
    }

    protected EntityManager connectToDB(String dbName){
        DBConnector.connectToOtherDB(dbName);
        return DBConnector.getEntityManager();
    }
}
