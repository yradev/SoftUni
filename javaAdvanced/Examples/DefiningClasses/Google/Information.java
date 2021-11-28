package DefiningClasses.Google;
import java.util.ArrayList;
import java.util.List;

public class Information {
    private String CompanyName;
    private String Departmant;
    private Double Salary;
    private String CarModel;
    private int CarSpeed;
    private List<Parents>parents = new ArrayList<>();
    private List<Children>childs = new ArrayList<>();
    private List<Pokemon>pokemons = new ArrayList<>();

    public void setCompany(String CompanyName, String Departmant, Double Salary){
        this.CompanyName = CompanyName;
        this.Departmant = Departmant;
        this.Salary = Salary;
    }

    public void setPokemon(String PokemonName, String PokemonType){
        Pokemon pokemon = new Pokemon(PokemonName,PokemonType);
        pokemons.add(pokemon);
    }

    public void setParent(String ParentName, String ParentBirthday){
        Parents parent = new Parents(ParentName,ParentBirthday);
        parents.add(parent);
    }

    public void setChildren(String ChildrenName, String ChildBirthday){
        Children childrens = new Children(ChildrenName,ChildBirthday);
        childs.add(childrens);
    }

    public void setCar(String CarModel, int CarSpeed){
        this.CarModel = CarModel;
        this.CarSpeed = CarSpeed;
    }

    public void getText(){
        System.out.println("Company:");
        if(CompanyName!=null || Departmant!=null || Salary!=null) {
            System.out.printf("%s %s %.2f\n", CompanyName, Departmant, Salary);
        }
        System.out.println("Car:");
        if(CarModel!=null || CarSpeed!=0) {
            System.out.printf("%s %s\n", CarModel, CarSpeed);
        }
        System.out.println("Pokemon:");
        pokemons.forEach(System.out::println);
        System.out.println("Parents:");
        parents.forEach(System.out::println);
        System.out.println("Children:");
        childs.forEach(System.out::println);
    }
}
