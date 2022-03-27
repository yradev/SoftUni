package car_dealer.services.IMPL;

import car_dealer.entities.suppliers.CollectionsDTO.CollectionOfSuppliersWithoutImportedPartsFromAbroad;
import car_dealer.entities.suppliers.SupplierWithoutImportedPartsFromAbroad;
import car_dealer.repositories.SupplierRepository;
import car_dealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;

@Service
public class SupplierServiceIMPL implements SupplierService {
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceIMPL(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void getSuppliersWithoutAbroadImportedParts() throws JAXBException {
        List<SupplierWithoutImportedPartsFromAbroad>supplierWithoutImportedPartsFromAbroads = supplierRepository.findSuppliersWithoutImportedPartsFromAbroad();
        CollectionOfSuppliersWithoutImportedPartsFromAbroad input = new CollectionOfSuppliersWithoutImportedPartsFromAbroad(supplierWithoutImportedPartsFromAbroads);
        Marshaller marshaller = JAXBContext.newInstance(CollectionOfSuppliersWithoutImportedPartsFromAbroad.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(input,System.out);

    }
}
