package car_dealer.entities.cars.Collections;

import car_dealer.entities.cars.CarFromToyotaDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfCarsFromToyotaDTO {
    @XmlElement(name = "car")
    private List<CarFromToyotaDTO> cars;

    public CollectionOfCarsFromToyotaDTO() {
    }

    public CollectionOfCarsFromToyotaDTO(List<CarFromToyotaDTO> cars) {
        this.cars = cars;
    }

    public List<CarFromToyotaDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarFromToyotaDTO> cars) {
        this.cars = cars;
    }
}
