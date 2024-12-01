public class Task1 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello");
        StringBuilder stringBuilder = new StringBuilder("World");

        // 1. append(): добавляет строку в конец
        stringBuffer.append(" Java");
        System.out.println(" " + stringBuffer);

        // 2. insert(): вставляет строку в указанную позицию
        stringBuffer.insert(2, "Hello ");
        System.out.println(" " + stringBuffer);

        // 3. replace(): заменяет текст в указанном диапазоне
        stringBuffer.replace(6, 13, "fghkome");
        System.out.println(" " + stringBuffer);

        // 4. delete(): удаляет текст в указанном диапазоне
        stringBuffer.delete(6, 14);
        System.out.println(" " + stringBuffer);

        // 5. reverse(): переворачивает содержимое
        stringBuffer.reverse();
        System.out.println(" " + stringBuffer);
        stringBuffer.reverse();

        // 6. capacity(): показывает текущую емкость буфера
        System.out.println(" " + stringBuffer.capacity());

        // 7. ensureCapacity(): гарантирует минимальную емкость
        stringBuffer.ensureCapacity(50);
        System.out.println("S " + stringBuffer.capacity());

        // 8. append(): добавляет строку в конец
        stringBuilder.append(" Mountain");
        System.out.println(" " + stringBuilder);

        // 9. charAt(): возвращает символ по индексу
        char ch = stringBuilder.charAt(6);
        System.out.println(" " + ch);

        // 10. setLength(): изменяет длину строки
        stringBuilder.setLength(5);
        System.out.println(" " + stringBuilder);
    }
}
