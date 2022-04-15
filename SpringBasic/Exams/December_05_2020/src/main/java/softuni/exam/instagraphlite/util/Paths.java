package softuni.exam.instagraphlite.util;

import java.nio.file.Path;

public class Paths {
    private static final String BASE_PATH = Path.of("src","main","resources","files").toAbsolutePath().toString();

    public static final Path PICTURES_DATA = Path.of(BASE_PATH,"pictures.json");
    public static final Path POSTS_DATA = Path.of(BASE_PATH,"posts.xml");
    public static final Path USERS_DATA = Path.of(BASE_PATH, "users.json");
}
