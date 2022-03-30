package exam.service.impl;

import exam.model.customer.ImportDTO.CustomerImportDTO;
import exam.model.laptop.ImportDTO.LaptopImportDTO;
import exam.model.shop.ImportDTO.ShopImportDTO;
import exam.model.town.ImportDTO.TownImportDTO;
import exam.service.ValidatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidatingServiceIMPL implements ValidatingService {

    private final Validator validator;

    @Autowired
    public ValidatingServiceIMPL(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean ValidateTown(TownImportDTO townImportDTO) {
        Set<ConstraintViolation<TownImportDTO>> validate = validator.validate(townImportDTO);
        return validate.isEmpty();
    }

    @Override
    public boolean ValidateShop(ShopImportDTO shopImportDTO) {
        Set<ConstraintViolation<ShopImportDTO>> validate = validator.validate(shopImportDTO);
        return validate.isEmpty();

    }

    @Override
    public boolean ValidateCustomer(CustomerImportDTO customerImportDTO) {
        Set<ConstraintViolation<CustomerImportDTO>> validate = validator.validate(customerImportDTO);
        return validate.isEmpty();

    }

    @Override
    public boolean ValidateLaptop(LaptopImportDTO laptopImportDTO) {
        Set<ConstraintViolation<Object>> validate = validator.validate(laptopImportDTO);
        return validate.isEmpty();

    }
}
