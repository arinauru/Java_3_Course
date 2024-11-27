public class Task8 {
    public static void main(String[] args) {
        var number = 42; // Тип переменной будет int
        System.out.println("Тип переменной number: " + ((Object) number).getClass().getSimpleName());

        var greeting = "Hello, world!"; // Тип переменной будет String
        System.out.println("Тип переменной greeting: " + ((Object) greeting).getClass().getSimpleName());
    }
}
