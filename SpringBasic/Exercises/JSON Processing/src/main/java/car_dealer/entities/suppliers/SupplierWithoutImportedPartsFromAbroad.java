package car_dealer.entities.suppliers;

public class SupplierWithoutImportedPartsFromAbroad {
    private int Id;
    private String Name;
    private int partsCount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public SupplierWithoutImportedPartsFromAbroad(int id, String name, int partsCount) {
        Id = id;
        Name = name;
        this.partsCount = partsCount;
    }
}
