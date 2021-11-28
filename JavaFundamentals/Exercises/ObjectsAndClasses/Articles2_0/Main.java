package JavaFundamentals.Exercises.ObjectsAndClasses.Articles2_0;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Article>ArticlesList = new ArrayList<>();
        int n=Integer.parseInt(input.nextLine());

        for(int i=1;i<=n;i++){
            List<String>Splitt = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());
            Article article = new Article(Splitt.get(0),Splitt.get(1),Splitt.get(2));
            ArticlesList.add(article);
        }

        List<Article>EndArray = new ArrayList<>();
        String command = input.nextLine();
        switch(command){
            case"title":
                EndArray = ArticlesList.stream()
                        .sorted(Comparator.comparing(a -> a.title))
                        .collect(Collectors.toList());
                break;
            case"content":
                EndArray = ArticlesList.stream()
                        .sorted(Comparator.comparing(a -> a.content))
                        .collect(Collectors.toList());
                break;
            case"author":
                EndArray = ArticlesList.stream()
                        .sorted(Comparator.comparing(a -> a.author))
                        .collect(Collectors.toList());
                break;
        }

        for (Article articleeee : EndArray) {
            System.out.println(articleeee);
        }

    }
}
