package homework_02;

import java.util.Scanner;

public class task_04 {
    public static void main(String[] args) {
        System.out.println("Введите непустую строку: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }
        System.out.println("Ваша строка: " + s);
    }
}
