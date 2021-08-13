package hashMap;

public class AlienSorted {
    public static boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];

        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            int firstIndex = 0;
            int secondIndex = 0;
            boolean found = false;

            while (firstIndex < words[i].length() && secondIndex < words[i + 1].length()) {
                if (words[i].charAt(firstIndex) != words[i + 1].charAt(secondIndex)) {
                    if (orderMap[words[i].charAt(firstIndex) - 'a'] < orderMap[words[i + 1].charAt(secondIndex) - 'a']) {
                        found = true;
                        break;
                    } else {
                        return false;
                    }
                }

                firstIndex++;
                secondIndex++;
            }

            if (!found) {
                if (firstIndex < words[i].length() && secondIndex == words[i + 1].length())
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /*String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";*/

        String[] words = new String[]{"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words, order));
    }
}
