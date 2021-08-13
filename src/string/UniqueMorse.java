package string;

import java.util.HashSet;

public class UniqueMorse {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] code = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            for (char c : s.toCharArray()) {
                sb.append(code[c - 'a']);
            }

            set.add(sb.toString());
            sb.setLength(0);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] s = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(s));
    }
}
