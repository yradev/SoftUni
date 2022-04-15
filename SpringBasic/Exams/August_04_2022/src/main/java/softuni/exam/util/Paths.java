package softuni.exam.util;

import java.nio.file.Path;

public class Paths {
    private static final String BASE_PATH = Path.of("src","main","resources","files").toAbsolutePath().toString();

    public static final Path AGENTS_DATA = Path.of(BASE_PATH,"json","agents.json");
    public static final Path TOWNS_DATA = Path.of(BASE_PATH,"json","towns.json");
    public static final Path APARTMENTS_DATA = Path.of(BASE_PATH,"xml","apartments.xml");
    public static final Path OFFERS_DATA = Path.of(BASE_PATH,"xml","offers.xml");

}
