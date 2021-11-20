package bgStudent;

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
