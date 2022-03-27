package car_dealer.services.IMPL;

import car_dealer.entities.cars.Car;
import car_dealer.entities.cars.Import.CarsImportDataDTO;
import car_dealer.entities.customers.Customer;
import car_dealer.entities.customers.importDTO.CustomersImportDataDTO;
import car_dealer.entities.parts.Part;
import car_dealer.entities.parts.importDTO.PartsImportDataDTO;
import car_dealer.entities.sales.Discounts;
import car_dealer.entities.sales.Sale;
import car_dealer.entities.suppliers.Supplier;
import car_dealer.entities.suppliers.importDataDTO.SuppliersImportDataDTO;
import car_dealer.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import car_dealer.services.SeedService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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
    private final ModelMapper modelMapper;
    private Random random;

    @Autowired
    public SeedServiceIMPL(SupplierRepository supplierRepository, PartRepository partRepository, CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository,ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        random = new Random();
    }

    @Override
    public void seedSuppliers() throws FileNotFoundException, JAXBException {
        if(supplierRepository.count()>0){
            return;
        }

        FileReader fileReader = new FileReader(PATH_OF_DATA_SUPPLIERS);

        JAXBContext context = JAXBContext.newInstance(SuppliersImportDataDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        SuppliersImportDataDTO suppliersDTO = (SuppliersImportDataDTO) unmarshaller.unmarshal(fileReader);

        List<Supplier> suppliers = suppliersDTO.getSuppliers().stream()
                .map(a->modelMapper.map(a,Supplier.class))
                .collect(Collectors.toList());

        supplierRepository.saveAll(suppliers);

        System.out.printf(DATABASE_IMPORTED,"suppliers");
    }

    @Override
    public void seedParts() throws FileNotFoundException, JAXBException {
        if(partRepository.count()>0){
            return;
        }
        FileReader fileReader = new FileReader(PATH_OF_DATA_PARTS);

        JAXBContext context = JAXBContext.newInstance(PartsImportDataDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        PartsImportDataDTO partsDTO = (PartsImportDataDTO) unmarshaller.unmarshal(fileReader);


        List<Part> parts = partsDTO.getParts().stream()
                .map(a->modelMapper.map(a,Part.class))
                .map(this::getRandomSupplier)
                .collect(Collectors.toList());

        partRepository.saveAll(parts);
        System.out.printf(DATABASE_IMPORTED,"parts");
    }

    @Override
    public void seedCars() throws FileNotFoundException, JAXBException {
        if(carRepository.count()>0){
            return;
        }

        FileReader fileReader = new FileReader(PATH_OF_DATA_CARS);

        CarsImportDataDTO carsDTO = (CarsImportDataDTO) JAXBContext.newInstance(CarsImportDataDTO.class).createUnmarshaller().unmarshal(fileReader);


        List<Car>cars = carsDTO.getCars().stream()
                .map(a->modelMapper.map(a,Car.class))
                .map(this::getRandomCars)
                .collect(Collectors.toList());

        carRepository.saveAll(cars);
        System.out.printf(DATABASE_IMPORTED,"cars");
    }

    @Override
    public void seedCustomers() throws FileNotFoundException, JAXBException {
        if(customerRepository.count()>0){
            return;
        }
        FileReader fileReader = new FileReader(PATH_OF_DATA_CUSTOMERS);

        CustomersImportDataDTO customersDTO = (CustomersImportDataDTO) JAXBContext.newInstance(CustomersImportDataDTO.class).createUnmarshaller().unmarshal(fileReader);


        List<Customer>  customers= customersDTO.getCustomers().stream()
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
