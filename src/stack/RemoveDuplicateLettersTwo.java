package stack;

import java.util.Stack;

public class RemoveDuplicateLettersTwo {

    public static String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        //get a letter how many times appear in string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freq[index]--;

            if (seen[index]) continue;

            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                seen[index] = true;
            } else {
                // c > b c == 99 b == 98 stack has c then comes b in this case if condition is ok but if stack has b then comes c then  if condition is not ok
                while (!stack.isEmpty() && s.charAt(i) < stack.peek() && freq[stack.peek() - 'a'] > 0) {
                    seen[stack.peek() - 'a'] = false;
                    stack.pop();
                }

                stack.push(s.charAt(i));
                seen[index] = true;
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bbcaac";
        System.out.println(removeDuplicateLetters(s));
    }
}
