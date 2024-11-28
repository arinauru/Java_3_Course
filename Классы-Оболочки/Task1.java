/**
 * Практика #1: Примеры использования метода decode()
 *
 * Метод decode() преобразует строку в объект числового типа.
 *
 */
public class Task1 {
    public static void main(String[] args) {
        Integer DecimalNum = Integer.decode("42");
        Integer OctNum = Integer.decode("052");
        Integer HexNum = Integer.decode("0x2A");
        Integer NegativeNum = Integer.decode("-0x2A");
        Integer zero = Integer.decode("0");

        System.out.println("Decimal 42: " + DecimalNum);
        System.out.println("Octal 052: " + OctNum);
        System.out.println("Hex 0x2A: " + HexNum);
        System.out.println("Negative -0x2A: " + NegativeNum);
        System.out.println("Zero: " + zero);
    }
}
