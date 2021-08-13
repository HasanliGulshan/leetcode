package string;

public class MinFlips {
    public static int minFlips(String target) {
        char status = '0'; int ans = 0;

        for (int i = 0; i < target.length(); i++) {
            if (status != target.charAt(i)) {
                status = target.charAt(i);
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("10111"));
    }
}
