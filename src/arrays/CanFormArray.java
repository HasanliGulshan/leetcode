package arrays;

import java.util.HashMap;

public class CanFormArray {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (!map.containsKey(pieces[i][j])) return false;

                if ((j + 1) < pieces[i].length && map.containsKey(pieces[i][j + 1]) && map.get(pieces[i][j]) + 1 != map.get(pieces[i][j + 1])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] n = new int[]{91,4,64,78};
        int[][] m = new int[][]{{78},{4,64},{91}};

        System.out.println(canFormArray(n, m));
    }
}
