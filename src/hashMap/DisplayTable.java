package hashMap;

import java.util.*;

 class OrderFreq {
    String foodItem;
    int count;

    OrderFreq(String foodItem, int count) {
        this.foodItem = foodItem;
        this.count = count;
    }
}
public class DisplayTable {
    /*public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> set = new TreeSet<>();
        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, List<OrderFreq>> map = new HashMap<>();

        for (List<String> order : orders) {
            set.add(order.get(2));
            int tableNum = Integer.parseInt(order.get(1));

            if (map.containsKey(tableNum)) {
                boolean found = false;
                List<OrderFreq> list = map.get(tableNum);

                for (OrderFreq orderFreq : list) {
                    if (orderFreq.foodItem.equals(order.get(2))) {
                        orderFreq.count = orderFreq.count  + 1;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    OrderFreq orderFreq = new OrderFreq(order.get(2), 1);
                    list.add(orderFreq);
                }
            } else {
                List<OrderFreq> list = new ArrayList<>();
                list.add(new OrderFreq(order.get(2), 1));
                map.put(tableNum, list);
            }
        }

        List<String> foodItems = new ArrayList<>();
        foodItems.add("Table");
        foodItems.addAll(set);

        ans.add(foodItems);

        ArrayList<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys, Comparator.naturalOrder());

        for (Integer key : sortedKeys) {
            List<String> item = new ArrayList<>();

            item.add(String.valueOf(key));
            List<OrderFreq> orderFreqByTableNum = map.get(key);

            for (int i = 1; i<foodItems.size(); i ++) {
                boolean found = false;

                for (OrderFreq orderFreq : orderFreqByTableNum) {
                    if (orderFreq.foodItem.equals(foodItems.get(i))) {
                        item.add(String.valueOf(orderFreq.count));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    item.add("0");
                }
            }

            ans.add(item);
        }

        System.out.println(ans);
        return ans;
    }*/

    public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> set = new TreeSet<>();
        List<List<String>> ans = new ArrayList<>();
        TreeMap<String, HashMap<String, Integer>> map = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

        for (List<String> order : orders) {
           set.add(order.get(2));

           if (map.containsKey(order.get(1))) {
               HashMap<String, Integer> exit = map.get(order.get(1));

               if (exit.containsKey(order.get(2))) {
                   exit.put(order.get(2), exit.get(order.get(2)) + 1);
               } else {
                   exit.put(order.get(2), 1);
               }
           } else {
               HashMap<String, Integer> item = new HashMap<>();
               item.put(order.get(2), 1);
               map.put(order.get(1), item);
           }
        }

        List<String> foodItems = new ArrayList<>();
        foodItems.add("Table");
        foodItems.addAll(set);

        ans.add(foodItems);

        for (String key : map.keySet()) {
            List<String> item = new ArrayList<>();

            item.add(key);

            for (int i = 1; i < foodItems.size(); i++) {
                String foodName = foodItems.get(i);

                if (map.get(key).containsKey(foodName)) {
                    item.add(String.valueOf(map.get(key).get(foodName)));
                } else {
                    item.add("0");
                }
            }

            ans.add(item);
        }

        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        List<List<String>> req = new ArrayList<>();
        List<String> item = new ArrayList<>();

        item.add("David");
        item.add("3");
        item.add("Ceviche");

        req.add(item);

        List<String> item2 = new ArrayList<>();

        item2.add("Corina");
        item2.add("10");
        item2.add("Beef Burrito");

        req.add(item2);

        List<String> item3 = new ArrayList<>();

        item3.add("David");
        item3.add("3");
        item3.add("Fried Chicken");

        req.add(item3);

        List<String> item4 = new ArrayList<>();

        item4.add("Carla");
        item4.add("5");
        item4.add("Water");

        req.add(item4);

        List<String> item5 = new ArrayList<>();

        item5.add("Carla");
        item5.add("5");
        item5.add("Ceviche");

        req.add(item5);

        List<String> item6 = new ArrayList<>();

        item6.add("Rous");
        item6.add("3");
        item6.add("Ceviche");

        req.add(item6);

        System.out.println(displayTable(req));
    }
}
