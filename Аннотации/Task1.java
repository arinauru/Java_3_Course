import java.util.List;
import java.util.ArrayList;

class Parent {
    public void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child");
    }

    @SuppressWarnings("unchecked")
    public void unsafeCode() {
        List rawList = new ArrayList();
        rawList.add("Unchecked operation");
        List<String> stringList = rawList;
        System.out.println(stringList.get(0));
    }
}

class Base {
    @Deprecated
    public void Method() {
        System.out.println("Base");
    }

    public void doSomething() {
        System.out.println("doSomething");
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Демонстрация @Override
        Parent child = new Child();
        child.display();

        // Демонстрация @Deprecated
        Base base = new Base();
        base.Method();
        base.doSomething();

        // Демонстрация @SuppressWarnings
        Child childClass = new Child();
        childClass.unsafeCode();
    }
}
