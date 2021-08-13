package hashMap;

import java.util.HashMap;

public class JewelsInStones {
    public static int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        int countOfStones = 0;

        for (char c : stones.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : jewels.toCharArray()) {
            if (map.containsKey(c))
                countOfStones += map.get(c);

        }

        return countOfStones;
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }
}
