package products_shop.Services.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.Entities.Categories.CategorieByProductsCountDTO;
import products_shop.Entities.Categories.Collections.CollectionOfCategorieByProductCountDTO;
import products_shop.Entities.Products.Collections.CollectionProductInRangeDTO;
import products_shop.Repositories.CategoryRepository;
import products_shop.Repositories.ProductRepository;
import products_shop.Services.ProductService;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void findProductsInRange(int start, int end) throws JAXBException {
        CollectionProductInRangeDTO products = new CollectionProductInRangeDTO(
                productRepository.findProductsBySpecificPrice(BigDecimal.valueOf(start),BigDecimal.valueOf(end)));

        Marshaller marshaller = JAXBContext.newInstance(CollectionProductInRangeDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(products,System.out);
    }

    @Override
    public void getCategorisFromProductsCount() throws JAXBException {
        List<CategorieByProductsCountDTO> products = categoryRepository.findByProductsCount();
        CollectionOfCategorieByProductCountDTO collectionProducts = new CollectionOfCategorieByProductCountDTO(products);
        Marshaller marshaller = JAXBContext.newInstance(CollectionOfCategorieByProductCountDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(collectionProducts,System.out);
    }
}
