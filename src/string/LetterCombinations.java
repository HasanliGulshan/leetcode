package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        HashMap<Integer, String> map = map();

        for (int i = 0; i < digits.length(); i++) {
            String s = map.get(digits.charAt(i) - '0');

            if (ans.isEmpty()) {
                for (int j = 0; j < s.length(); j++) {
                    ans.add(Character.toString(s.charAt(j)));
                }

            } else {
                List<String> curr = new ArrayList<>();
                for (int j = 0; j < ans.size(); j++) {
                    for (int k = 0; k < s.length(); k++) {
                        curr.add(ans.get(j) + s.charAt(k));
                    }
                }

                ans = curr;
            }
        }

        return ans;
    }

    public static HashMap<Integer, String> map() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        return map;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
