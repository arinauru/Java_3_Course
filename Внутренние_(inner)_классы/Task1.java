class OuterClass {
    // Внутренний класс с модификатором public
    public class PublicInner {
        public void show() {
            System.out.println("Public inner class");
        }
    }

    // Внутренний класс с модификатором protected
    protected class ProtectedInner {
        public void show() {
            System.out.println("Protected inner class");
        }
    }

    // Внутренний класс с модификатором default
    class DefaultInner {
        public void show() {
            System.out.println("Default inner class");
        }
    }

    // Внутренний класс с модификатором private
    private class PrivateInner {
        public void show() {
            System.out.println("Private inner class");
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        // Доступ к public внутреннему классу извне
        OuterClass outer = new OuterClass();
        OuterClass.PublicInner publicInner = outer.new PublicInner();
        publicInner.show(); // Public inner class доступен извне

        // Доступ к protected внутреннему классу извне (из другого класса в том же пакете)
        OuterClass.ProtectedInner protectedInner = outer.new ProtectedInner();
        protectedInner.show(); // Protected доступен в пределах пакета

        // Доступ к default внутреннему классу извне (из другого класса в том же пакете)
        OuterClass.DefaultInner defaultInner = outer.new DefaultInner();
        defaultInner.show(); // Default доступен в пределах пакета

        // Доступ к private внутреннему классу извне
        // OuterClass.PrivateInner privateInner = outer.new PrivateInner(); // Ошибка: Private недоступен
    }
}
/**
 * public: Полный доступ из любого класса.
 * protected: Доступен в пределах пакета и через наследование в других пакетах.
 * default: Доступ только в пределах пакета.
 * private: Доступ только внутри внешнего класса.
 * Правильный выбор спецификатора доступа для внутреннего класса зависит от необходимости
 * скрывать или предоставлять доступ к функциональности этого класса.
 */