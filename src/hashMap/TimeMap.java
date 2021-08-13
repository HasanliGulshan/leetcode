package hashMap;

import java.util.*;

class Data{
    int timeStamp;
    String value;

    public Data(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}

public class TimeMap {
    Map<String, List<Data>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Data> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Data(timestamp, value));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Data> list = map.get(key);
        if (list.get(0).timeStamp > timestamp) {
            return "";
        }

        return binarySearch(list, timestamp);
    }


    public String binarySearch(List<Data> list, int timestamp){
        int low = 0;
        int high = list.size()-1;
        while (low + 1 < high) {
            int middle = (list.get(low).timeStamp + list.get(high).timeStamp)/2;
            if (middle == timestamp) {
                return list.get(middle).value;
            } else if (middle < timestamp) {
                low = middle;
            } else {
                high = middle;
            }
        }
        if (list.get(high).timeStamp <= timestamp) {
            return list.get(high).value;
        } else {
            return list.get(low).value;
        }
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo",1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));

        /*obj.set("love", "high", 10);
        obj.set("love", "low", 20);

        System.out.println(obj.get("love", 5));
        System.out.println(obj.get("love", 10));
        System.out.println(obj.get("love", 15));
        System.out.println(obj.get("love", 20));
        System.out.println(obj.get("love", 25));*/
    }
}
