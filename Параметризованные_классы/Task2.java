import java.util.ArrayList;
import java.util.List;

class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Task2 {
    // Метод с <? extends T> для чтения элементов
    public static void displayShapes(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    // Метод с <? super T> для добавления элементов
    public static void addShapes(List<? super Rectangle> shapes) {
        shapes.add(new Rectangle());
        shapes.add(new Rectangle());
        // shapes.add(new Circle());
    }

    public static void main(String[] args) {
        // Пример с <? extends T>
        List<Rectangle> rectangles = List.of(new Rectangle(), new Rectangle());
        List<Circle> circles = List.of(new Circle(), new Circle());

        System.out.println("Displaying rectangles:");
        displayShapes(rectangles);

        System.out.println("Displaying circles:");
        displayShapes(circles);

        // Пример с <? super T>
        List<Shape> shapes = new ArrayList<>();
        addShapes(shapes);

        System.out.println("\nShapes after adding rectangles:");
        displayShapes(shapes);
    }
}
/*
 *Использование <? extends T> и <? super T> помогает создавать более гибкие и обобщенные методы, которые могут работать с различными типами данных,
 *избегая ошибок типизации.
 * <? extends T> — используется, когда нужно чтение данных.
 * <? super T> — используется, когда нужно добавление данных.
 */
