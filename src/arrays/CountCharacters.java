package arrays;

import java.util.HashMap;

public class CountCharacters {
    public static int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> wordMap = new HashMap<>();

        int ans = 0, count = 0;

        count(chars, map);

        for (int i = 0; i < words.length; i++) {
           wordMap = new HashMap<>(map);

           for (int j = 0; j < words[i].length(); j++) {
               char c = words[i].charAt(j);
               if (wordMap.containsKey(c) && wordMap.get(c) > 0) {
                   wordMap.put(c, wordMap.get(c) - 1);
                   count++;
               }
           }

           if (count == words[i].length())
               ans += words[i].length();

           wordMap.clear();
           count = 0;
        }

        return ans;
    }

    public static HashMap<Character, Integer> count(String word, HashMap<Character, Integer> map) {
        for (int i = 0; i < word.length(); i++)
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);

        return map;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"hello","world","leetcode"};
        String chars = "welldonehoneyr";



        System.out.println(countCharacters(words, chars));
    }
}
