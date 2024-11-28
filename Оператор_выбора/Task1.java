public class Task1 {
    public static void main(String[] args) {
        // 1. Целочисленные типы
        int number = 2;
        switch (number) {
            case 1:
                System.out.println("Number is 1");
                break;
            case 2:
                System.out.println("Number is 2");
                break;
            default:
                System.out.println("Number is something else");
                break;
        }

        // 2. Перечисления (enum)
        enum Day { MONDAY, TUESDAY, WEDNESDAY }
        Day today = Day.WEDNESDAY;
        switch (today) {
            case MONDAY:
                System.out.println("Today is Monday");
                break;
            case TUESDAY:
                System.out.println("Today is Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Today is Wednesday");
                break;
        }

        // 3. Строки (String)
        String command = "a";
        switch (command) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("Unknown command");
                break;
        }

        // 4. Обёртки (Wrapper types)
        Integer num = 3;
        switch (num) {
            case 1:
                System.out.println("Number is 1");
                break;
            case 2:
                System.out.println("Number is 2");
                break;
            case 3:
                System.out.println("Number is 3");
                break;
            default:
                System.out.println("Other number");
                break;
        }
    }
}
