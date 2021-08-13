package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestCity {
    public static String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        String ans = "";

        for (List<String> path : paths) {
             map.put(path.get(0), path.get(1));
        }

        for (Map.Entry<String, String> m : map.entrySet()){
             ans =  m.getValue();
             if (!map.containsKey(ans)) {
                 return ans;
             }
        }

        return "";
    }

    public static void main(String[] args) {
       List<List<String>> l = new ArrayList<>();
       List<String> item1 = new ArrayList<>();
       //[["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
       item1.add("London");
        item1.add("New York");

        l.add(item1);
        List<String> item2 = new ArrayList<>();
        item2.add("New York");
        item2.add("Lima");

        l.add(item2);

        List<String> item3 = new ArrayList<>();
        item3.add("Lima");
        item3.add("Sao Paulo");

        l.add(item3);

        System.out.println(destCity(l));
    }
}
