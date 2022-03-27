package car_dealer.services.IMPL;

import car_dealer.entities.sales.CollectionsDTO.CollectionOfSaleWithDiscount;
import car_dealer.entities.sales.SaleWithDiscount;
import car_dealer.repositories.SaleRepository;
import car_dealer.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceIMPL implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public SaleServiceIMPL(SaleRepository saleRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void getSalesWithDiscount() throws JAXBException {
        List<SaleWithDiscount> sales = saleRepository.findAll().stream().map(a->modelMapper.map(a,SaleWithDiscount.class))
                .map(this::setPrice)
                .map(this::setPriceWithDiscount)
                .collect(Collectors.toList());
        CollectionOfSaleWithDiscount input = new CollectionOfSaleWithDiscount(sales);
        Marshaller marshaller = JAXBContext.newInstance(CollectionOfSaleWithDiscount.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(input,System.out);
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
