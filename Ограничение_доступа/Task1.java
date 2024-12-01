/**
 * Практика #1: Пример использования спецификаторов доступа.
 *
 * @author Arina
 */

/**
 * Практика #1: Пример использования спецификаторов доступа.
 *
 * @author Ivan Shupayev
 */
class Animal {
    public Animal(String year, int age) {
        this.years = year;
        this.age = age;
    }

    public void Speak() {
        System.out.println("I am a " + years);
    }

    public void CheckIfOld() {
        if (isOld()) {
            System.out.println("I am old for my years.");
        } else {
            System.out.println("I am still young!");
        }
    }

    protected String years;
    protected int age;

    protected boolean isOld() {
        return age > 10;
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super("Dog", age);
        this.name = name;
    }

    public void Bark() {
        System.out.println(name + ": Woof!");
    }

    private String name;
}

public class Task1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Jully", 5);
        dog.Speak();
        dog.CheckIfOld();
        dog.Bark();
    }
}

