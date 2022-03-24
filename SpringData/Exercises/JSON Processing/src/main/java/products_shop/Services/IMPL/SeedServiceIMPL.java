package products_shop.Services.IMPL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.Entities.Categories.CategoriesDTO;
import products_shop.Entities.Categories.Category;
import products_shop.Entities.Products.Product;
import products_shop.Entities.Products.ProductDTO;
import products_shop.Entities.Users.User;
import products_shop.Entities.Users.UserSeedDTO;
import products_shop.Repositories.CategoryRepository;
import products_shop.Repositories.ProductRepository;
import products_shop.Repositories.UserRepository;
import products_shop.Services.SeedService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static products_shop.Messages.Core.*;

@Service
public class SeedServiceIMPL implements SeedService {

    private Path usersDataPath = Path.of("src","main","resources","Files","products_shop","users.json");
    private Path categoriesDataPath = Path.of("src","main","resources","Files","products_shop","categories.json");
    private Path productsDataPath = Path.of("src","main","resources","Files","products_shop","products.json");

    private Gson gson;
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private Random random;

    private ModelMapper modelMapper;
    @Autowired
    public SeedServiceIMPL(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        modelMapper = new ModelMapper();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        random = new Random();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        if(userRepository.count() > 0){
            throw new IllegalStateException(USERS_DATA_ALREADY_IMPORTED);
        }


        FileReader fileReader = new FileReader(usersDataPath.toAbsolutePath().toString());

        List<User> usersImport= Arrays.stream(gson.fromJson(fileReader, UserSeedDTO[].class))
                .map(a->modelMapper.map(a,User.class))
                .collect(Collectors.toList());

        userRepository.saveAll(usersImport);
        System.out.println(USERS_DATA_IMPORTED);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {

        if(productRepository.count()>0){
            throw new IllegalStateException(PRODUCTS_DATA_ALREADY_IMPORTED);
        }

        FileReader fileReader = new FileReader(productsDataPath.toAbsolutePath().toString());

        List<Product> productImport = Arrays.stream(gson.fromJson(fileReader, ProductDTO[].class))
                .map(a->modelMapper.map(a, Product.class))
                .map(this::SetSeller)
                .map(this::SetBuyer)
                .map(this::SetCategories)
                .collect(Collectors.toList());

        productRepository.saveAll(productImport);
        System.out.println(PRODUCTS_DATA_IMPORTED);
    }

    @Override
    public void seedCategories() throws FileNotFoundException {

        if(categoryRepository.count()>0){
            throw new IllegalStateException(CATEGORIES_DATA_ALREADY_IMPORTED);
        }
        FileReader fileReader = new FileReader(categoriesDataPath.toAbsolutePath().toString());

        List<Category> categoriesImport = Arrays.stream(gson.fromJson(fileReader, CategoriesDTO[].class))
                .map(a->modelMapper.map(a, Category.class))
                .collect(Collectors.toList());

        categoryRepository.saveAll(categoriesImport);
        System.out.println(CATEGORIES_DATA_IMPORTED);
    }

    private Product SetSeller(Product product){
        int userLength =  (int) userRepository.count();
        int index = random.nextInt(userLength)+1;
        product.setSeller(userRepository.findById(index).get());
        return product;
    }

    private Product SetBuyer(Product product){
        int userLength =  (int) userRepository.count();
        int index = random.nextInt(userLength)+1;
        int randomID = random.nextInt(index);
        if(randomID==0){
            return product;
        }
        product.setBuyer(userRepository.findById(randomID).get());
        return product;
    }

    private Product SetCategories(Product product){
        int categoryLength = (int)categoryRepository.count();
        int categoriesLength = random.nextInt(categoryLength)+1;

        Map<Integer,Category> categoryMap = new LinkedHashMap<>();

        int count = categoriesLength;

        while(count-->0){
            Category category = getRandomCategory();
            if(categoryMap.containsKey(category.getId())){
                count++;
                continue;
            }
            categoryMap.put(category.getId(),category);
        }

        Set<Category> categories = new LinkedHashSet<>(categoryMap.values());
        product.setCategories(categories);
        return product;
    }

    private Category getRandomCategory() {
        int categoryLength = (int)categoryRepository.count();
        int index = random.nextInt(categoryLength)+1;
        return categoryRepository.findById(index).get();
    }
}
