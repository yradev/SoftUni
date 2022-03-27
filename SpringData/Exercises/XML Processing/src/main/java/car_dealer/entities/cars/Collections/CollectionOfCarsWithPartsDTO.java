package car_dealer.entities.cars.Collections;

import car_dealer.entities.cars.CarWithPartsDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfCarsWithPartsDTO {
    @XmlElement(name = "car")
    private List<CarWithPartsDTO> cars;

    public CollectionOfCarsWithPartsDTO(){}

    public CollectionOfCarsWithPartsDTO(List<CarWithPartsDTO> cars) {
        this.cars = cars;
    }

    public List<CarWithPartsDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarWithPartsDTO> cars) {
        this.cars = cars;
    }
}
