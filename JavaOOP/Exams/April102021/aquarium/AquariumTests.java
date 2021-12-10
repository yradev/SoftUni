package Exams.April102021.aquarium;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setUp() {
        aquarium = new Aquarium("aquarium",33);
        fish = new Fish("sharan");
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsNull(){
        Aquarium aquariumNew = new Aquarium(null,22);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsWithSpaces(){
        Aquarium aquariumNew = new Aquarium("   ",44);
    }

    @Test
    public void isNameCorrect(){
        Aquarium aqua = new Aquarium("new",33);
        Assert.assertEquals("new",aqua.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isCapacityNegativeNumber(){
        Aquarium aquarium = new Aquarium("new",-33);
    }

    @Test
    public void isCapacityValid(){
        Assert.assertEquals(33,aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSizeEqualToCapacity(){
        Aquarium newAquarium = new Aquarium("new",0);
        newAquarium.add(fish);
    }
    @Test
    public void FishAdded(){
        aquarium.add(fish);
    }

    @Test(expected = IllegalArgumentException.class)
    public void FishWithThatNameDoesntExist(){
        aquarium.add(fish);
        aquarium.remove("dss");
    }

    @Test
    public void FishRemoved(){
        aquarium.add(fish);
        aquarium.remove("sharan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellFishIsInvalid(){
        aquarium.sellFish("dssadsa");
    }

    @Test
    public void sellFish(){
        aquarium.add(fish);
        aquarium.sellFish("sharan");
        Assert.assertFalse(fish.isAvailable());
    }
}

