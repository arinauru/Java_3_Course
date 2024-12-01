class Math {

    // Перегруженный метод для сложения двух целых чисел
    public int add(int a, int b) {
        return a + b;
    }

    // Перегруженный метод для сложения трех целых чисел
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Перегруженный метод для сложения двух чисел с плавающей точкой
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Math mathOps = new Math();

        System.out.println(mathOps.add(1, 2));
        System.out.println(mathOps.add(1, 2, 3));
        System.out.println(mathOps.add(2.5, 3.5));
    }
}
