package RegEx;

import java.util.*;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ReplaceRegex = "[sStTaArR]";
        String DecreasedRegex = "@(?<Planetname>[A-Za-z]+)[^@:!\\->]*:(?<Planetpopulation>\\d+)[^@:!\\->]*!(?<Attacktype>[A|D])![^@:!\\->]*\\->(?<Soldiercount>\\d+)";
        List<StringBuilder> DecryptedMessages = new ArrayList<>();

        List<String> AttackedPlanet = new ArrayList<>();
        List<String> DestroyedPlanet = new ArrayList<>();
        int MessagesCount = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= MessagesCount; i++) {
            String EncryptedCode = input.nextLine();
            Pattern patternReplace = Pattern.compile(ReplaceRegex);
            Matcher matcherReplace = patternReplace.matcher(EncryptedCode);

            int CountOfDecryptionWords = 0;
            while (matcherReplace.find()) {
                CountOfDecryptionWords++;
            }
            StringBuilder DecryptedMessage = new StringBuilder();

            for (int a = 0; a <= EncryptedCode.length() - 1; a++) {
                int tempChar = EncryptedCode.charAt(a) - CountOfDecryptionWords;
                DecryptedMessage.append((char) tempChar);
            }
            DecryptedMessages.add(DecryptedMessage);
        }

        for (int i = 0; i <= DecryptedMessages.size() - 1; i++) {
            Pattern DecreasedPattern = Pattern.compile(DecreasedRegex);
            Matcher DecreasedMatcher = DecreasedPattern.matcher(DecryptedMessages.get(i));

            while (DecreasedMatcher.find()) {
                if (DecreasedMatcher.group("Attacktype").equalsIgnoreCase("A")) {
                    AttackedPlanet.add(DecreasedMatcher.group("Planetname"));
                } else if (DecreasedMatcher.group("Attacktype").equalsIgnoreCase("D")) {
                    DestroyedPlanet.add(DecreasedMatcher.group("Planetname"));
                }
            }
        }


        System.out.printf("Attacked planets: %s\n", AttackedPlanet.size());
        if (!AttackedPlanet.isEmpty()) {
            Collections.sort(AttackedPlanet);
            for (String s : AttackedPlanet) {
                System.out.printf("-> %s\n", s);
            }
        }
        System.out.printf("Destroyed planets: %s\n", DestroyedPlanet.size());
        if (!DestroyedPlanet.isEmpty()) {
            Collections.sort(DestroyedPlanet);
            for (String s : DestroyedPlanet) {
                System.out.printf("-> %s\n", s);
            }
        }
    }
}
