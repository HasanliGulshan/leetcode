package arrays;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
         if (firstList == null || secondList == null) return null;

         int i = 0, j = 0;

        List<int[]> res = new ArrayList<>();

       while (i < firstList.length && j < secondList.length) {
           int first = Math.max(firstList[i][0], secondList[j][0]);
           int second = Math.min(firstList[i][1], secondList[j][1]);

           if (first < second)
               res.add(new int[]{first, second});

           if (firstList[i][1] < secondList[j][1]) {
               i++;
           } else {
               j++;
           }
       }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = new int[][]{{5,10}/*,{5,10},{13,23},{24,25}*/}, secondList = new int[][]{{3,10}/*,{8,12},{15,24},{25,26}*/};

        System.out.println(intervalIntersection(firstList, secondList));
    }
}
