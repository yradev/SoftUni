package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> Participants = new LinkedHashMap<>();

        List<String> Names = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());
        String pattern = "(?<Word>[a-z]|[A-Z])|(?<Number>\\d)";

        while (true) {
            String Alphanumeric = input.nextLine();
            if (Alphanumeric.equalsIgnoreCase("end of race")) {
                break;
            }

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(Alphanumeric);
            List<String> Diggits = new ArrayList<>();
            int tempSum = 0;
            while (matcher.find()) {
                if (matcher.group("Word") != null) {
                    Diggits.add(matcher.group("Word"));
                }
                if (matcher.group("Number") != null) {
                    int tempValue = Integer.parseInt(matcher.group("Number"));
                    tempSum += tempValue;
                }
            }
            String tempName = String.join("", Diggits);

            if (Names.contains(tempName)) {
                if (Participants.containsKey(tempName)) {
                    int tempValue = Participants.get(tempName) + tempSum;
                    Participants.replace(tempName, tempValue);
                } else {
                    Participants.put(tempName, tempSum);
                }
            }
        }

        List<String> top3 = Participants.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.printf("1st place: %s\n2nd place: %s\n3rd place: %s", top3.get(0), top3.get(1), top3.get(2));
    }
}