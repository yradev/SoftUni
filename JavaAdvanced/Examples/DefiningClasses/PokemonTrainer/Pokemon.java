package JavaAdvanced.Examples.DefiningClasses.PokemonTrainer;

public class Pokemon {
private String Name;
private String Element;
private int Health;

    public Pokemon(String name, String element, int health) {
        Name = name;
        Element = element;
        Health = health;
    }

    public String getElement() {
        return Element;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getHealth() {
        return Health;
    }
}
