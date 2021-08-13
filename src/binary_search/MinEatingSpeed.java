package binary_search;

import java.util.Arrays;

public class MinEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h) {
         int left = 1, right = Arrays.stream(piles).max().getAsInt();

         while (left <= right) {
             int mid = left + (right - left)/2;

             if (canEatInTime(mid, piles) <= h) {
                 right = mid - 1;
             } else {
                 left = mid + 1;
             }
         }

         return left;
    }

    public static int canEatInTime(int mid, int[] piles) {
        int maxPilesInTime = 0;

        for (int pile : piles) {
            int perHour = pile / mid;

            if (pile % mid == 0) {
                maxPilesInTime += perHour;
            } else {
                maxPilesInTime += perHour  + 1;
            }
        }

        return maxPilesInTime;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
///30,11,23,4, 20
        System.out.println(minEatingSpeed(piles, 8));
    }
}
