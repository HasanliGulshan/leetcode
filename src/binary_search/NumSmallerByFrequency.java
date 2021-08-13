package binary_search;

import java.util.Arrays;

public class NumSmallerByFrequency {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
         int[] queryArr = new int[queries.length];
         int[] wordsArr = new int[words.length];

         for (int i = 0; i < queries.length; i++) {
             queryArr[i] = getLeadingCount(queries[i]);
         }

        for (int i = 0; i < words.length; i++) {
            wordsArr[i] = getLeadingCount(words[i]);
        }

        Arrays.sort(wordsArr);

        for (int i = 0; i < queryArr.length; i++) {
            queryArr[i] = wordsArr.length - countOfQuery(queryArr[i], wordsArr);
        }

        for (int q : queryArr) {
            System.out.print(q + " ");
        }

        return queryArr;
    }

    public static int getLeadingCount(String s) {
        int count=1;
        char smallest = s.charAt(0);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)<smallest)
            {
                smallest=s.charAt(i);
                count=1;
            } else if(s.charAt(i) == smallest)
                count++;
        }

        return count;
    }

    public static int countOfQuery (int key, int[] wordsArr) {
        int low = 0;
        int high = wordsArr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            int midVal = wordsArr[mid];

            if (midVal > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"});
    }
}
