package car_dealer.services.IMPL;

import car_dealer.entities.sales.SaleWithDiscount;
import car_dealer.repositories.SaleRepository;
import car_dealer.services.SaleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceIMPL implements SaleService {
    private final SaleRepository saleRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;


    @Autowired
    public SaleServiceIMPL(SaleRepository saleRepository, Gson gson, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public String getSalesWithDiscount() {
        Gson tempGson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        List<SaleWithDiscount> sales = saleRepository.findAll().stream().map(a->modelMapper.map(a,SaleWithDiscount.class))
                .map(this::setPrice)
                .map(this::setPriceWithDiscount)
                .collect(Collectors.toList());
        return tempGson.toJson(sales);
    }

    private SaleWithDiscount setPriceWithDiscount(SaleWithDiscount sale) {
        BigDecimal priceWithoutDiscount = sale.getPrice();
        BigDecimal price = priceWithoutDiscount.subtract(priceWithoutDiscount.multiply(BigDecimal.valueOf(sale.getDiscount().getValue())));
        sale.setPriceWithDiscount(price);
        return sale;
    }

    private SaleWithDiscount setPrice(SaleWithDiscount sale) {
        double price = sale.getCar().getParts().stream().mapToDouble(a->Double.parseDouble(a.getPrice().toString())).sum();
        sale.setPrice(BigDecimal.valueOf(price));
        return sale;
    }
}
