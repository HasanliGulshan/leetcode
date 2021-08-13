package stack;

public class MinAddToMakeValid {
    public static int minAddToMakeValid(String S) {
        int count = 0, left = 0;

        for (char c: S.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    left++;
                } else {
                    count--;
                }
            }
        }

        return count + left;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("((()((((("));
    }
}
