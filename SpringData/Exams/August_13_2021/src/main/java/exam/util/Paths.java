package exam.util;

import java.nio.file.Path;

public class Paths {
    private static final String CORE_PATH = Path.of("src","main","resources","files").toAbsolutePath().toString();

    public static final Path JSON_CUSTOMERS_DATA = Path.of(CORE_PATH,"json","customers.json");
    public static final Path JSON_LAPTOPS_DATA = Path.of(CORE_PATH,"json","laptops.json");
    public static final Path XML_SHOPS_DATA = Path.of(CORE_PATH,"xml","shops.xml");
    public static final Path XML_TOWNS_DATA = Path.of(CORE_PATH,"xml","towns.xml");

}
