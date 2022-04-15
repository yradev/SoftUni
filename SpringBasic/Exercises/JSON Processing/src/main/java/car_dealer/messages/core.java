package car_dealer.messages;

import java.nio.file.Path;

public class core {
    public final static String DATABASE_IMPORTED = "Successfully imported data into table '%s'.\n";
    public final static String PATH_OF_DATA_SUPPLIERS = Path.of("src","main","resources","Files","car_dealer","suppliers.json").toAbsolutePath().toString();
    public final static String PATH_OF_DATA_PARTS = Path.of("src","main","resources","Files","car_dealer","parts.json").toAbsolutePath().toString();
    public final static String PATH_OF_DATA_CARS = Path.of("src","main","resources","Files","car_dealer","cars.json").toAbsolutePath().toString();
    public final static String PATH_OF_DATA_CUSTOMERS = Path.of("src","main","resources","Files","car_dealer","customers.json").toAbsolutePath().toString();
    public final static String INPUT_START = "Enter which one of exercises you want to test:\n";
    public final static String EXERCISES_VALUES = "Enter '%s' to test '%s'!\n";
    public final static String ENTER_STOP = "Enter 'Stop' to stop the program!";
    public final static String INVALID_INPUT = "Your input is invalid!";



}
