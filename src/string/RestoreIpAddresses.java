package string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        for (int i = 1; i < 4 && i < s.length(); i++) {
            final String first = s.substring(0, i);

            if (isValid(first)) {
                for (int j = 1; j + i < s.length() && j < 4; j++) {
                    final String second = s.substring(i, i + j);
                    if (isValid(second)) {
                        for (int k = 1; i + j + k < s.length() && k < 4; k++) {
                            final String third = s.substring(i + j, i + j + k);
                            final String fourth = s.substring(i + j + k);

                            if (isValid(third) && isValid(fourth)) {
                                res.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    public static boolean isValid(String s) {
        if (s.length() > 3) return false;

        //begins with 0 , 01, 001 not valid
        if (s.startsWith("0") && s.length() > 1) return false;

        int value = Integer.parseInt(s);

        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("19216811"));
    }
}
