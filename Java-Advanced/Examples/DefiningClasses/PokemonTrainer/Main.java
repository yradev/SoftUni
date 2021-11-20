package DefiningClasses.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Trainer>Trainers = new LinkedHashMap<>();

        while(true){
            List<String>Input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            if(Input.get(0).equals("Tournament")){
                break;
            }
            String TrainerName = Input.get(0);
            String PokemonName = Input.get(1);
            String PokemonElement = Input.get(2);
            int PokemonHealth = Integer.parseInt(Input.get(3));

            if(!Trainers.containsKey(TrainerName)){
                Trainer trainer = new Trainer(TrainerName,0,1);
                Trainers.put(TrainerName,trainer);
            }else{
                Trainers.get(TrainerName).setCollectionOfPokemons(Trainers.get(TrainerName).getCollectionOfPokemons()+1);
            }
            Trainers.get(TrainerName).setPokemon(PokemonName,PokemonElement,PokemonHealth);
        }

        while(true){
            String Command = scanner.nextLine();
            if(Command.equals("End")){
                break;
            }

            Trainers.forEach((key, value) -> {
                if(Trainers.get(key).isEqualWithElement(Command)){
                  Trainers.get(key).setNumberOfBadges(Trainers.get(key).getNumberOfBadges()+1);
                }else{
                  Trainers.get(key).Reduce();
              }
            });
        }

        Trainers.entrySet().stream()
                .sorted((a,b)->Integer.compare(b.getValue().getNumberOfBadges(),a.getValue().getNumberOfBadges()))
                .forEach(a->System.out.printf("%s %s %s\n",a.getKey(),a.getValue().getNumberOfBadges(),a.getValue().getCollectionOfPokemons()));
    }
}
