package List;

import java.util.*;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random index = new Random();
        List<String>Phrases = Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product.");
        List<String>Events = Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!");
        List<String>Authors = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String>Citites = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");
        int PhrasesLoot = index.nextInt(Phrases.size());
        int EventsLoot= index.nextInt(Events.size());
        int AuthorsLoot = index.nextInt(Authors.size());
        int CitiesLoot = index.nextInt(Citites.size());

        Advertisement adv = new Advertisement(Phrases.get(PhrasesLoot),Events.get(EventsLoot),Authors.get(AuthorsLoot),Citites.get(CitiesLoot));
    }
}


class Advertisement {
    String Phrases;
    String Events;
    String Authors;
    String Citites;

    public Advertisement(String a, String b, String c, String d) {
        this.Phrases=a;
        this.Events=b;
        this.Authors=c;
        this.Citites=d;

        System.out.printf("%s %s %s - %s",a,b,c,d);
    }
}
