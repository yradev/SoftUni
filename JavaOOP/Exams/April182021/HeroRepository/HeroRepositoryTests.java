package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    private Hero hero1;
    private Hero hero2;
    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        hero1 = new Hero("hero1",11);
        heroRepository = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void isCreateHeroNull(){
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isHeroAlredyExistsOnCreate(){
        heroRepository.create(hero1);
        heroRepository.create(hero1);
    }


    @Test()
    public void isHeroAdded(){
        heroRepository.create(hero1);
    }

    @Test(expected = NullPointerException.class)
    public void isRemoveHeroNull(){
        heroRepository.remove(null);
        heroRepository.remove(" ");
    }

    @Test()
    public void isHeroRemoed(){
        heroRepository.remove("hero1");
    }

    @Test
    public void testGetHeroWithHighestLevel(){
        heroRepository.create(hero1);
        Hero betterHero = new Hero("Cecko", 30);
        heroRepository.create(betterHero);
        Assert.assertEquals(heroRepository.getHeroWithHighestLevel(), betterHero);
    }

    @Test
    public void testGetHero(){
        heroRepository.create(hero1);
        Assert.assertSame(heroRepository.getHero(hero1.getName()), hero1);
        heroRepository.remove(hero1.getName());
        Assert.assertNull(heroRepository.getHero(hero1.getName()));
    }
}