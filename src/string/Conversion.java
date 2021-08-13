package string;

public class Conversion {
    public static String intToString(int num) {
        boolean isNegative = false;
        if (num < 0) isNegative = true;

        StringBuilder sb = new StringBuilder();

        do {
            sb.append((char) ('0' + Math.abs(num % 10)));
            num /= 10;
        } while (num != 0);

        if (isNegative)
            sb.append("-");

        //all operation must be done before reverse ex : -123 -> 321-
        sb.reverse();

        return sb.toString();
    }

    public static int stringToInt (String s) {
        int ans = 0;

        for (int i = s.charAt(0) == '-'? 1 : 0; i < s.length(); i++) {
            int value = s.charAt(i) - '0';
            ans = ans * 10 + value;
        }

        return s.charAt(0) == '-' ? -ans : ans;
    }
}
