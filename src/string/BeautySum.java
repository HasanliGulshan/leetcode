package string;

public class BeautySum {

    public static int beautySum(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];

            count[s.charAt(i) - 'a']++;
            for (int j = i + 1; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                ans += getNum(count);
            }
        }

        return ans;
    }

    static int getNum (int[] count) {
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;

        for (int num : count) {
            if (num != 0) {
                minFreq = Math.min(minFreq, num);
                maxFreq = Math.max(maxFreq, num);
            }
        }

        return maxFreq - minFreq;
    }

    //
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
    }
}
