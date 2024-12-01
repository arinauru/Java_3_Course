public class Task1 {
    public static void main(String[] args) {
        String str1 = "Hello, Java!";
        String str2 = "hello, java!";
        String str3 = "   Trim me   ";

        // 1. charAt(int index) — Возвращает символ по указанному индексу
        System.out.println("1. charAt: " + str1.charAt(7)); // Output: J

        // 2. length() — Возвращает длину строки
        System.out.println("2. length: " + str1.length()); // Output: 12

        // 3. equals(Object another) — Проверяет равенство строк (с учетом регистра)
        System.out.println("3. equals: " + str1.equals(str2)); // Output: false

        // 4. equalsIgnoreCase(String another) — Проверяет равенство строк (без учета регистра)
        System.out.println("4. equalsIgnoreCase: " + str1.equalsIgnoreCase(str2)); // Output: true

        // 5. substring(int beginIndex, int endIndex) — Возвращает подстроку
        System.out.println("5. substring: " + str1.substring(7, 11)); // Output: Java

        // 6. toUpperCase() — Преобразует строку в верхний регистр
        System.out.println("6. toUpperCase: " + str1.toUpperCase()); // Output: HELLO, JAVA!

        // 7. toLowerCase() — Преобразует строку в нижний регистр
        System.out.println("7. toLowerCase: " + str1.toLowerCase()); // Output: hello, java!

        // 8. trim() — Удаляет пробелы в начале и в конце строки
        System.out.println("8. trim: '" + str3.trim() + "'"); // Output: 'Trim me'

        // 9. contains(CharSequence s) — Проверяет, содержит ли строка заданную последовательность
        System.out.println("9. contains: " + str1.contains("Java")); // Output: true

        // 10. replace(CharSequence target, CharSequence replacement) — Заменяет все вхождения одной последовательности символов на другую
        System.out.println("10. replace: " + str1.replace("Java", "World")); // Output: Hello, World!
    }
}
