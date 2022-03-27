package car_dealer.services;

import javax.xml.bind.JAXBException;

public interface CarService {
    void getCarsFromToyotaOrdered() throws JAXBException;
    void getCarsWithTheirParts() throws JAXBException;
}
