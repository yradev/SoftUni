package JavaFundamentals.Exercises.List;


import java.util.*;
import java.util.stream.Collectors;

public class ChangeList {
        public static void main(String[] args) {
            Scanner input  = new Scanner(System.in);
            List<Integer> Array = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            String Input = input.nextLine();
            while (!Input.equalsIgnoreCase("end")) {
                String[] Split = Input.split(" ");
                String Command = Split[0];
                int Element = Integer.parseInt(Split[1]);

                switch (Command) {
                    case "Delete":
                        for (int i = 0; i <= Array.size() - 1; i++) {
                            if (Array.get(i) == Element) {
                                Array.remove(i);
                            }
                        }
                        break;
                    case "Insert":
                        int Position = Integer.parseInt(Split[2]);
                        Array.add(Position, Element);

                }
                Input = input.nextLine();
            }

            String EndArray = Array.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(EndArray);
        }
}