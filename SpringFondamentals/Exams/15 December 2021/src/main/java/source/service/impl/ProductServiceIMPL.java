package source.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import source.model.dto.AddProductDTO;
import source.model.dto.ProductViewDTO;
import source.model.entity.Product;
import source.repository.ProductRepository;
import source.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceIMPL implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceIMPL(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(AddProductDTO addProductDTO) {
        productRepository.save(modelMapper.map(addProductDTO, Product.class));
    }

    @Override
    public List<ProductViewDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity,ProductViewDTO.class))
                .peek(dto -> dto.setUrl(String.format("/img/%s.png",dto.getCategory())))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.getById(id));
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
