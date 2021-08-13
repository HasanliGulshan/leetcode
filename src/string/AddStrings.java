package string;

public class AddStrings {

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum = 0;

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum += a + b;

            sb.append(sum % 10);
            sum /= 10;

            i--;
            j--;
        }

        if (sum != 0) sb.append(sum % 10);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
}
