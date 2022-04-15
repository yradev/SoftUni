package exam.model.laptop;

public class BestLaptopDTO {
    private String macAddress;
    private double cpuSpeed;
    private int ram;
    private int storage;
    private double price;
    private String shopName;
    private String shopTownName;

    public BestLaptopDTO(){}

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopTownName() {
        return shopTownName;
    }

    public void setShopTownName(String townName) {
        this.shopTownName = townName;
    }

    @Override
    public String toString() {
        return String.format("""
                Laptop - %s
                *Cpu speed - %.2f
                **Ram - %s
                ***Storage - %s
                ****Price - %.2f
                #Shop name - %s
                ##Town name - %s
                """,macAddress,cpuSpeed,ram,storage,price,shopName,shopTownName);
    }
}
