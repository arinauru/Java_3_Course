/**
 * @author Arina
 */
enum Color {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00");

    private final String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    // Метод для получения HEX-кода цвета
    public String getHexCode() {
        return hexCode;
    }

    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.printf("Цвет %s имеет HEX-код: %s%n", color, color.getHexCode());
        }
    }
}
