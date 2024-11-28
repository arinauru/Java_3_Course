import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        // Пример 1: Использование метода toString
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr1)); // Выводит: [1, 2, 3, 4, 5]

        // Пример 2: Использование метода binarySearch
        int index = Arrays.binarySearch(arr1, 3);
        System.out.println(index); // Выводит: Index of 3: 2

        // Пример 3: Использование метода equals
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {4, 5, 6};

        System.out.println(Arrays.equals(arr1, arr2)); // true
        System.out.println(Arrays.equals(arr1, arr3)); // false

        // Пример 4: Использование метода compare
        int[] arr4 = {1, 2, 3};
        int[] arr5 = {1, 2, 4};

        int res = Arrays.compare(arr4, arr5);
        System.out.println(res); // Выводит: -1 (arr4 < arr5)

        // Пример 5: Использование метода sort
        int[] arr6 = {5, 2, 9, 1, 3};
        Arrays.sort(arr6);
        System.out.println(Arrays.toString(arr6)); // Выводит: [1, 2, 3, 5, 9]
    }
}
