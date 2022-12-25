package homework_01;
import java.util.ArrayList;
import java.util.Arrays;


public class task_02 {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 6};
        int[] arrayTwo = {0, 1, 2, 3, 4, 5};
        System.out.println("Первый массив: " + Arrays.toString(arrayOne));
        System.out.println("Второй массив: " + Arrays.toString(arrayTwo));
        System.out.println("Разница двух  массивов: " + arrayDifference(arrayOne, arrayTwo));
    }

    public static ArrayList<Integer> arrayDifference(int[] aOne, int[] aTwo) {
        ArrayList<Integer> res = new ArrayList<>();
        int min = Math.min(aOne.length, aTwo.length);
        int max = Math.max(aOne.length, aTwo.length);
        if (min < 1) {
            throw new RuntimeException("Один из массивов пуст!");
        }
        if (min < max) {
            throw new RuntimeException("Длинны массивов не равны!");
        }
        for (int i = 0; i < min; i++) {
            res.add(aOne[i] - aTwo[i]);
        }
        return res;
    }
}
