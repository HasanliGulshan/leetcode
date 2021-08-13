package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Evaluate {
    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(), key;

        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                i += 1;

                key = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                System.out.println(map.get(key.toString()));

                sb.append(map.getOrDefault(key.toString(), "?"));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
        List<List<String>> list = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("name");
        item.add("bob");
        list.add(item);

        List<String> item1 = new ArrayList<>();
        item1.add("age");
        item1.add("two");

        list.add(item1);

        System.out.println(evaluate("(name)is(age)yearsold", list));
    }
}
