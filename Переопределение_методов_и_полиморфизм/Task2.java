class Shape {
    public Shape area() {
        System.out.println("Shape");
        return this;
    }
}

class Circle extends Shape {
    @Override
    public Circle area() {
        System.out.println("Circle");
        return this;
    }
}

// Неправильная попытка переопределения
//class InvalidShape extends Shape {
// Ошибка: тип возвращаемого значения не является Shape или его потомком
// @Override
//  public String area() { // Не компилируется
//     return "Invalid type!";
// }
//}

public class Task2 {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Shape circle = new Circle();

        shape.area();
        circle.area();

        // InvalidShape invalid = new InvalidShape();
        // invalid.area(); // Эта строка вызовет ошибку компиляции
    }
}
