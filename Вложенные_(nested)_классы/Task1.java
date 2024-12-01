// Интерфейс с вложенным статическим классом
interface MyInterface {

    public static class NestedClass {
        private String message;

        public NestedClass(String message) {
            this.message = message;
        }

        public void printMessage() {
            System.out.println(message);
        }
    }
}

// Главный класс для демонстрации
public class Task1 {
    public static void main(String[] args) {
        MyInterface.NestedClass nestedClass = new MyInterface.NestedClass("Hello");
        nestedClass.printMessage();
    }
}
/*
Вложенные классы внутри интерфейсов всегда статические, потому что интерфейсы не могут
содержать нестатические члены.
Для создания экземпляра такого вложенного класса используется имя интерфейса.
Вложенный класс может содержать обычные методы и поля, как и любой другой класс, но он
связан с интерфейсом только через имя интерфейса.
 */