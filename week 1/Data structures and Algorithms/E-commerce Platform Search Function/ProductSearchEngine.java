import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductSearchEngine {

    private final List<Product> catalog;

    public ProductSearchEngine() {
        this.catalog = new ArrayList<>();
    }

    public void addProduct(Product product) {
        catalog.add(product);
    }

    public List<Product> search(String keyword, String category,
                                 double minPrice, double maxPrice, double minRating) {
        List<Product> results = new ArrayList<>();

        for (Product p : catalog) {
            if (keyword != null && !keyword.isEmpty()
                    && !p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                continue;
            }
            if (category != null && !category.isEmpty()
                    && !p.getCategory().equalsIgnoreCase(category)) {
                continue;
            }
            if (minPrice >= 0 && p.getPrice() < minPrice) {
                continue;
            }
            if (maxPrice >= 0 && p.getPrice() > maxPrice) {
                continue;
            }
            if (minRating >= 0 && p.getRating() < minRating) {
                continue;
            }
            results.add(p);
        }
        return results;
    }

    public List<Product> searchByPrefix(String prefix) {
        List<Product> results = new ArrayList<>();
        String lowerPrefix = prefix.toLowerCase();
        for (Product p : catalog) {
            if (p.getName().toLowerCase().startsWith(lowerPrefix)) {
                results.add(p);
            }
        }
        return results;
    }

    public void sortByPrice(List<Product> products, boolean ascending) {
        Comparator<Product> byPrice = Comparator.comparingDouble(Product::getPrice);
        products.sort(ascending ? byPrice : byPrice.reversed());
    }

    public void sortByRatingDescending(List<Product> products) {
        products.sort(Comparator.comparingDouble(Product::getRating).reversed());
    }

    public int catalogSize() {
        return catalog.size();
    }
}
