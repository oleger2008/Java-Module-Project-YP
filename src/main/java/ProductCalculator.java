import java.util.Vector;

public class ProductCalculator {
    private double totalCost_ = 0.;
    private Vector<String> products_ = new Vector<>();

    public void addProduct(Product product) {
        products_.add(product.getName());
        totalCost_ += product.getPrice();
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
