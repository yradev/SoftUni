package exam.service.impl;

import com.google.gson.Gson;
import exam.model.laptop.BestLaptopDTO;
import exam.model.laptop.ImportDTO.LaptopImportDTO;
import exam.model.laptop.Laptop;
import exam.model.shop.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.service.ValidatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import static exam.util.Paths.JSON_CUSTOMERS_DATA;
import static exam.util.Paths.JSON_LAPTOPS_DATA;

@Service
public class LaptopServiceIMPL implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final ValidatingService validatingService;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public LaptopServiceIMPL(LaptopRepository laptopRepository, ShopRepository shopRepository, ValidatingService validatingService, Gson gson, ModelMapper modelMapper) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.validatingService = validatingService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count()>0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(JSON_LAPTOPS_DATA);
    }

    @Override
    public String importLaptops() throws IOException {
        return Arrays.stream(gson.fromJson(Files.readString(JSON_LAPTOPS_DATA),LaptopImportDTO[].class))
                .map(this::importValidRecordToDataBase)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportBestLaptops() {
        return laptopRepository.findBestLaptops().stream()
                .map(a->modelMapper.map(a, BestLaptopDTO.class))
                .map(BestLaptopDTO::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importValidRecordToDataBase(LaptopImportDTO laptopImportDTO){
        if(!validatingService.ValidateLaptop(laptopImportDTO)){
            return "Invalid Laptop";
        }

        if(laptopRepository.findLaptopByMacAddress(laptopImportDTO.getMacAddress())!=null){
            return "Invalid Laptop";
        }

        Laptop laptop = modelMapper.map(laptopImportDTO,Laptop.class);

        Shop shop = shopRepository.findShopByName(laptopImportDTO.getShop().getName());

        laptop.setShop(shop);

        laptopRepository.save(laptop);
        return String.format("Successfully imported Laptop %s - %.2f - %s - %s",laptop.getMacAddress(),laptop.getCpuSpeed(),laptop.getRam(),laptop.getStorage());
    }
}
