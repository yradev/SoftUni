package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
    private Gun gun;
    private Player player;

    @Before
    public void set(){
        gun = new Gun("Shotgun",200);
        player = new Player("a",100);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsNull(){
        Player newPlayer = new Player(null,100);
    }

    @Test(expected = NullPointerException.class)
    public void setNameIsSpaces(){
        Player newPlayer = new Player("   ",100);
    }

    @Test
    public void setUsernameIsTrue(){
        Assert.assertEquals("a",player.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHealthIsNegativeNumber(){
        Player newPlayer = new Player("a",-1);
    }

    @Test
    public void setHealthIsValid(){
        Assert.assertEquals(100,player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageIsNullorNegative(){
        player.takeDamage(player.getHealth());
        player.takeDamage(3);
    }

    @Test
    public void takeDamageIsValid(){
        player.takeDamage(3);
        Assert.assertEquals(97,player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void addGunIsNull(){
        player.addGun(null);
    }

    @Test
    public void addGunIsValid(){
        player.addGun(gun);
        Assert.assertEquals(gun,player.getGun("Shotgun"));
    }

    @Test
    public void removeGunIsValid(){
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void getGunIsValid(){
        player.addGun(gun);
        Assert.assertEquals(gun,player.getGun("Shotgun"));
    }
}
