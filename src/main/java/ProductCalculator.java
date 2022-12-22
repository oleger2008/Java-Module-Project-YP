import java.util.Vector;

public class ProductCalculator {
    private double totalCost_ = 0.;
    private Vector<Product> products_ = new Vector<>();

    public void addProduct(Product product) {
        products_.add(product);
        totalCost_ += product.getPrice();
    }

    public void printAllProducts() {
        for (Product product : products_) {
            System.out.println(product.getName());
        }
    }

    public double getTotalCost() {
        return totalCost_;
    }
}
