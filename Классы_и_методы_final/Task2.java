// Класс, который нельзя наследовать
final class Transport {
    public void start() {
        System.out.println("Started");
    }
}

// Попытка создать подкласс от final-класса приведет к ошибке компиляции
class Car extends Transport {  // Ошибка: cannot inherit from final Transport
    public void drive() {
        System.out.println("Car is driving");
    }
}

public class Task2 {
    public static void main(String[] args) {
        Transport vehicle = new Transport();
        vehicle.start();
        // Попытка создать объект подкласса приведет к ошибке компиляции
        // Car car = new Car();  // Ошибка: cannot inherit from final Vehicle
    }
}
