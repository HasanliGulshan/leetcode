package string;

import java.util.ArrayList;
import java.util.List;

public class CountMatches {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
       int ans = 0;
       int index = 0;

       if (ruleKey.equals("color")) {
           index = 1;
       } else if (ruleKey.equals("name")){
           index = 2;
       }

       for (int i = 0; i < items.size(); i++) {
           if (items.get(i).get(index).equals(ruleValue))
               ans++;
       }

       return ans;
    }

    public static void main(String[] args) {
        List<List<String>> l = new ArrayList<>();
        List<String> i1 = new ArrayList<>();
        i1.add("phone");
        i1.add("blue");
        i1.add("pixel");

        List<String> i2 = new ArrayList<>();
        i2.add("phone");
        i2.add("silver");
        i2.add("lenovo");

        List<String> i3 = new ArrayList<>();
        i3.add("phone");
        i3.add("gold");
        i3.add("iphone");
        l.add(i1); l.add(i2); l.add(i3);

        System.out.println(countMatches(l, "type", "phone"));

    }
}
