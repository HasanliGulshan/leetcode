package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>();


        for (int[] arr : intervals) {
            System.out.println(arr[0] + " " + arr[1]);
        }
        System.out.println("::::::::::::::::::");
        for (int i = 0; i < intervals.length; i++) {
            int k = i;
            boolean checked = false;

            for (int j = i + 1; j < intervals.length; j++) {

                if (intervals[i][1] >= intervals[j][0] || intervals[i][1] >= intervals[j][1]) {
                    k = j;
                    int jMax =  Math.max(intervals[j][0], intervals[j][1]);
                    intervals[i][1] = Math.max(intervals[i][1], jMax);
                } else {
                    checked = true;
                    int[] item = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[j - 1][1])};
                    list.add(item);
                    break;
                }
            }

            if (!checked) {
                int[] item = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[k][1])};
                list.add(item);
            }

            i = k;
        }

        for (int[] arr : list) {
            System.out.println(arr[0] + " " + arr[1]);
        }

        int[][] ans = new int[list.size()][2];

        return list.toArray(ans);
    }

    public static void main(String[] args) {
             int[][] req = new int[][]{{1,4},{4,5}};
        // int[][] req = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        //int[][] req = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
      //int[][] req = new int[][]{{1,4},{0,2},{3,5}};
        merge(req);
    }
}
