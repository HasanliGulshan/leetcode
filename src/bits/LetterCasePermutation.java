package bits;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int letterCount = 0, letter = 0;

        for (int j = 0; j < S.length(); j++) {
            if (Character.isLetter(S.charAt(j)))
                letterCount++;
        }

        for (int i = 0; i < Math.pow(2, letterCount); i++) {
            sb.setLength(0);
            for (int j = 0; j < S.length(); j++) {
                if (Character.isLetter(S.charAt(j))) {
                    int h = 1 << letter;
                    letter++;
                    if ((h & i) != 0) {
                        sb.append(Character.isLowerCase(S.charAt(j)) ? Character.toUpperCase(S.charAt(j)) : Character.toLowerCase(S.charAt(j)));
                    } else {
                        sb.append(S.charAt(j));
                    }
                } else {
                    sb.append(S.charAt(j));
                }
            }
            letter = 0;
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
      //  String s = "a1b2";
        String s = "12345";
        System.out.println(letterCasePermutation(s));
    }
}
