package JavaOOP.Exercises.Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money<0){
            throw new IllegalStateException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product){
        if(money<product.getCost()){
            throw new IllegalStateException(String.format("%s can't afford %s",name,product.getName()));
        }
        products.add(product);
        money-=product.getCost();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        StringBuilder printer = new StringBuilder();
        printer.append(String.format("%s - ",name));
        if(products.isEmpty()){
            printer.append("Nothing bought");
        }else{
            String productsCollect = products.stream().map(Product::getName).collect(Collectors.joining(", "));
            printer.append(String.format("%s",productsCollect));
        }
        return printer.toString();
    }
}
