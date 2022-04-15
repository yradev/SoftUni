package products_shop.Services;

import javax.xml.bind.JAXBException;

public interface ProductService {
    void findProductsInRange(int Start, int End) throws JAXBException;
    void getCategorisFromProductsCount() throws JAXBException;
}
