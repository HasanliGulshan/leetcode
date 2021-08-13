package sorting;

import java.util.*;

class Person {
    public Integer age;
    public String name;

    public Person(Integer k, String n) {
        age = k;
        name = n;
    }
}

public class GroupByAge {
    public static void groupByAge(List<Person> people) {
        Map<Integer , Integer> ageToCount = new HashMap<>();
        for (Person p : people) {
            if (ageToCount.containsKey(p.age)) {
                ageToCount.put(p.age , ageToCount.get(p.age) + 1);
            } else {
                ageToCount.put(p.age , 1);
            }
        }
        Map<Integer , Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer , Integer> kc : ageToCount.entrySet()){
            ageToOffset.put(kc.getKey () , offset);
            offset += kc.getValue();
        }
        while (!ageToOffset.isEmpty()){
            Map.Entry<Integer, Integer> from
                    = ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age ;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people , from.getValue(), toValue);
// Use ageToCount to see when we are finished with a particular age.
            Integer count = ageToCount.get(toAge)- 1;
            ageToCount.put(toAge , count);
            if (count > 0) {
                ageToOffset.put(toAge , toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person(14, "greg");
        Person p2 = new Person(12, "John");
        Person p3 = new Person(11, "Andy");
        Person p4 = new Person(13, "Jim");
        Person p5 = new Person(12, "Phil");
        Person p6 = new Person(13, "Bob");
        Person p7 = new Person(13, "Chip");
        Person p8 = new Person(14, "Tim");

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);

        groupByAge(list);
    }
}
