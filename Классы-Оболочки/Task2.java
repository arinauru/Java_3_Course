/**
 * Практика #2: Способы создания экземпляра Boolean
 *
 * @author Arina
 */
public class Task2 {
    public static void main(String[] args) {
        // Способ 1: Использование литералов true/false
        Boolean bool1 = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        System.out.println("Literal true: " + bool1);
        System.out.println("Literal false: " + bool2);

        // Способ 2: Использование статического метода valueOf(boolean)
        Boolean bool3 = Boolean.valueOf(true);
        Boolean bool4 = Boolean.valueOf(false);
        System.out.println("valueOf(true): " + bool3);
        System.out.println("valueOf(false): " + bool4);

        // Способ 3: Использование статического метода valueOf(String)
        Boolean string1 = Boolean.valueOf("true");
        Boolean string2 = Boolean.valueOf("false");
        Boolean string3 = Boolean.valueOf("invalid");
        System.out.println("valueOf(\"true\"): " + string1);
        System.out.println("valueOf(\"false\"): " + string2);
        System.out.println("valueOf(\"invalid\"): " + string3);
    }
}
