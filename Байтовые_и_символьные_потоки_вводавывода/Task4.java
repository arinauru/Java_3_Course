import java.io.FileReader;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("1.txt")) {
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Интерфейс AutoCloseable используется для объектов, которые требуют явного закрытия после
использования, например, для работы с ресурсами, такими как файлы или сетевые соединения.
Он позволяет автоматически закрывать такие ресурсы, используя конструкцию try-with-resources,
что помогает избежать утечек ресурсов.
 */