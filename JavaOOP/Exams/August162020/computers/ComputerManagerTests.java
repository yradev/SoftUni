package computers;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class ComputerManagerTests {
    private Computer computer;
    private ComputerManager computerManager;
    private Computer computer2;

    @Before
    public void setUp() {
        computer = new Computer("mfact","model",2.30);
        computer2 = new Computer("Asus", "RN60", 500);
        computerManager = new ComputerManager();
    }


    @Test(expected = IllegalArgumentException.class)
    public void addComputerInputValueIsNull(){
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerExists(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void addComputerIsValid(){
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer2);
        Assert.assertEquals(2, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerManufacturerIsNull(){
        computerManager.getComputer(null,"something");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerModelIsNull(){
        computerManager.getComputer("something",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerModelDoesntHaveEqualComputers(){
        computerManager.getComputer(computer.getManufacturer(),computer.getModel());
    }

    @Test
    public void getComputerIsValid(){
        Computer expected = computer;
        computerManager.addComputer(computer);
        Computer get = computerManager.getComputer(computer.getManufacturer(), computer.getModel());
        Assert.assertEquals(expected,get);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerByManufacturerWithNullValue(){
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void getComputersByManufacturerIsValid(){
        Assert.assertEquals(List.of(),computerManager.getComputersByManufacturer("mfactis"));
    }
}