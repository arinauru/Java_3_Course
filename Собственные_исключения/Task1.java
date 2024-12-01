class MyException extends Exception {
    public MyException() {
        super("Пользовательское исключение");
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Task1 {
    public static void main(String[] args) {
        try {
            ExceptionMethod();
        } catch (MyException e) {
            System.out.println("Обнаружено исключение: " + e.getMessage());
        }
    }

    public static void ExceptionMethod() throws MyException {
        boolean errorOccurred = true;
        if (errorOccurred) {
            throw new MyException("Ошибка: выполнена недопустимая операция!");
        }
    }
}
