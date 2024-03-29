package car_dealer.controllers;

import car_dealer.services.CarService;
import car_dealer.services.CustomerService;
import car_dealer.services.SaleService;
import car_dealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

import static car_dealer.messages.core.*;
import static car_dealer.messages.core.EXERCISES_VALUES;

@Component
@Transactional
public class ExerciseController {

    private final CarService carService;
    private final CustomerService customerService;
    private final SupplierService supplierService;
    private final SaleService saleService;

    @Autowired
    public ExerciseController(CarService carService, CustomerService customerService, SupplierService supplierService, SaleService saleService) {
        this.carService = carService;
        this.customerService = customerService;
        this.supplierService = supplierService;
        this.saleService = saleService;
    }

    public void getInputRules() {
        System.out.println(INPUT_START);
        printExercise(
                "Ordered Customers",
                "Cars from Make Toyota",
                "Local Suppliers",
                "Cars with Their List of Parts",
                "Total Sales by Customer",
                "Sales with Applied Discount");
        System.out.println();
        System.out.println(ENTER_STOP);

    }

    public void getExercise(int number) throws JAXBException {
        switch (number){
            case 1 -> customerService.getCustomersOrderedByBirthdateThanByIsYoungDriver();
            case 2 -> carService.getCarsFromToyotaOrdered();
            case 3 -> supplierService.getSuppliersWithoutAbroadImportedParts();
            case 4 -> carService.getCarsWithTheirParts();
            case 5 -> customerService.getCustomersByTotalSpendMoney();
            case 6 -> saleService.getSalesWithDiscount();
            default -> System.out.println(INVALID_INPUT);
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("");
    }

    private void printExercise(String ... values){
        int count = 1;
        for (String value : values) {
            System.out.printf(EXERCISES_VALUES,count,value);
            count++;
        }

    }
}
