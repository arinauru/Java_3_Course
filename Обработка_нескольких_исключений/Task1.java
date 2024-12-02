// Класс пользовательских исключений с иерархией
class Ex1 extends Exception {
}

class Ex2 extends Ex1 {
}

class Ex3 extends Ex2 {
}

public class Task1 {
    public static void main(String[] args) {
        // Пример 1: Обработка нескольких исключений одинаковым образом
        try {
            throwRandomException();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println(e.getClass().getSimpleName());
        }

        // Пример 2: Обработка исключений, образующих иерархию
        try {
            throwEx3();
        } catch (Ex3 e) {
            System.out.println("Обработка Ex3");
        } catch (Ex2 e) {
            System.out.println("Обработка Ex2");
        } catch (Ex1 e) {
            System.out.println("Обработка Ex1");
        }
    }

    // Метод, выбрасывающий одно из стандартных исключений
    public static void throwRandomException() throws ArithmeticException, NullPointerException {
        if (Math.random() > 0.5) {
            throw new ArithmeticException("Деление на ноль");
        } else {
            throw new NullPointerException("Null-ссылка");
        }
    }

    // Метод, выбрасывающий исключение Ex3
    public static void throwEx3() throws Ex3 {
        throw new Ex3();
    }
}
