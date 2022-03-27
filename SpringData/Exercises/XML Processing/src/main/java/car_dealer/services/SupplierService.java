package car_dealer.services;

import javax.xml.bind.JAXBException;

public interface SupplierService {
    void getSuppliersWithoutAbroadImportedParts() throws JAXBException;
}
