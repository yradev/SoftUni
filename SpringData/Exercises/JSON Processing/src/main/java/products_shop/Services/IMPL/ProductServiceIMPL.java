package products_shop.Services.IMPL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.Entities.Categories.CategorieByProductsCountDTO;
import products_shop.Entities.Products.ProductsInRangeDTO;
import products_shop.Repositories.CategoryRepository;
import products_shop.Repositories.ProductRepository;
import products_shop.Services.ProductService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService {
    private ProductRepository productRepository;
    private Gson gson;

    @Autowired
    public ProductServiceIMPL(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void findProductsInRange(int start, int end) {
        List<ProductsInRangeDTO> products = productRepository.findProductsBySpecificPrice(BigDecimal.valueOf(start),BigDecimal.valueOf(end));
        System.out.println(gson.toJson(products));
    }

    @Override
    public void getCategorisFromProductsCount() {
        List<CategorieByProductsCountDTO> products = productRepository.findByProductsCount();
        System.out.println(gson.toJson(products));
    }
}
