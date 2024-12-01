interface MyInterface {
    default void defaultMethod() {
        System.out.println("Default method");
    }

    static void staticMethod() {
        System.out.println("Static method");
    }
}

class MyClass implements MyInterface {
    @Override
    public void defaultMethod() {
        System.out.println("default method in MyClass");
    }

    public void CallDefaultMethod() {
        MyInterface.super.defaultMethod();
    }
}

public class Task1 {
    public static void main(String[] args) {
        MyInterface.staticMethod();

        MyClass myClass = new MyClass();

        myClass.defaultMethod();

        myClass.CallDefaultMethod();
    }
}
