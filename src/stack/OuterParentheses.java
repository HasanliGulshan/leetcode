package stack;

public class OuterParentheses {
    public static String removeOuterParentheses(String S) {
        int counter = 0;
        StringBuilder res = new StringBuilder();

        for (char c : S.toCharArray()) {

            if (counter != 0 && ! (counter == 1 && c == ')')) {
                res.append(c);
            }

            if (c == '(') {
                counter++;
            } else {
                counter--;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
       // System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
