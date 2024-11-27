public class Task1 {
    public static void main(String[] args) {
        // Операторы + и += для строк
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Конкатенация строк (+): " + str1 + " " + str2);

        str1 += " Java"; // Использование +=
        System.out.println("Оператор += для строк: " + str1);

        // Логические операторы == и !=
        int a = 10, b = 20, c = 10;
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a == c: " + (a == c));

        // Оператор присваивания =
        int x = 5;
        System.out.println("Присваивание x = " + x);

        // Условный оператор ?:
        String ternaryResult = (a > b) ? "a больше b" : "a не больше b";
        System.out.println("Условный оператор ?: " + ternaryResult);

        // Логический оператор || (логическое ИЛИ)
        System.out.println("Логическое ИЛИ (||): " + (a > b || a < c));

        // Логический оператор && (логическое И)
        System.out.println("Логическое И (&&): " + (a > 5 && b < 25));

        // Побитовые операторы | (ИЛИ), ^ (исключающее ИЛИ), & (И)
        int bit1 = 5;
        int bit2 = 3;
        System.out.println("Побитовое ИЛИ (|): " + (bit1 | bit2));
        System.out.println("Побитовое исключающее ИЛИ (^): " + (bit1 ^ bit2));
        System.out.println("Побитовое И (&): " + (bit1 & bit2));

        // Сравнительные операторы >, >=, <, <=
        System.out.println("a > b: " + (a > b));
        System.out.println("a >= c: " + (a >= c));
        System.out.println("b < a: " + (b < a));
        System.out.println("b <= c: " + (b <= c));

        // Побитовые сдвиги >>, >>>, <<
        int num = 8;
        System.out.println("Правый сдвиг >>: " + (num >> 2));
        System.out.println("Беззнаковый сдвиг >>>: " + (num >>> 2));
        System.out.println("Левый сдвиг <<: " + (num << 2));

        // Арифметические операторы +, -, *, /, %
        System.out.println("Сложение: " + (a + b));
        System.out.println("Вычитание: " + (b - a));
        System.out.println("Умножение: " + (a * b));
        System.out.println("Деление: " + (b / a));
        System.out.println("Остаток от деления: " + (b % a));

        // Префиксные и постфиксные операторы ++ и --
        int y = 10;
        System.out.println("Изначальное значение y: " + y);
        System.out.println("Постфиксный инкремент y++: " + y++);
        System.out.println("Значение y после постфиксного инкремента: " + y);
        System.out.println("Префиксный инкремент ++y: " + ++y);
        System.out.println("Постфиксный декремент y--: " + y--);
        System.out.println("Значение y после постфиксного декремента: " + y);
        System.out.println("Префиксный декремент --y: " + --y);

        // Скобки для изменения приоритета
        System.out.println("Скобки для изменения приоритета: " + ((a + b) * c));
    }
}
