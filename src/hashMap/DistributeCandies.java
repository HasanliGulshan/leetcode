package hashMap;

import java.util.HashMap;

public class DistributeCandies {
    public static int distributeCandies(int[] candyType) {
        int candies = candyType.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int c : candyType) map.put(c, map.getOrDefault(c, 0) + 1);

        return Math.min(map.size(), candies);
    }

    public static void main(String[] args) {
        int[] n = new int[]{6,6,6,6};
        System.out.println(distributeCandies(n));
    }
}
