import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введи на сколько человек нужно разделить счёт:");
        Scanner scanner = new Scanner(System.in);
        int peopleAmount = scanner.nextInt();
        while (peopleAmount < 1) {
            System.out.println("Введите корректное количество человек:");
            peopleAmount = scanner.nextInt();
        }
    }
}
