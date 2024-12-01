public class Task2 {
    // Поля с разными уровнями доступа
    private String privateField = "Private Field";
    protected String protectedField = "Protected Field";
    String defaultField = "Default Field";
    public String publicField = "Public Field";

    // Статическое поле
    private static String staticField = "Static Field";

    // Приватный метод
    private void privateMethod() {
        System.out.println("Private method called");
    }

    // Внутренний класс
    public class InnerClass {
        public void accessFields() {
            // Доступ ко всем полям внешнего класса
            System.out.println("Accessing fields from InnerClass:");
            System.out.println("Private: " + privateField); // Доступ к private
            System.out.println("Protected: " + protectedField);
            System.out.println("Default: " + defaultField);
            System.out.println("Public: " + publicField);

            // Вызов метода внешнего класса
            privateMethod(); // Вызов private метода
        }
    }

    // Статический вложенный класс
    public static class StaticNestedClass {
        public void accessStaticField() {
            System.out.println("Accessing static field from StaticNestedClass:");
            System.out.println("Static: " + staticField); // Доступ к static
        }

        // Невозможно обратиться к нестатическим полям внешнего класса, например:
        // public void accessInstanceField() {
        //     System.out.println("Instance Field: " + instanceField); // Ошибка компиляции
        // }
    }

    // Метод для демонстрации использования внутреннего класса
    public void useInnerClass() {
        InnerClass inner = new InnerClass();
        inner.accessFields();
    }

    // Метод для демонстрации использования статического вложенного класса
    public static void useStaticNestedClass() {
        StaticNestedClass staticNested = new StaticNestedClass();
        staticNested.accessStaticField();
    }

    public static void main(String[] args) {
        // Создание экземпляра внешнего класса для работы с внутренним классом
        Task2 outer = new Task2();

        // Работа с внутренним классом
        outer.useInnerClass();

        // Работа с статическим вложенным классом
        Task2.useStaticNestedClass();
    }
}
/*
Внутренний класс InnerClass имеет доступ ко всем полям и методам внешнего класса OuterClass, независимо от их спецификаторов доступа.
Это позволяет внутренним классам использовать состояния внешнего класса.
*/