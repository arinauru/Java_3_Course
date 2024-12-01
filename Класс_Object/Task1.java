class Product {
    private String name;
    private double price;
    private String id;

    public Product(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Product other = (Product) obj;

        return name.equals(other.name) && price == other.price && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.valueOf(price).hashCode() + id.hashCode();
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", sku='" + id + "'}";
    }
}

public class Task1 {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99, "12345");
        Product product2 = new Product("Laptop", 999.99, "12345");
        Product product3 = new Product("Smartphone", 499.99, "54321");

        System.out.println(product1.equals(product2)); // true, потому что продукты одинаковы по содержимому
        System.out.println(product1.equals(product3)); // false, потому что продукты разные
        System.out.println(product1.equals(null));     // false, потому что не может быть равен null
    }
}
