package string;

import java.util.Arrays;

public class FindReplaceString {
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int[] match = new int[S.length()];
        Arrays.fill(match, -1);
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < indexes.length; i++) {
            int start = indexes[i];
            int end = sources[i].length();

            String sub = S.substring(start, start + end);

            if (sub.equals(sources[i])) {
                match[indexes[i]] = i;
            }
        }

        //indexes  follows S.len, so if there is change in indexes, we will now by match, bcs matches index is indexes[] values ex: 3, 5, 1
        while (j < S.length()) {

            if (match[j] != -1) {
                int index = match[j];
                sb.append(targets[index]);

                j += sources[index].length();
            } else {
                sb.append(S.charAt(j));
                j++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = new int[]{0, 2};
        String[] sources = new String[]{"ab", "ec"}, targets = new String[]{"eee", "ffff"};

        System.out.println(findReplaceString(S, indexes, sources, targets));
    }
}
