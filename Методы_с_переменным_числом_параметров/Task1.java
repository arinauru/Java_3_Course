public class Task1 {
    // Метод для вывода суммы чисел
    public static void printSum(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);
    }

    // Перегруженный метод для вывода всех строк
    public static void printSum(String... strings) {
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    // Перегруженный метод для смешанных объектов
    public static void printSum(Object... objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        printSum(new int[]{1, 2, 3, 4, 5});

        printSum("Hello", "world", "this", "is", "Java");

        printSum(new Object[]{42, "Answer", 3.14, true});
    }
}
