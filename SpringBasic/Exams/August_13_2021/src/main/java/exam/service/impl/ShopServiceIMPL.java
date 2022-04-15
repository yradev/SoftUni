package exam.service.impl;

import exam.model.shop.ImportDTO.CollectionOfShopImportsDTO;
import exam.model.shop.ImportDTO.ShopImportDTO;
import exam.model.shop.Shop;
import exam.model.town.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.service.ValidatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static exam.util.Paths.XML_SHOPS_DATA;

@Service
public class ShopServiceIMPL implements ShopService {
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ValidatingService validatingService;
    private final ModelMapper modelMapper;

    @Autowired
    public ShopServiceIMPL(ShopRepository shopRepository, TownRepository townRepository, ValidatingService validatingService, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.validatingService = validatingService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count()>0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(XML_SHOPS_DATA);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(CollectionOfShopImportsDTO.class).createUnmarshaller();

        CollectionOfShopImportsDTO collectionOfShopImportsDTO = (CollectionOfShopImportsDTO) unmarshaller.unmarshal(XML_SHOPS_DATA.toFile());
        return collectionOfShopImportsDTO.getShops().stream()
                .map(this::importValidDataToDataBase)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importValidDataToDataBase(ShopImportDTO shopImportDTO){
        if(!validatingService.ValidateShop(shopImportDTO)) {
            return "Invalid Shop";
        }

        if (shopRepository.findShopByName(shopImportDTO.getName())!=null) {
            return "Invalid Shop";
        }

        Shop shop = modelMapper.map(shopImportDTO,Shop.class);
        Town town = townRepository.findTownByName(shopImportDTO.getTown().getName());
        shop.setTown(town);

        shopRepository.save(shop);
        return String.format("Successfully imported %s - %s",shop.getName(),shop.getIncome());
    }

}
