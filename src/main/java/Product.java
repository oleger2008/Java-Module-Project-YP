public class Product {
    private String name_;
    private double price_;

    Product(String name, double price) {
        name_ = name;
        price_ = price;
    }

    public String getName() {
        return name_;
    }

    public double getPrice() {
        return price_;
    }
}
