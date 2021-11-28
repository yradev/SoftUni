package JavaFundamentals.Exercises.List;

import java.util.*;

public class HouseParty {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        List <String> GuestsGoin = new ArrayList<>();
        int NumberOfCommands = Integer.parseInt(Input.nextLine());

        for(int i=1;i<=NumberOfCommands;i++) {
            String[] Split = Input.nextLine().split(" ");
            String GuestName = Split[0];

            if(Split[2].equalsIgnoreCase("not")) {
                if (GuestsGoin.contains(GuestName)) {
                    GuestsGoin.remove(GuestName);
                } else {
                    System.out.printf("%s is not in the list!\n", GuestName);
                }
            }else {
                if (GuestsGoin.contains(GuestName)) {
                    System.out.printf("%s is already in the list!\n",GuestName);
                }else{
                    GuestsGoin.add(GuestName);
                }
            }
        }

        for (String s : GuestsGoin) {
            System.out.println(s);
        }

    }
}
