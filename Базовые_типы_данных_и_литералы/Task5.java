public class Task5 {
    public static void main(String[] args) {
        // Пример 1: int и double
        int IntValue = 5;
        double DoubleValue = 2.5;
        System.out.println("(int + double): " + IntValue + DoubleValue);

        // Пример 2: byte и int
        byte ByteValue = 10;
        System.out.println("(byte * int): " + ByteValue * IntValue);

        // Пример 3: float и long
        long LongValue = 10000000000L;
        float FloatValue = 2.5f;
        System.out.println("(long / float): " + LongValue / FloatValue);

        // Пример 4: short и char
        short ShortValue = 300;
        char CharValue = 'A';
        System.out.println("(short + char): " + ShortValue + CharValue);

        // Пример 5: Все типы вместе
        double result5 = ByteValue + ShortValue + IntValue + LongValue + FloatValue + DoubleValue;
        System.out.println("(byte + short + int + long + float + double): " + result5);
    }
}
//Обьяснение: Java автоматически выполняет расширяющие преобразования
// в арифметических операциях с переменными разных типов.
// Тип с меньшим диапазоном преобразуется в тип с большим диапазоном.
