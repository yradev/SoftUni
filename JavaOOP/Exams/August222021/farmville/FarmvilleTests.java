package farmville;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FarmvilleTests {
    private Animal animal;
    private Farm farm;
    private Farm capacity;

    @Before
    public void setUp() {
        animal = new Animal("newType",123);
        farm = new Farm("newFarm", 222);
        capacity = new Farm("equalCapacity",0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sizeEqualToCapacityInAdd(){
        capacity.add(animal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void animalExistWhenAdd(){
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void isAnimalAdded(){
        farm.add(animal);
    }

    @Test
    public void isAnimalRemoved(){
        boolean expected = true;
        farm.add(animal);
        boolean result = farm.remove("newType");
        Assert.assertEquals(expected,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isCapacityNegativeNumber(){
        Farm negativeCapacity = new Farm("farmer", -22);
    }

    @Test
    public void setCapacityIsValid(){
        Farm negativeCapacity = new Farm("farmer", 22);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsNull(){
        Farm name = new Farm(null,333);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsWithSpaces(){
        Farm name = new Farm("  ",22);
    }

    @Test
    public void isSetNameValid(){
        Farm name = new Farm("name",33);
        Assert.assertEquals("name",name.getName());
    }
}
