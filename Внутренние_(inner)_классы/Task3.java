public class Task3 {
    private String privateField = "Private Field in Task3";
    protected String protectedField = "Protected Field in Task3";
    public String publicField = "Public Field in Task3";

    // Внутренний класс
    public class InnerClass {
        private String privateField = "Private Field in InnerClass";
        protected String protectedField = "Protected Field in InnerClass";
        public String publicField = "Public Field in InnerClass";

        // Метод внутреннего класса
        public void innerMethod() {
            System.out.println("Method in InnerClass");
        }
    }

    // Метод внешнего класса, который создает экземпляр внутреннего класса
    public void createInnerClassInstance() {
        InnerClass inner = new InnerClass(); // Создаем экземпляр внутреннего класса
        System.out.println("Accessing inner class fields:");
        System.out.println("Private: " + inner.privateField); // Доступ к private полю внутреннего класса
        System.out.println("Protected: " + inner.protectedField);
        System.out.println("Public: " + inner.publicField);

        inner.innerMethod(); // Вызов метода внутреннего класса
    }

    public static void main(String[] args) {
        Task3 outer = new Task3();
        outer.createInnerClassInstance(); // Создаем экземпляр внутреннего класса и обращаемся к его членам
    }
}
/*
 * Внешний класс не имеет прямого доступа к полям и методам внутреннего класса,
 * если только не имеет экземпляра внутреннего класса. Это связано с тем, что
 * внутренний класс может содержать нестатические поля и методы, которые принадлежат
 * экземпляру самого внутреннего класса. Однако, если внешний класс создает экземпляр
 * внутреннего класса, он может обращаться к его членам, в зависимости от уровня доступа этих членов.
 * Доступ к полям и методам внутреннего класса зависит от их спецификаторов доступа
 * (private, protected, default, public).
 */