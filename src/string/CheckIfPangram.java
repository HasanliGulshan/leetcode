package string;

public class CheckIfPangram {
    public static boolean checkIfPangram(String sentence) {
        boolean[] alpa = new boolean[26];
        int count = 0;

        for (char c : sentence.toCharArray()) {
            //first seen
            if (!alpa[c - 'a']) {
                alpa[c - 'a'] =  true;
                count++;
            }
        }

        System.out.println(count);
        return count == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("leetcode"));
    }
}
