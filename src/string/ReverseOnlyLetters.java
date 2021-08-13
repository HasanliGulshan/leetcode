package string;

public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        StringBuilder sb = new StringBuilder(S);

        while (i < j) {
            if (Character.isLetter(S.charAt(i)) && Character.isLetter(S.charAt(j))) {
                char temp = S.charAt(i);
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j, temp);

                i++;
                j--;
            }

            if (!Character.isLetter(S.charAt(i))) {
                i++;
            }

            if (!Character.isLetter(S.charAt(j))) {
                j--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
