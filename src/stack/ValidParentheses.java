package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                 //here stack.pop() return key, bcs we only push key to stack. And with returned key we get value from map anc check
                // if these two are equal or not
                if (stack.isEmpty() || c != map.get(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("))(("));
    }
}
