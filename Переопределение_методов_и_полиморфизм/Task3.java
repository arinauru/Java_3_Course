class Parent {
    public void displayMessage() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    @Override
    public void displayMessage() { // Корректное переопределение
        System.out.println("Child class");
    }
}

/*
class Child extends Parent {
    @Override
    public void displayMesage() { // Ошибка: метод не переопределяет метод суперкласса
        System.out.println("Child class");
    }
}
*/
public class Task3 {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.displayMessage();
    }
}
// Таким образом, использование аннотации @Override помогает предотвратить ошибки при переопределении
// методов и делает код более понятным.