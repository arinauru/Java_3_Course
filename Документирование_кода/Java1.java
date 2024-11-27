/**
 * Класс Calculator выполняет базовые арифметические операции.
 *
 * @author Арина
 * @version 1.0
 */
public class Java1 {

    /**
     * Складывает два числа.
     *
     * @param a первое число
     * @param b второе число
     * @return результат сложения
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Делит два числа.
     *
     * @param a делимое
     * @param b делитель
     * @return результат деления
     * @throws ArithmeticException если делитель равен нулю
     */
    public static double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) a / b;
    }

    /**
     * Главная функция вызова для проверки функционала.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Тестируем сложение
        System.out.println("add(1, 2) = " + add(1, 2));

        // Тестируем деление
        System.out.println("divide(1, 2) = " + divide(1, 2));

        // Тестируем деление на ноль
        try {
            System.out.println("divide(13, 0) = " + divide(13, 0));
        } catch (ArithmeticException e) {
            System.out.println("divide(13, 0) исключение: " + e.getMessage());
        }
    }
}
