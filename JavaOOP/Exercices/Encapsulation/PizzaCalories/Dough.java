package JavaOOP.Exercises.Encapsulation.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Validator.flourType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.bakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Validator.doughWeigh(weight);
        this.weight = weight;
    }

    private double getModifier(String name){
        double value = 0;
        switch (name){
            case"White": value=1.5;break;
            case"Wholegrain": value=1.0;break;
            case"Crispy": value=0.9;break;
            case"Chewy":value=1.1;break;
            case"Homemade":value=1.0;break;
        }
        return value;
    }

    public double calculateCalories(){
        return (2*weight)*getModifier(flourType)*getModifier(bakingTechnique);
    }
}
