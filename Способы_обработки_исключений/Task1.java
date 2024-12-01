public class Task1 {
    public static void main(String[] args) {
        try {
            // Генерация и обработка исключения
            int result = divide(10, 0); // Деление на ноль
            System.out.println(result);

            // Генерация необработанного исключения
            throwUncheckedException();

            System.out.println("Это сообщение не будет напечатано."); // Никогда не выполнится
        } catch (ArithmeticException e) {
            System.out.println("Исключение обработано: " + e.getMessage());
        }

        System.out.println("Программа продолжает выполняться.");

        // Генерация необработанного исключения
        throwUncheckedException(); // Приведет к аварийной остановке
    }

    // ArithmeticException
    public static int divide(int a, int b) {
        return a / b; // Деление на ноль вызовет ArithmeticException
    }

    // RuntimeException
    public static void throwUncheckedException() {
        throw new RuntimeException("Неперехваченное исключение!");
    }
}
