package Exams.August152021.restaurant.core;

import Exams.August152021.restaurant.core.interfaces.Controller;
import Exams.August152021.restaurant.entities.drinks.Fresh;
import Exams.August152021.restaurant.entities.drinks.Smoothie;
import Exams.August152021.restaurant.entities.healthyFoods.Salad;
import Exams.August152021.restaurant.entities.healthyFoods.VeganBiscuits;
import Exams.August152021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import Exams.August152021.restaurant.entities.drinks.interfaces.Beverages;
import Exams.August152021.restaurant.entities.tables.InGarden;
import Exams.August152021.restaurant.entities.tables.Indoors;
import Exams.August152021.restaurant.entities.tables.interfaces.Table;
import Exams.August152021.restaurant.repositories.interfaces.*;

import static Exams.August152021.restaurant.common.ExceptionMessages.*;
import static Exams.August152021.restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository <HealthyFood>healthFoodRepository;
    private BeverageRepository <Beverages> beveragesBeverages;
    private TableRepository<Table> tableRepository;
    private double earnedMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beveragesBeverages = beverageRepository;
        this.tableRepository = tableRepository;
        earnedMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {

        HealthyFood healthyFood = null;

        switch (type){
            case"Salad": healthyFood = new Salad(name,price);break;
            case"VeganBiscuits":healthyFood = new VeganBiscuits(name,price);break;
        }
        if(healthFoodRepository.foodByName(name)!=null){
            throw new IllegalArgumentException(String.format(FOOD_EXIST,name));
        }
        healthFoodRepository.add(healthyFood);
        return String.format(FOOD_ADDED,name);
    }


    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage = null;

        switch (type){
            case"Fresh": beverage =  new Fresh(name,counter,brand); break;
            case"Smoothie": beverage = new Smoothie(name,counter,brand); break;
        }

        if(beveragesBeverages.beverageByName(name,brand)!=null){
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST,name));
        }

        beveragesBeverages.add(beverage);
        return String.format(BEVERAGE_ADDED,type,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;

        switch (type){
            case"Indoors": table =  new Indoors(tableNumber,capacity); break;
            case"InGarden": table = new InGarden(tableNumber,capacity); break;
        }

        if(tableRepository.byNumber(tableNumber)!=null){
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED,tableNumber));
        }

        tableRepository.add(table);
        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        for (Table allEntity : tableRepository.getAllEntities()) {
            if(!allEntity.isReservedTable() && allEntity.getSize()>=numberOfPeople){
                allEntity.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED,allEntity.getTableNumber(),numberOfPeople);
            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        if(tableRepository.byNumber(tableNumber)==null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        if(healthFoodRepository.foodByName(healthyFoodName)==null){
            return String.format(NONE_EXISTENT_FOOD,healthyFoodName);
        }

        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);
        Table table = tableRepository.byNumber(tableNumber);
        table.orderHealthy(food);
        return String.format(FOOD_ORDER_SUCCESSFUL,healthyFoodName,tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        if(tableRepository.byNumber(tableNumber)==null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverages = beveragesBeverages.beverageByName(name,brand);
        if(beverages == null){
            return String.format(NON_EXISTENT_DRINK,name,brand);
        }
        table.orderBeverages(beverages);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL,name,tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        table.bill();
        double bill = table.allPeople();
        earnedMoney +=bill;
        table.clear();
        return String.format(BILL,tableNumber,bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY,earnedMoney);
    }
}
