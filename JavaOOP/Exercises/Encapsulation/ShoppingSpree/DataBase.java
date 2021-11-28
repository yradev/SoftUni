package JavaOOP.Exercises.Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Product>productPrices;
    private List<Person> persons;

    public DataBase() {
        productPrices = new ArrayList<>();
        persons = new ArrayList<>();
    }

    public void addUser(String name, double money){
        Person person = new Person(name,money);
        persons.add(person);
    }

    public void addProductToPriceList(String name,double cost){
        Product product = new Product(name,cost);
        productPrices.add(product);
    }

    public void addProductToPerson(String personName, String productName){
        int indexOfPerson = 0;
        int indexOfProduct = 0;
        for (Person person : persons) {
            if(person.getName().equals(personName)){
                indexOfPerson = persons.indexOf(person);
                break;
            }
        }

        for (Product productPrice : productPrices) {
            if(productPrice.getName().equals(productName)){
                indexOfProduct=productPrices.indexOf(productPrice);
                break;
            }
        }
            persons.get(indexOfPerson).buyProduct(productPrices.get(indexOfProduct));
    }

    public void printResult() {
        for (Person person : persons) {
            System.out.println(person);
        }

    }
}
