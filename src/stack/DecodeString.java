package stack;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int prevDigit = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(result.toString());
                result.setLength(0);
                stack.push(String.valueOf(prevDigit));
                prevDigit = 0;

            } else if (c == ']') {
                int count = Integer.parseInt(stack.pop());
                String prev = stack.pop();

                for (int i = 0; i < count; i++) {
                    temp.append(result);
                }

                result.setLength(0);
                result.append(prev).append(temp.toString());

                temp.setLength(0);

            } else if (Character.isDigit(c)) {

                prevDigit = prevDigit * 10 + Character.getNumericValue(c);

            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        //System.out.println(decodeString("3[a]2[bc]"));

        System.out.println(decodeString("2[abc]3[cd]ef"));

       // System.out.println(decodeString("3[a2[c]]"));
    }
}
