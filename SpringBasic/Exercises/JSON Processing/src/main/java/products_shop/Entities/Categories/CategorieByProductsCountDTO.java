package products_shop.Entities.Categories;

import java.math.BigDecimal;

public class CategorieByProductsCountDTO {
    private String category;

    private long productCount;

    private double averagePrice;

    private BigDecimal totalRevenue;

    public CategorieByProductsCountDTO(String category) {
        this.category = category;
//        this.productCount = productCount;
//        this.averagePrice = averagePrice;
//        this.totalRevenue = totalRevenue;
    }

    public String getCategory() {
        return category;
    }

    public long getProductCount() {
        return productCount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }
}