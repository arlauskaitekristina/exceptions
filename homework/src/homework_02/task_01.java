package homework_02;

import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {
        System.out.println("Введите вещественное число: ");
        float number = getNumber(new Scanner(System.in));
        System.out.printf("Ваше число: %f", number);
    }
    private static float getNumber(Scanner scan) {
        float number = 0;
        String input = scan.next();
        try {
            number = Float.parseFloat(input);
            return number;
        } catch (Exception e) {
            System.out.println("Неверно введено число!");
            System.out.println("Попробуйте ещё: ");
            number = getNumber(scan);
        }
        return number;
    }
}