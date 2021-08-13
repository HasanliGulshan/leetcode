package string;

public class DecodeAndEncode {

    public static String decoding(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count = count * 10 + s.charAt(i) - '0';
            } else {
                // c is a letter

                while (count --> 0) {
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }

    public static String encoding(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }

        return sb.toString();
    }
}
