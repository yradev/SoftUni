package JavaAdvanced.Examples.DefiningClasses.Google;

public class Parents {
    private String ParentName;
    private String ParentBirthday;

    public Parents(String parentName, String parentBirthday) {
        ParentName = parentName;
        ParentBirthday = parentBirthday;
    }
    @Override
    public String toString(){
        return String.format("%s %s",ParentName,ParentBirthday);
    }
}
