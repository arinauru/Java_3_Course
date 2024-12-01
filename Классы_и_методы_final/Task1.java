class Parent {
    // Метод объявлен как final, его нельзя переопределять в подклассах
    public final void showMessage() {
        System.out.println("Message1 ");
    }
}

class Child extends Parent {
    // Попытка переопределить метод showMessage() приведет к ошибке компиляции
    // public void showMessage() {  // Ошибка: cannot override the final method from Parent
    //     System.out.println("Message2");
    // }
}

public class Task1 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.showMessage();

        Child child = new Child();
        child.showMessage();
    }
}
