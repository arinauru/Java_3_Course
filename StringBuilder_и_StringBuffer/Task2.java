public class Task2 {
    public static void main(String[] args) {
        // Преобразование String в StringBuffer
        String str = "Hello, World!";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);

        // Преобразование StringBuffer в String
        String stringFromBuffer = stringBuffer.toString();
        System.out.println(stringFromBuffer);

        // Преобразование String в StringBuilder
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder);

        // Преобразование StringBuilder в String
        String stringFromBuilder = stringBuilder.toString();
        System.out.println(stringFromBuilder);

        // Преобразование StringBuffer в StringBuilder
        StringBuilder builderFromBuffer = new StringBuilder(stringBuffer);
        System.out.println(builderFromBuffer);

        // Преобразование StringBuilder в StringBuffer
        StringBuffer bufferFromBuilder = new StringBuffer(stringBuilder);
        System.out.println(bufferFromBuilder);
    }
}
