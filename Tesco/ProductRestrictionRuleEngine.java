package Tesco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    private int productId;
    private String category;
    private int quantity;

    public Product(int productId, String category, int quantity) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}

class RestrictionRules {
    private int bulkBuyLimit;
    private int bulkBuyLimitCategory;
    private Map<String, Integer> categoryQuantityMap;

    public RestrictionRules(int bulkBuyLimit, int bulkBuyLimitCategory) {
        this.bulkBuyLimit = bulkBuyLimit;
        this.bulkBuyLimitCategory = bulkBuyLimitCategory;
        this.categoryQuantityMap = new HashMap<>();
    }

    public void addCategoryQuantity(String category, int quantity) {
        categoryQuantityMap.put(category, quantity);
    }

    public String checkRestrictions(List<Product> products) {
        for (Product product : products) {
            if (product.getQuantity() > bulkBuyLimit) {
                return "BREACHED";
            }

            if (product.getCategory().equals("Paracetamol") && product.getQuantity() > bulkBuyLimitCategory) {
                return "BREACHED";
            }

            if (categoryQuantityMap.containsKey(product.getCategory())) {
                int maxQuantityForCategory = categoryQuantityMap.get(product.getCategory());
                if (product.getQuantity() > maxQuantityForCategory) {
                    return "BREACHED";
                }
            }
        }
        return "MET";
    }
}
public class ProductRestrictionRuleEngine {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Paracetamol", 3));
        products.add(new Product(2, "analgesic", 3));
        products.add(new Product(3, "chocolate", 8));
        products.add(new Product(4, "Paracetamol", 2));

        RestrictionRules rules = new RestrictionRules(10, 5);
        rules.addCategoryQuantity("chocolate", 15); // Example additional rule for chocolate category

        String status = rules.checkRestrictions(products);
        System.out.println("Restriction status: " + status);
    }
}