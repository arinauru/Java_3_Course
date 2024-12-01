class A {
    int a;
    int b;
    int c;
    int z;

    public A() {
        this(0, 0, 0);
        z = 1;
    }

    public A(int a) {
        this(a, 0, 0);
        z = 1;
    }

    public A(int a, int b) {
        this(a, b, 0);
        z = 1;
    }

    public A(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        z = 1;
    }
}
