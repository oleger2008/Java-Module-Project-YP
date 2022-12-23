import java.util.ArrayList;

public class ProductCalculator {
    private static double totalCost_ = 0.;
    private static ArrayList<String> products_ = new ArrayList<>();

    public static void addProduct(Product product) {
        products_.add(product.getName());
        totalCost_ += product.getPrice();
    }

    public static void printAllProducts() {
        for (String product : products_) {
            System.out.println(product);
        }
    }

    public static double getTotalCost() {
        return totalCost_;
    }
}
