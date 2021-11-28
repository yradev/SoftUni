package JavaFundamentals.Exercises.ObjectsAndClasses.Articles2_0;

public class Article {
     String title;
    String content;
    String author;

    public Article(String title, String content, String author) {
        this.title=title;
        this.content=content;
        this.author=author;
    }

    @Override
    public String toString(){return title + " - "+content+": "+author;}
}
