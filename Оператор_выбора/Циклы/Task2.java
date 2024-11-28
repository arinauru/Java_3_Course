public class Task2 {
    public static void main(String[] args) {
        // Пример с оператором break
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("i = " + i);
        }

        // Пример с оператором continue
        int count = 0;
        while (count < 10) {
            count++;
            if (count % 2 == 0) {
                continue;
            }
            System.out.println("Count = " + count);
        }

        // Пример for-each с оператором break
        int[] numbers = {1, 3, 5, 7, 9};
        for (int num : numbers) {
            if (num == 5) {
                break;
            }
            System.out.println("num = " + num);
        }

        // Пример for-each с оператором continue
        for (int num : numbers) {
            if (num % 3 == 0) {
                continue;
            }
            System.out.println("num = " + num);
        }
    }
}
