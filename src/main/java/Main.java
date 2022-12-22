import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите на сколько человек нужно разделить счёт:");
        int peopleAmount = readPeopleAmount();

        ProductCalculator calculator = new ProductCalculator();
        String command = "";
        final String endCommand = "завершить";
        while (!endCommand.equalsIgnoreCase(command)) {
            calculator.addProduct(readProduct());
            System.out.println("Если хотите завершить добавление товаров, то введите слово" +
                    "\"Завершить\".\n В противном случае введите, что угодно.");
            command = scanner.next();
        }

        System.out.println("Добавленные товары:");
        calculator.printAllProducts();
        printAveragePrice(calculator.getTotalCost(), peopleAmount);
    }

    public static int readPeopleAmount() {
        int peopleAmount = scanner.nextInt();
        while (peopleAmount < 1) {
            System.out.println("Введите корректное количество человек:");
            peopleAmount = scanner.nextInt();
        }
        return peopleAmount;
    }

    public static Product readProduct() {
        System.out.println("Введите название товара, который хотите добавить:");
        String productName = scanner.next();
        System.out.println("Введите стоимость этого товара:");
        double price = scanner.nextDouble();
        while (price < 0.) {
            System.out.println("Введите корректное значение цены товара '" + productName + "':");
            price = scanner.nextDouble();
        }
        return new Product(productName, price);
    }

    public static void printAveragePrice(double totalCost, int peopleAmount) {
        double avgPrice = totalCost / peopleAmount;
        System.out.println("Каждый должен заплатить по:");
        String rubleWord = (Math.floor(avgPrice) == 1.) ? "рубль" : "рубля";
        System.out.println(String.format("%.2f %s", avgPrice, rubleWord));
    }
}
