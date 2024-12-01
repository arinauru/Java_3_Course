class Parent {
    String name;

    Parent(String name) {
        this.name = name;
    }

    void showName() {
        System.out.println("Parent name: " + name);
    }
}

class Child extends Parent {
    String name;

    Child(String parentName, String childName) {
        super(parentName);
        this.name = childName;
    }

    @Override
    void showName() {
        super.showName();
        System.out.println("Child name: " + this.name);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Child child = new Child("John", "Mike");
        child.showName();
    }
}
/**
 * Ключевые слова this и super используются в подклассах для управления доступом к членам
 * текущего класса и его суперкласса.
 * Ключевое слово this: используется, чтобы уточнить, что обращение идет к полю или методу
 * текущего объекта. Можно использовать для вызова другого конструктора в том же классе.
 * Ключевое слово super: используется для вызова методов и полей суперкласса, которые могут
 * быть скрыты (или переопределены) в подклассе. Применяется для явного вызова конструктора
 * суперкласса.
 */
