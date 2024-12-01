// Суперкласс
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal name");
    }

    public void says() {
        System.out.println("Animal says");
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
        System.out.println("Dog name");
    }

    @Override
    public void says() {
        super.says();
        System.out.println("Dog barks");
    }

    public void printName() {
        System.out.println("Animal's name is: " + super.name);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Mikky", "Jully");
        dog.says();
        dog.printName();
    }
}
