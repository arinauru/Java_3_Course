import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        String filePath = "2.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            String data = "Hello, world!";

            for (int i = 0; i < data.length(); i++) {
                fileOutputStream.write(data.charAt(i));
            }
            System.out.println("Данные записаны в файл.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
