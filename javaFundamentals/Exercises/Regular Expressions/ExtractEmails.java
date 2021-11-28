package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> Emails = new LinkedHashMap<>();

        String regex = "(?<user>[A-za-z0-9]+(?:[\\.\\-_][A-za-z0-9]+)*)@(?<host>[a-zA-Z]+(?:[\\-][a-zA-z]+)*(?:\\.[a-zA-Z]+(?:[\\-][a-zA-Z]+)*)*\\.[a-z]+)";

        String Input = input.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Input);

        while (matcher.find()) {
            String user = matcher.group("user");
            String host = matcher.group("host");
            Emails.put(user, host);
        }

        for (Map.Entry<String, String> stringStringEntry : Emails.entrySet()) {
            System.out.printf("%s@%s\n", stringStringEntry.getKey(), stringStringEntry.getValue());
        }

    }
}
