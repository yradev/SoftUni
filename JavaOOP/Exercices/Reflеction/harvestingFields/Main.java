package Reflеction.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			if (input.equals("HARVEST")) {
				break;
			}
			Class<RichSoilLand> clazz = RichSoilLand.class;
			Field[] fields = clazz.getDeclaredFields();
			if (!input.equals("all")) {
				Arrays.stream(fields)
						.filter(a->Modifier.toString(a.getModifiers()).equals(input))
						.forEach(a-> System.out.printf("%s %s %s\n",Modifier.toString(a.getModifiers()),a.getType().getSimpleName(),a.getName()));
			}else{
				Arrays.stream(fields)
						.forEach(a-> System.out.printf("%s %s %s\n",Modifier.toString(a.getModifiers()),a.getType().getSimpleName(),a.getName()));
			}
		}
	}
}
