/**
 * @author Arina
 */
class A {
    int a1;              // По умолчанию (package-private)
    public int a2;      // Доступен везде
    protected int a3;    // Доступен в подклассах и в том же пакете
    private int a4;      // Доступен только в классе A

    void method1() {
        // Доступен в том же пакете
    }

    public void method2() {
        // Доступен везде
    }

    protected void method3() {
        // Доступен в подклассах и в том же пакете
    }

    private void method4() {
        // Доступен только в классе A
    }
}

class B extends A {
    void accessMembers() {
        // System.out.println(a1); // доступен, так как это package-private и B в том же пакете
        System.out.println(a2);  // доступен, public
        System.out.println(a3);  // доступен, protected
        // System.out.println(a4); // ошибка, private недоступен
    }

    public void method2() {
        // доступен, public
    }

    protected void method3() {
        // доступен, protected
    }
}

class C extends B {
    void accessMembers() {
        // System.out.println(a1); // доступен, так как это package-private и C в том же пакете
        System.out.println(a2);  // доступен, public
        System.out.println(a3);  // доступен, protected
        // System.out.println(a4); // ошибка, private недоступен
    }
}
/*
Объяснение спецификаторов доступа при наследовании:
private: Члены класса, объявленные с модификатором private, не доступны в подклассах.
В нашем примере a4 и method4() недоступны ни в классе B, ни в классе C.
protected: Члены класса, объявленные с модификатором protected, доступны в подклассах и в классах,
находящихся в одном пакете. В классе B и C доступны a3 и method3().
public: Члены класса, объявленные с модификатором public,
доступны из любого другого класса. В классе B и C доступны a2 и method2().
По умолчанию (package-private): Члены класса, которые не имеют модификатора доступа,
доступны только для классов в одном пакете. В нашем примере a1 и method1() доступны в классах
B и C, если они находятся в том же пакете.
*/