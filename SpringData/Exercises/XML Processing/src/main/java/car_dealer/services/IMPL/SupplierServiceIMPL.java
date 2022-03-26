package car_dealer.services.IMPL;

import car_dealer.repositories.SupplierRepository;
import car_dealer.services.SupplierService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceIMPL implements SupplierService {
    private SupplierRepository supplierRepository;
    private Gson gson;

    @Autowired
    public SupplierServiceIMPL(SupplierRepository supplierRepository, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
    }

    @Override
    public String getSuppliersWithoutAbroadImportedParts() {
        return gson.toJson(supplierRepository.findSuppliersWithoutImportedPartsFromAbroad());
    }
}
