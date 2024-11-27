public class Task6 {
    public static void main(String[] args) {
        // Пример 1: int -> byte
        int intValue = 130;
        byte byteValue = (byte) intValue;
        System.out.println("int -> byte: " + byteValue);

        // Пример 2: double -> int
        double doubleValue = 123.456;
        int intValue2 = (int) doubleValue;
        System.out.println("double -> int: " + intValue2);

        // Пример 3: long -> short
        long longValue = 32768;
        short shortValue = (short) longValue;
        System.out.println("long -> short: " + shortValue);

        // Пример 4: float -> byte
        float floatValue = 123.99f;
        byte byteValue2 = (byte) floatValue;
        System.out.println("float -> byte: " + byteValue2);

        // Пример 5: char -> byte
        char charValue = 'A';
        byte byteValue3 = (byte) charValue;
        System.out.println("char -> byte: " + byteValue3);
    }
}
