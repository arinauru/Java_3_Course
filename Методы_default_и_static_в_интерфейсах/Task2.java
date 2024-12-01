interface Interface1 {
    default void DefaultMethod() {
        System.out.println("Default method1");
    }
}

interface Interface2 {
    default void DefaultMethod() {
        System.out.println("Default method2");
    }
}

class MyClass implements Interface1, Interface2 {
    @Override
    public void DefaultMethod() {
        System.out.println("Resolving conflict in MyClass");
        Interface1.super.DefaultMethod();
        Interface2.super.DefaultMethod();
    }
}

public class Task2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.DefaultMethod();
    }
}
/*
Если класс реализует два интерфейса с одинаковыми default методами, возникает конфликт,
так как компилятор не знает, какую реализацию использовать. Для разрешения конфликта
необходимо переопределить метод в классе и явно указать, какую реализацию использовать,
или определить свою собственную логику. В примере метод DefaultMethod переопределен в классе
MyClass, где вызваны обе реализации интерфейсов через Interface1.super.DefaultMethod() и
Interface2.super.DefaultMethod().
 */
