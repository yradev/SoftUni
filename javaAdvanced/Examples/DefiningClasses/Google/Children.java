package DefiningClasses.Google;

public class Children {
    private String ChildrenName;
    private String ChildrenBirthday;

    public Children(String childrenName, String childrenBirthday) {
        ChildrenName = childrenName;
        ChildrenBirthday = childrenBirthday;
    }

    @Override
    public String toString(){
       return String.format("%s %s",ChildrenName,ChildrenBirthday);
    }
}
