package DefiningClasses.Google;

public class Pokemon {
    private String PokemonName;
    private String PokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        PokemonName = pokemonName;
        PokemonType = pokemonType;
    }

    @Override
    public String toString(){
        return String.format("%s %s",PokemonName,PokemonType);
    }
}
