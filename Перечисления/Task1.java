/**
 * Пример использования перечисления с инициализацией элементов.
 */
public class Task1 {
    public enum Season {
        WINTER("Snowy"),
        SPRING("Flowers"),
        SUMMER("Sunny"),
        AUTUMN("Leaf fall");

        private final String description;

        Season(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static void main(String[] args) {
        Season currentSeason = Season.SPRING;

        System.out.println(currentSeason);
        System.out.println(currentSeason.getDescription());

        System.out.println("\nAll seasons:");
        for (Season season : Season.values()) {
            System.out.println(season + " " + season.getDescription());
        }
    }
}
