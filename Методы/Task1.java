/**
 * Пример перегрузки методов
 */
class Printer {
    public void print(String text) {
        System.out.println(text);
    }

    public void print(int number) {
        System.out.println(number);
    }

    public void print(double number) {
        System.out.println(number);
    }
}

/**
 * Пример переопределения метода:
 */
class Transport {
    public void move() {
        System.out.println("Transport!");
    }
}

class Car extends Transport {
    @Override
    public void move() {
        System.out.println("The car drives on the road.");
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Пример перегрузки
        Printer printer = new Printer();
        printer.print("Hello, world!");
        printer.print(42);
        printer.print(3.14159);

        // Пример переопределения
        Transport myTransport = new Transport();
        Transport myCar = new Car();

        myTransport.move();
        myCar.move();
    }
}
