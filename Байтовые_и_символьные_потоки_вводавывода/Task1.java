import java.io.FileInputStream;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        String filePath = "1.txt";

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int data;

            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
