package string;

public class TitleToNumber {
    //26 base
    public static int titleToNumber(String columnTitle) {
        int ans = 0;

        for (char c : columnTitle.toCharArray()) {
            int value = c - 'A' + 1;
            ans = ans * 26 + value;
        }

        return ans;
    }

    public static String getAlpha(int num) {

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            num--; // 1 => a, not 0 => a
            int remainder = num % 26;
            char digit = (char) (remainder + 65);
            result.insert(0, digit);
            num = (num - remainder) / 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
     //   System.out.println(titleToNumber("FXSHRXW"));
        System.out.println(getAlpha(28));
    }
}
