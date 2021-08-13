package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReplaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            boolean isContain = false;

            String sub = null;
            for (int i = 1; i < word.length(); i++) {
                sub = word.substring(0, i);

                if (set.contains(sub)) {
                    isContain = true;
                    break;
                }
            }

            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(isContain? sub: word);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(dictionary, sentence));
    }
}
