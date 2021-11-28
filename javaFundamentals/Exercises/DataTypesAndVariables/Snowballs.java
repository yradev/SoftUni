package javaFundamentals.Exercises.DataTypesAndVariables;
import java.util.*;

public class Snowballs {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        Map <Double,List <Integer>> SnowBall = new LinkedHashMap<>();


        int N = Integer.parseInt(Input.nextLine());

        for(int i=1; i<=N; i++) {
            int SnowBallSnow = Integer.parseInt(Input.nextLine());
            int SnowBallTime = Integer.parseInt(Input.nextLine());
            int SnowBallQuality = Integer.parseInt(Input.nextLine());

            Double SnowBallValue = Math.pow((double) (SnowBallSnow / SnowBallTime), SnowBallQuality);
            SnowBall.putIfAbsent(SnowBallValue,new ArrayList<>());
            SnowBall.get(SnowBallValue).add(SnowBallSnow);
            SnowBall.get(SnowBallValue).add(SnowBallTime);
            SnowBall.get(SnowBallValue).add(SnowBallQuality);
        }


        double max = SnowBall.keySet().stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .getAsDouble();

        int Snow = SnowBall.get(max).get(0);
        int Time = SnowBall.get(max).get(1);
        int Quality = SnowBall.get(max).get(2);

        System.out.printf("%s : %s = %.0f (%S)",Snow,Time,max,Quality);

    }
}
