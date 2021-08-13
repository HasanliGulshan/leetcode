package sorting;

import java.util.*;

public class MinSetSize {
    public static int minSetSize(int[] arr) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (lhs, rhs) -> rhs.getValue() - lhs.getValue());

        int arrLength = arr.length;
        int target = arrLength / 2;
        int index = 0;
        int res = 0;

        while (arrLength > target && index < list.size()) {
            Map.Entry<Integer, Integer> m = list.get(index);

            arrLength -= m.getValue();
            index++;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(minSetSize(arr));
    }
}
