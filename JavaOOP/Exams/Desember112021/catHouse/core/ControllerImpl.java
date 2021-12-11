package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private ToyRepository toyRepository;
    private Collection<House> houses;

    public ControllerImpl() {
        toyRepository = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        switch (type){
            case"ShortHouse":
                ShortHouse shortHouse = new ShortHouse(name);
                houses.add(shortHouse);
                break;
            case"LongHouse":
                LongHouse longHouse = new LongHouse(name);
                houses.add(longHouse);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        switch (type){
            case"Ball":
                Ball ball = new Ball();
                toyRepository.buyToy(ball);
                break;
            case"Mouse":
                Mouse mouse = new Mouse();
                toyRepository.buyToy(mouse);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = getHouse(houseName,houses);
        Toy toy = getToy(toyType,toyRepository.getToys());
        if(toy==null){
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND,toyType));
        }
        house.buyToy(toy);
        toyRepository.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,house.getName());
    }

    private Toy getToy(String toyType, Collection<Toy> toys) {
        return toys.stream().filter(a->a.getClass().getSimpleName().equals(toyType)).findFirst().orElse(null);
    }

    private House getHouse(String houseName,Collection<House>houses) {
        return houses.stream().filter(a->a.getName().equals(houseName)).findFirst().orElse(null);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        switch (catType){
            case"ShorthairCat":
                ShorthairCat shorthairCat = new ShorthairCat(catName,catBreed,price);
                House shortHouse = getHouse(houseName,houses);
                if(shortHouse==null || !shortHouse.getClass().getSimpleName().equals(ShortHouse.class.getSimpleName())){
                    return UNSUITABLE_HOUSE;
                }
                shortHouse.addCat(shorthairCat);
                break;
            case"LonghairCat":
                LonghairCat longhairCat = new LonghairCat(catName,catBreed,price);
                House longHouse = getHouse(houseName,houses);
                if(longHouse==null || !longHouse.getClass().getSimpleName().equals(LongHouse.class.getSimpleName())){
                    return UNSUITABLE_HOUSE;
                }
                longHouse.addCat(longhairCat);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouse(houseName, houses);
        house.feeding();
        return String.format(FEEDING_CAT,house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouse(houseName,houses);
        double total = 0;
        for (Cat cat : house.getCats()) {
            total+=cat.getPrice();
        }

        for (Toy toy : house.getToys()) {
            total+=toy.getPrice();
        }

        return String.format(VALUE_HOUSE,houseName,total);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
