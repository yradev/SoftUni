package JavaAdvanced.Examples.DefiningClasses.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Trainer {
private String Name;
private int numberOfBadges;
private int collectionOfPokemons;
private List<Pokemon> Pokemons = new ArrayList<>();
    public Trainer(String name, int numberOfBadges, int collectionOfPokemons) {
        Name = name;
        this.numberOfBadges = numberOfBadges;
        this.collectionOfPokemons = collectionOfPokemons;
    }

    public int getCollectionOfPokemons() {
        return collectionOfPokemons;
    }

    public void setCollectionOfPokemons(int collectionOfPokemons) {
        this.collectionOfPokemons = collectionOfPokemons;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public boolean isEqualWithElement(String Element){
        boolean isTrue = false;
        for (Pokemon pokemon : Pokemons) {
            if(pokemon.getElement().equals(Element)){
                isTrue=true;
                break;
            }
        }
        return isTrue;
    }

    public void Reduce(){
        for(int i=0;i<Pokemons.size();i++){
            int newValue = Pokemons.get(i).getHealth()-10;
            Pokemons.get(i).setHealth(newValue);
            if(newValue<=0){
                collectionOfPokemons--;
            }
        }

       Pokemons = Pokemons.stream().filter(a->a.getHealth()>0).collect(Collectors.toList());
    }

    public void setPokemon(String Name, String Element,int Health){
        Pokemon pokemon = new Pokemon(Name,Element,Health);
        Pokemons.add(pokemon);
    }
}
