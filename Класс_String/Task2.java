import java.util.StringJoiner;

public class Task2 {
    public static void main(String[] args) {
        // Пример 1: Простое объединение строк с разделителем
        StringJoiner str1 = new StringJoiner(", ");
        str1.add("Apple");
        str1.add("Banana");
        str1.add("Pineapple");
        System.out.println(str1);

        // Пример 2: Добавление префикса и суффикса
        StringJoiner str2 = new StringJoiner(", ", "[", "]");
        str2.add("Red");
        str2.add("Black");
        str2.add("Blue");
        System.out.println(str2);

        // Пример 3: Объединение двух StringJoiner
        StringJoiner str3 = new StringJoiner(", ");
        str3.add("Java");
        str3.add("Python");

        StringJoiner str4 = new StringJoiner(", ");
        str4.add("C++");
        str4.add("JavaScript");

        str3.merge(str4);
        System.out.println(str3);

        // Пример 4: Пустой StringJoiner с заданием значения по умолчанию
        StringJoiner str5 = new StringJoiner(", ", "{", "}");
        str5.setEmptyValue("No elements");
        System.out.println(str5);
        str5.add("First");
        str5.add("Second");
        System.out.println(str5);
    }
}
