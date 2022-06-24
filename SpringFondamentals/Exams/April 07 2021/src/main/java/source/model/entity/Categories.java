package source.model.entity;

public enum Categories {
    COFFEE(2), CAKE(10), DRINK(1), OTHER(5);

    public final int neededTime;

    private Categories(int neededTime) {
        this.neededTime = neededTime;
    }
}
