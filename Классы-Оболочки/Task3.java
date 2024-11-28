/**
 * Практика #3: Пример исключения NullPointerException при автораспаковке
 *
 * @author Arina
 */
public class Task3 {
    public static void main(String[] args) {
        Integer NullInteger = null;
        try {
            int value = NullInteger;
            System.out.println("Value: " + value);
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e);
        }

    }
}
