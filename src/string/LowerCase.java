package string;

public class LowerCase {
    public static String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 65 && c <= 90) {
                builder.append((char)(c + 32));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("LOVELY"));
    }
}
