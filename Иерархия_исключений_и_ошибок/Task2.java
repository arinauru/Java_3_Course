public class Task2 {
    public static void main(String[] args) {
        // Пример 1: ArithmeticException
        try {
            int n = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        // Пример 2: ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обращение к несуществующему индексу массива");
        }

        // Пример 3: IllegalArgumentException
        try {
            printSquareRoot(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Пример 4: ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("Неверное приведение типов");
        }

        // Пример 5: NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Обращение к null-объекту");
        }
    }

    // Метод для демонстрации IllegalArgumentException
    public static void printSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число отрицательное");
        }
        System.out.println(Math.sqrt(number));
    }
}
