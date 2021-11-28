package JavaOOP.Exercises.Abstraction.greedyTimes;

public class Gems {
    private String Name;
    private long Size;

    public Gems(String name, long size) {
        Name = name;
        Size = size;
    }

    public String getName() {
        return Name;
    }

    public long getSize() {
        return Size;
    }

    public void setSize(long size) {
        Size = size;
    }
}
