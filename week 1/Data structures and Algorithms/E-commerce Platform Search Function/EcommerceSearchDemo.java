import java.util.List;

public class EcommerceSearchDemo {

    public static void main(String[] args) {
        ProductSearchEngine engine = new ProductSearchEngine();

        engine.addProduct(new Product(1, "Wireless Mouse", "Electronics", 19.99, 4.2));
        engine.addProduct(new Product(2, "Mechanical Keyboard", "Electronics", 59.99, 4.6));
        engine.addProduct(new Product(3, "Wireless Headphones", "Electronics", 89.99, 4.4));
        engine.addProduct(new Product(4, "Running Shoes", "Footwear", 49.99, 4.1));
        engine.addProduct(new Product(5, "Wireless Earbuds", "Electronics", 29.99, 3.9));
        engine.addProduct(new Product(6, "Leather Wallet", "Accessories", 24.99, 4.7));
        engine.addProduct(new Product(7, "Yoga Mat", "Fitness", 15.99, 4.3));

        System.out.println("Catalog size: " + engine.catalogSize());

        System.out.println("\nSearch: keyword='wireless'");
        List<Product> wireless = engine.search("wireless", null, -1, -1, -1);
        wireless.forEach(System.out::println);

        System.out.println("\nSearch: category='Electronics', minRating=4.3");
        List<Product> filtered = engine.search(null, "Electronics", -1, -1, 4.3);
        filtered.forEach(System.out::println);

        System.out.println("\nSearch: price between $15 and $30");
        List<Product> priceRange = engine.search(null, null, 15, 30, -1);
        engine.sortByPrice(priceRange, true);
        priceRange.forEach(System.out::println);

        System.out.println("\nAll Electronics sorted by rating (highest first)");
        List<Product> electronics = engine.search(null, "Electronics", -1, -1, -1);
        engine.sortByRatingDescending(electronics);
        electronics.forEach(System.out::println);

        System.out.println("\nPrefix search: 'Wir'");
        List<Product> prefixResults = engine.searchByPrefix("Wir");
        prefixResults.forEach(System.out::println);
    }
}
