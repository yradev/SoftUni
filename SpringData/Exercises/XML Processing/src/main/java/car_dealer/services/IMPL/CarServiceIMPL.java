package car_dealer.services.IMPL;

import car_dealer.entities.cars.CarWithPartsDTO;
import car_dealer.entities.cars.CarFromToyotaDTO;
import car_dealer.entities.cars.Collections.CollectionOfCarsFromToyotaDTO;
import car_dealer.entities.cars.Collections.CollectionOfCarsWithPartsDTO;
import car_dealer.repositories.CarRepository;
import car_dealer.services.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceIMPL implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceIMPL(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void getCarsFromToyotaOrdered() throws JAXBException {

        List<CarFromToyotaDTO> cars = carRepository.findCarsFromToyota();

        CollectionOfCarsFromToyotaDTO input = new CollectionOfCarsFromToyotaDTO(cars);

        Marshaller marshaller = JAXBContext.newInstance(CollectionOfCarsFromToyotaDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(input,System.out);
    }

    @Override
    public void getCarsWithTheirParts() throws JAXBException {
        List<CarWithPartsDTO> carsDTO = carRepository.findAll().stream().map(a->modelMapper.map(a,CarWithPartsDTO.class)).collect(Collectors.toList());

        CollectionOfCarsWithPartsDTO input = new CollectionOfCarsWithPartsDTO(carsDTO);

        Marshaller marshaller = JAXBContext.newInstance(CollectionOfCarsWithPartsDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(input,System.out);

    }
}
