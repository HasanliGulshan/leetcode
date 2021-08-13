package arrays;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;

        for (int c : candies) maxCandies = Math.max(maxCandies, c);

        for (int c : candies) list.add((c + extraCandies) >= maxCandies);

        return list;
    }

    public static void main(String[] args) {
        int[] c = new int[]{2,3,5,1,3};
        System.out.println(kidsWithCandies(c, 3));
    }
}
