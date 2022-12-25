package homework_01;

public class task_01 {
    public static void main(String[] args) {
        int[] arrayOne = new int[]{1, 2, 3, 4, 5, 6};
        int[] arrayTwo = new int[]{0, 1, 2, 3, 4, 5};

        noindex(arrayOne, 3);
        divisZero(8, 2);

        int arrayO = arrayOne.length;
        int arrayT = arrayTwo.length;
        if (arrayO != arrayT) {
            throw new RuntimeException("Массивы разной длинны.");
        }
        else System.out.println("Массивы одной длины");
    }

    public static void noindex(int[] arrayOne, int index) {
        if (index > arrayOne.length - 1)
            throw new ArrayIndexOutOfBoundsException("Элемента с таким индексом не существует");
        else System.out.println("Элемент с индексом: " + index + " " + "равен: " + arrayOne[index]);
    }

    public static void divisZero(int numberOne, int numberTwo) {
        if (numberTwo == 0) throw new ArithmeticException("На ноль делить нельзя!");
        int result = numberOne / numberTwo;
        System.out.println("Результат деления: " + numberOne + " " + "на: " + numberTwo + " " + "равен: " + result);
    }

    public static void arrayEmpty(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            throw new RuntimeException("Длинны массивов не равны!");
        }
    }
}