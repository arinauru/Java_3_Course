import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите Ваше имя: ");
        String name = scan.next();
        System.out.println("Привет, " + name);
        scan.close();
    }
}