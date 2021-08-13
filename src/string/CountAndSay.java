package string;

import java.util.Scanner;

public class CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";

        for (int i=1; i<n; i++) {
            result = say(result);
            System.out.println("res = "+ result);
        }
        return result;
    }

    public static String say(String res) {
        StringBuilder str = new StringBuilder();
        int start = 0;
        int end = 0;

        for (int i=0; i<res.length(); i++) {
            if (res.charAt(start) == res.charAt(i)) {
                end++;
            } else {
                System.out.println("nd = " + end);
                str.append(end).append(res.charAt(start));
                start = i;
                end = 1;
                System.out.println(" start = "+ start);
            }
        }
        str.append(end).append(res.charAt(start));
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(countAndSay(n));
    }
}
