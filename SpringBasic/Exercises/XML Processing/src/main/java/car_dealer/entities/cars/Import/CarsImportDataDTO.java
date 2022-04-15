package car_dealer.entities.cars.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsImportDataDTO
{
    @XmlElement(name = "car")
    private List<CarImportDataDTO> cars;

    public List<CarImportDataDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarImportDataDTO> cars) {
        this.cars = cars;
    }
}
