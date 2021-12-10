package Reflеction.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt>clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("END")){
                break;
            }
            String [] split = input.split("_");
            Method method = clazz.getDeclaredMethod(split[0],int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt,Integer.parseInt(split[1]));

            Field field = clazz.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
    }
}
