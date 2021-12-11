package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
private House house;
private Cat cat;

    @Before
    public void set() {
        cat = new Cat("Tom");
        house = new House("TomsPalace",123);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsNull(){
        House houseWithNullName = new House(null,33);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsWhiteSpaces(){
        House houseWithSpacesEmpty = new House("  ",33);
    }

    @Test
    public void setNameIsCorrect(){
        Assert.assertEquals("TomsPalace",house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityIsNegativeCapacity(){
        House houseWithNegativeCapacity = new House("sad",-22);
    }

    @Test
    public void setCapacityIsValid(){
        Assert.assertEquals(123,house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCatInHouseWithCapacityZero(){
        House houseZero = new House("new",0);
        houseZero.addCat(cat);
    }

    @Test
    public void addCatIsCorrect(){
        house.addCat(cat);
        Assert.assertEquals(1,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatIsNull(){
        house.removeCat("sadCat");
    }

    @Test
    public void removeCatIsValid(){
        house.addCat(cat);
        house.removeCat("Tom");
        Assert.assertEquals(0,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void catForSaleIsNull(){
        house.catForSale("tomsCatDoesntExist");
    }

    @Test()
    public void catIsSelled(){
        house.addCat(cat);
        house.catForSale("Tom");
        Assert.assertFalse(cat.isHungry());
    }

    @Test
    public void statisticsIsValid(){
        house.addCat(cat);
        String expected = "The cat Tom is in the house TomsPalace!";
        Assert.assertEquals(expected,house.statistics());
    }
}
