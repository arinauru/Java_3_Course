public class Task4 {
    public static void main(String[] args) {
        // Переменные вне диапазона кэша
        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;
        System.out.println("a1==i1 " + (a1 == i1)); // true
        System.out.println("b1==i1 " + (b1 == i1)); // true
        System.out.println("a1==b1 " + (a1 == b1)); // false
        System.out.println("a1.equals(i1) -> " + a1.equals(i1)); // true
        System.out.println("b1.equals(i1) -> " + b1.equals(i1)); // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1)); // true

        // Переменные в пределах диапазона кэша
        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;
        System.out.println("a2==i2 " + (a2 == i2)); // true
        System.out.println("b2==i2 " + (b2 == i2)); // true
        System.out.println("a2==b2 " + (a2 == b2)); // true
        System.out.println("a2.equals(i2) -> " + a2.equals(i2)); // true
        System.out.println("b2.equals(i2) -> " + b2.equals(i2)); // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2)); // true
    }
}
/**
 * Объяснение:
 * При сравнении a1 == i1, b1 == i1, a2 == i2 и b2 == i2 используется автораспаковка (unboxing), где
 * объекты преобразуются в тип int. Оператор == сравнивает числовые значения.
 * В случае a1 == b1, оператор == сравнивает ссылки объектов. Поскольку значение 128 выходит
 * за пределы диапазона кэша, для каждой переменной создаются разные экземпляры Integer.
 * Ссылки не совпадают.
 * В случае a2 == b2, обе переменные (a2 и b2) ссылаются на один объект,
 * так как значение 127 входит в диапазон кэшируемых чисел. Результат — true.
 * Метод equals() сравнивает содержимое объектов, а не ссылки. Для выражений a1.equals(i1),
 * b1.equals(i1) и a1.equals(b1) результат будет true, так как значение 128 у всех переменных совпадает.
 * Для всех выражений a2.equals(i2), b2.equals(i2) и a2.equals(b2) результат также будет true.
 *
 * Класс IntegerCache реализует механизм кэширования объектов Integer для значений от -128 до 127,
 * чтобы уменьшить количество созданных объектов и повысить производительность.
 * Это позволяет переиспользовать одни и те же экземпляры для значений в указанном диапазоне.
 *
 */