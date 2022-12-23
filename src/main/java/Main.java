import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите на сколько человек нужно разделить счёт:");
        int peopleAmount = readPeopleAmount();

        String command = "";
        final String endCommand = "завершить";
        while (!endCommand.equalsIgnoreCase(command)) {
            ProductCalculator.addProduct(readProduct());
            System.out.println("Если хотите завершить добавление товаров, то введите слово " +
                    "\"Завершить\".\n В противном случае введите, что угодно.");
            command = scanner.nextLine();
        }

        System.out.println("Добавленные товары:");
        ProductCalculator.printAllProducts();
        printAveragePrice(ProductCalculator.getTotalCost(), peopleAmount);
    }

    public static int readPeopleAmount() {
        int amount = 0;
        final int minPeopleAmount = 1;
        while (true) {
            String input = scanner.nextLine();
            try {
                amount = Integer.parseInt(input);
                if (amount >= minPeopleAmount) {
                    break;
                }
            } catch (NumberFormatException | NullPointerException ignored) {
            }
            System.out.println("Введите корректное количество человек:");
        }
        return amount;
    }

    public static Product readProduct() {
        System.out.println("Введите название товара, который хотите добавить:");
        String productName = scanner.nextLine();
        System.out.println("Введите стоимость этого товара:");
        double price = 0.;
        while (true) {
            String input = scanner.nextLine();
            try {
                price = Double.parseDouble(input);
                if (price > 0.) {
                    break;
                }
            } catch (NumberFormatException | NullPointerException ignored) {
            }
            System.out.println("Введите корректное значение цены товара '" + productName + "':");
        }
        return new Product(productName, price);
    }

    public static void printAveragePrice(double totalCost, int peopleAmount) {
        double avgPrice = totalCost / peopleAmount;
        System.out.println("\nКаждый должен заплатить по:");
        String rubleWord = getRubleWordByNum(avgPrice);
        System.out.println(String.format("%.2f %s", avgPrice, rubleWord));
    }

    public static String getRubleWordByNum(double rubles) {
        int roundedRubles = ((int) Math.floor(rubles));
        final int decimalBase = 10;
        final int hundredBase = 100;
        if (((roundedRubles % hundredBase) == 11) || ((roundedRubles % decimalBase) != 1)) {
            return "рублей";
        }
        return "рубль";
    }
}
