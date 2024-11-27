/**
 * @author Arina
 */
public class Task2 {
    public static void main(String[] args) {
        // Пример 1: Проверка объектов разных типов
        Double decimalNumber = 42.5;
        Boolean flag = true;

        System.out.println("decimalNumber instanceof Double: " + (decimalNumber instanceof Double));
        System.out.println("flag instanceof Boolean: " + (flag instanceof Boolean));

        // Пример 2: Проверка массивов
        int[] intArray = {1, 2, 3};
        String[] stringArray = {"A", "B", "C"};

        System.out.println("intArray instanceof int[]: " + (intArray instanceof int[]));
        System.out.println("stringArray instanceof String[]: " + (stringArray instanceof String[]));
        System.out.println("intArray instanceof Object: " + (intArray instanceof Object));

        // Пример 3: Проверка для null
        Object nullObject = null;
        System.out.println("nullObject instanceof Object: " + (nullObject instanceof Object));

        // Пример 4: Использование базового Object
        Object text = "Hello, instanceof!";
        System.out.println("text instanceof String: " + (text instanceof String));
        System.out.println("text instanceof Object: " + (text instanceof Object));
    }
}
