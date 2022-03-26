package car_dealer.services.IMPL;

import car_dealer.entities.cars.Car;
import car_dealer.entities.cars.CarWithPartsDTO;
import car_dealer.repositories.CarRepository;
import car_dealer.services.CarService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceIMPL implements CarService {
    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceIMPL(CarRepository carRepository, Gson gson, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public String getCarsFromToyotaOrdered() {
        return gson.toJson(carRepository.findCarsFromToyota());
    }

    @Override
    public String getCarsWithTheirParts() {
        List<CarWithPartsDTO> carsDTO = carRepository.findAll().stream().map(a->modelMapper.map(a,CarWithPartsDTO.class)).collect(Collectors.toList());

        return gson.toJson(carsDTO);
    }
}
