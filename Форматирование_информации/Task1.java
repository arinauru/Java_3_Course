import java.util.Formatter;

public class Task1 {
    public static void main(String[] args) {
        try (Formatter fmt = new Formatter()) {
            // Логическое значение (%b)
            boolean t = true;
            fmt.format("%b%n", t);

            // Символьное представление (%c)
            char a = 'A';
            fmt.format("%c%n", a);

            // Десятичное целое значение (%d)
            int n = 25;
            fmt.format("%d%n", n);

            // Десятичное значение с плавающей точкой (%f)
            double pi = 3.14159;
            fmt.format("%.2f%n", pi);

            // Строковое представление (%s)
            String name = "Арина";
            fmt.format("%s%n", name);

            System.out.println(fmt.toString());
        }
    }
}
