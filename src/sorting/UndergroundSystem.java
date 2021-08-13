package sorting;

import java.util.HashMap;
import java.util.Map;

class CustomerTravel {
    int time;
    String stationName;

    CustomerTravel() {

    }
}

class Travel {
    double totalTime;
    int count;

    Travel() {

    }
}

public class UndergroundSystem {
    HashMap<Integer, CustomerTravel> map;
    HashMap<String, Travel> total;

    public UndergroundSystem() {
        map = new HashMap<>();
        total = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        map.putIfAbsent(id, new CustomerTravel());

        CustomerTravel customerTravel = map.get(id);
        customerTravel.time = t;
        customerTravel.stationName = stationName;
    }

    public void checkOut(int id, String stationName, int t) {
        CustomerTravel customerTravel = map.get(id);

        String full = customerTravel.stationName + ":" + stationName;

        total.putIfAbsent(full, new Travel());
        Travel travel = total.get(full);

        travel.totalTime += t - customerTravel.time;
        travel.count++;
    }

    public double getAverageTime(String startStation, String endStation) {
        String full = startStation + ":" + endStation;

        return total.get(full).totalTime / total.get(full).count;
    }

    public static void main(String[] args) {
        UndergroundSystem s = new UndergroundSystem();
      /*  s.checkIn(27, "Leyton", 10);
        s.checkOut(27, "Waterloo", 20);

        System.out.println(s.getAverageTime("Leyton", "Waterloo"));
        s.checkIn(45, "Leyton", 3);
        s.checkIn(32, "Paradise", 8);


        s.checkOut(45, "Waterloo", 15);

        s.checkOut(32, "Cambridge", 22);


        System.out.println(s.getAverageTime("Paradise", "Cambridge"));
        System.out.println(s.getAverageTime("Leyton", "Waterloo"));
        s.checkIn(10, "Leyton", 24);

        System.out.println(s.getAverageTime("Leyton", "Waterloo"));
        s.checkOut(10, "Waterloo", 38);
        System.out.println(s.getAverageTime("Leyton", "Waterloo"));*/

        s.checkIn(10, "Leyton", 3);
        s.checkOut(10, "Paradise", 8);
        System.out.println(s.getAverageTime("Leyton", "Paradise"));
        s.checkIn(5, "Leyton", 10);
        s.checkOut(5, "Paradise", 16);
        System.out.println(s.getAverageTime("Leyton", "Paradise"));
        s.checkIn(2, "Leyton", 21);
        s.checkOut(2, "Paradise", 30);
        System.out.println(s.getAverageTime("Leyton", "Paradise"));
    }
}
