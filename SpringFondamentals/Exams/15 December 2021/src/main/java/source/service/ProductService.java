package source.service;

import source.model.dto.AddProductDTO;
import source.model.dto.ProductViewDTO;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductDTO addProductDTO);
    List<ProductViewDTO> getAllProducts();
    void deleteProduct(Long id);

    void deleteAllProducts();
}
