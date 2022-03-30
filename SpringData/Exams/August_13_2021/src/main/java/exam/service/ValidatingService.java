package exam.service;

import exam.model.customer.ImportDTO.CustomerImportDTO;
import exam.model.laptop.ImportDTO.LaptopImportDTO;
import exam.model.shop.ImportDTO.ShopImportDTO;
import exam.model.town.ImportDTO.TownImportDTO;

public interface ValidatingService {
    boolean ValidateTown(TownImportDTO townImportDTO);
    boolean ValidateShop(ShopImportDTO shopImportDTO);
    boolean ValidateCustomer(CustomerImportDTO customerImportDTO);
    boolean ValidateLaptop(LaptopImportDTO laptopImportDTO);
}
