package car_dealer.services.IMPL;

import car_dealer.entities.cars.Car;
import car_dealer.entities.cars.CarImportDataDTO;
import car_dealer.entities.customers.Customer;
import car_dealer.entities.customers.CustomerImportDataDTO;
import car_dealer.entities.parts.Part;
import car_dealer.entities.parts.PartImportDataDTO;
import car_dealer.entities.sales.Discounts;
import car_dealer.entities.sales.Sale;
import car_dealer.entities.suppliers.Supplier;
import car_dealer.entities.suppliers.SupplierImportDataDTO;
import car_dealer.repositories.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import car_dealer.services.SeedService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import static car_dealer.messages.core.*;

@Service
public class SeedServiceIMPL implements SeedService {
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private Random random;

    @Autowired
    public SeedServiceIMPL(SupplierRepository supplierRepository, PartRepository partRepository, CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository, Gson gson, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        random = new Random();
    }

    @Override
    public void seedSuppliers() throws FileNotFoundException {
        if(supplierRepository.count()>0){
            return;
        }
        FileReader fileReader = new FileReader(PATH_OF_DATA_SUPPLIERS);

        List<Supplier> suppliers = Arrays.stream(gson.fromJson(fileReader, SupplierImportDataDTO[].class))
                .map(a->modelMapper.map(a,Supplier.class))
                .collect(Collectors.toList());

        supplierRepository.saveAll(suppliers);

        System.out.printf(DATABASE_IMPORTED,"suppliers");
    }

    @Override
    public void seedParts() throws FileNotFoundException {
        if(partRepository.count()>0){
            return;
        }

        FileReader fileReader = new FileReader(PATH_OF_DATA_PARTS);

        List<Part> parts = Arrays.stream(gson.fromJson(fileReader, PartImportDataDTO[].class))
                .map(a->modelMapper.map(a,Part.class))
                .map(this::getRandomSupplier)
                .collect(Collectors.toList());

        partRepository.saveAll(parts);
        System.out.printf(DATABASE_IMPORTED,"parts");
    }

    @Override
    public void seedCars() throws FileNotFoundException {
        if(carRepository.count()>0){
            return;
        }

        FileReader fileReader = new FileReader(PATH_OF_DATA_CARS);

        List<Car>cars = Arrays.stream(gson.fromJson(fileReader, CarImportDataDTO[].class))
                .map(a->modelMapper.map(a,Car.class))
                .map(this::getRandomCars)
                .collect(Collectors.toList());

        carRepository.saveAll(cars);
        System.out.printf(DATABASE_IMPORTED,"cars");
    }

    @Override
    public void seedCustomers() throws FileNotFoundException {
        if(customerRepository.count()>0){
            return;
        }

        FileReader fileReader = new FileReader(PATH_OF_DATA_CUSTOMERS);

        List<Customer>  customers= Arrays.stream(gson.fromJson(fileReader, CustomerImportDataDTO[].class))
                .map(a->modelMapper.map(a,Customer.class))
                .collect(Collectors.toList());

        customerRepository.saveAll(customers);
        System.out.printf(DATABASE_IMPORTED,"customers");
    }

    @Override
    public void seedSales(){
        if(saleRepository.count()>0){
            return;
        }
        List<Sale>sales = new ArrayList<>();
        List<Integer>carIds = new ArrayList<>();
        for(int i=1;i<=30;i++){
            int randomIndex = random.nextInt(8);

            Car car = getRandomCar(carIds);

            carIds.add(car.getId());

            Customer customer = getRandomCustomer();

            Sale sale = new Sale(car,customer);
            sale.setDiscount(Discounts.values()[randomIndex]);

            sales.add(sale);
        }

        saleRepository.saveAll(sales);
        System.out.printf(DATABASE_IMPORTED,"sales");
    }

    private Customer getRandomCustomer() {
        int  randomIndex = random.nextInt((int) customerRepository.count()) + 1;
        return customerRepository.findById(randomIndex).get();
    }

    private Car getRandomCars(Car car) {
        int randomIndex = random.nextInt(3)+3;
        Map<Integer,Part> parts = new LinkedHashMap<>();
        while(randomIndex-->0){
            Part part = getRandomPart();

            if(parts.containsKey(part.getId())){
                randomIndex++;
                continue;
            }

            parts.put(part.getId(),part);
        }

        Set<Part> input = new LinkedHashSet<>(parts.values());

        car.setParts(input);
        return car;
    }


    private Part getRandomPart(){
        int randomValue = random.nextInt((int)partRepository.count())+1;
        return partRepository.findById(randomValue).get();
    }

    private Part getRandomSupplier(Part part) {
        int randomIndex = random.nextInt((int)supplierRepository.count())+1;

        Supplier supplier = supplierRepository.findById(randomIndex).get();
        part.setSupplier(supplier);
        return part;
    }

    private Car getRandomCar(List <Integer> carIds) {
        int randomIndex;
        while(true) {
            randomIndex = random.nextInt((int) carRepository.count()) + 1;
            if(!carIds.contains(randomIndex)) {
                break;
            }
        }
        return carRepository.findById(randomIndex).get();
    }


}
