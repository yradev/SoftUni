package JavaFundamentals.Exercises.RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Input = input.nextLine();
        Map<String, List<Double>> Demons = new LinkedHashMap<>();
        getDemons(Input, Demons);
        Demons = Demons.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        getHealth(Demons);
        getDamage(Demons);

        for (Map.Entry<String, List<Double>> DemonsNaes : Demons.entrySet()) {
            System.out.printf("%s - %.0f health, %.2f damage\n", DemonsNaes.getKey(), DemonsNaes.getValue().get(0), DemonsNaes.getValue().get(1));
        }
    }

    private static void getDamage(Map<String, List<Double>> Demons) {
        String regex = "[\\+\\-]*\\d+\\.*\\d*";
        String EndRegex = "[\\*/]";
        Pattern pattern = Pattern.compile(regex);
        Pattern endPattern = Pattern.compile(EndRegex);

        for (Map.Entry<String, List<Double>> DemonName : Demons.entrySet()) {
            Matcher matcherFirst = pattern.matcher(DemonName.getKey());

            double tempTotal = 0;
            while (matcherFirst.find()) {
                tempTotal += Double.parseDouble(matcherFirst.group());
            }

            Matcher matcherEnd = endPattern.matcher(DemonName.getKey());

            while (matcherEnd.find()) {
                if (matcherEnd.group().equalsIgnoreCase("*")) {
                    tempTotal *= 2;
                } else if (matcherEnd.group().equalsIgnoreCase("/")) {
                    tempTotal /= 2;
                }
            }

            Demons.get(DemonName.getKey()).set(1, tempTotal);
        }
    }

    private static void getHealth(Map<String, List<Double>> Demons) {
        String regex = "[^\\d\\+\\-\\*\\/,\\.]";
        for (Map.Entry<String, List<Double>> DemonsNames : Demons.entrySet()) {
            double tempHealth = 0;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(DemonsNames.getKey());
            while (matcher.find()) {
                tempHealth += matcher.group().charAt(0);
            }

            Demons.get(DemonsNames.getKey()).set(0, tempHealth);
        }
    }

    private static void getDemons(String Input, Map<String, List<Double>> Demons) {
        String regex = "[^,\\s]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Input);

        while (matcher.find()) {
            Demons.put(matcher.group(), Arrays.asList(0.0, 0.0));
        }
    }
}
