package string;

public class IntToRoman {
    public static String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < values.length; i++) {
            while (values[i] <= num) {
                sb.append(roman[i]);

                num -= values[i];
            }
        }
        return sb.toString();
}

    public static void main(String[] args) {
        System.out.println(intToRoman(23));
    }
}
