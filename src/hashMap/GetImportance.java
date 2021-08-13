package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class GetImportance {
    static HashMap<Integer, Employee> map;
    public static int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(id);
    }

    static int dfs(int id) {
        Employee e = map.get(id);

        int ans = e.importance;

        for (int subE : e.subordinates) {
            ans += dfs(subE);
        }

        return ans;
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.id = 1;
        e.importance = 5;

        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);

        e.subordinates = ids;

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();

        List<Employee> list = new ArrayList<>();
        list.add(e);
        list.add(e2);
        list.add(e3);

        System.out.println(getImportance(list, 1));
    }
}
