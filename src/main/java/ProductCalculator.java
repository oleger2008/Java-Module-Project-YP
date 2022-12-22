import java.util.Vector;

public class ProductCalculator {
    private double totalCost_ = 0.;
    private final Vector<String> products_ = new Vector<>();

    public void addProduct(String name, double price) {
        products_.add(name);
        totalCost_ += price;
    }

    public void printAllProducts() {
        for (String product : products_) {
            System.out.println(product);
        }
    }

    public double getTotalCost() {
        return totalCost_;
    }
}
