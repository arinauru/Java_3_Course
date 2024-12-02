import java.util.Date;
import java.util.Formatter;

public class Task3 {
    public static void main(String[] args) {
        Date currentDate = new Date();

        try (Formatter fmt = new Formatter()) {

            fmt.format("%tH%n", currentDate);

            fmt.format("%tM%n", currentDate);

            fmt.format("%tB%n", currentDate);

            fmt.format("%tY%n", currentDate);

            fmt.format("%tA%n", currentDate);

            System.out.println(fmt.toString());
        }
    }
}
