package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
       int[] count = new int[1001];
       int[] ans = new int[arr1.length];
       int j = 0, times = 0;

       for (int i = 0; i < arr1.length; i++) {
           count[arr1[i]]++;
       }

       for (int i = 0; i<arr2.length; i++) {
           times = count[arr2[i]];

           while (times > 0) {
               ans[j++] = arr2[i];
               times--;
           }
       }

        List<Integer> list = new ArrayList<>();

       for (int i = 0; i < arr1.length; i++) {
           int value = 0;
           for (int k = 0; k < arr2.length; k++) {
               if (arr1[i] != arr2[k]) {
                   value++;
               }
           }
           if (value == arr2.length) {
              list.add(arr1[i]);
           }
       }

        Collections.sort(list);

       for (int l : list){
         ans[j++] = l;
       }

       //can detect other values which is not in arr2 with assign 0 to every element which used in  second loop
       return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{28,6,22,8,44,17}, arr2 = new int[]{22,28,8,6};

        System.out.println(relativeSortArray(arr1, arr2));
    }
}
