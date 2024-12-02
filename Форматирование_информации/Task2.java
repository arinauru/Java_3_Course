import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task2 {
    public static void main(String[] args) {
        try (FileWriter file = new FileWriter("output.txt");
             PrintWriter writer = new PrintWriter(file)) {

            // Записываем первую строку
            writer.println("Это первая строка");
            writer.flush(); // Сбрасываем буфер, чтобы строка записалась сразу

            // Записываем вторую строку
            writer.println("Это вторая строка");
            // Эта строка будет записана при закрытии потока
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
/*
Метод flush() используется для сброса буферизованных данных в целевой поток. Это необходимо,
когда данные записываются не напрямую, а сначала накапливаются в буфере, а затем передаются
в поток. Метод flush() гарантирует, что все данные из буфера будут отправлены.
 */