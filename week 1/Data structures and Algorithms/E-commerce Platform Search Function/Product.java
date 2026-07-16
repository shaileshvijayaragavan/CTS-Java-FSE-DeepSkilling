public class Product {

    private final int id;
    private final String name;
    private final String category;
    private final double price;
    private final double rating;

    public Product(int id, String name, String category, double price, double rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("#%d %-20s | %-12s | $%-8.2f | %.1f★",
                id, name, category, price, rating);
    }
}
