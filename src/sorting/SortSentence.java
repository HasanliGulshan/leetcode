package sorting;

import java.util.Arrays;
import java.util.Objects;

public class SortSentence {
    public static String sortSentence(String s) {
        String[] sorted = new String[9];
        String[] unsorted = s.split(" ");

        for (int i = 0; i < unsorted.length; i++) {
            int index = unsorted[i].charAt(unsorted[i].length() - 1) - '0';
            String word = unsorted[i].substring(0, unsorted[i].length() - 1);

            word = index - 1 != unsorted.length - 1 ? word + " " : word;
            sorted[index - 1] = word;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(sorted).filter(Objects::nonNull).forEach(sb::append);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
