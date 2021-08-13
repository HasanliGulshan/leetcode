package string;

public class ValidIPAddress {
    public static String validIPAddress(String IP) {
        boolean flag = IP.contains(".");

        if (flag) {
            if (IP.startsWith(".") || IP.endsWith(".")) return "Neither";
            String[] ipv4 = IP.split("\\.");
            if (ipv4.length != 4) return "Neither";

            for (String ip : ipv4) {
                if (!isValidIpv4(ip)) return "Neither";
            }

            return "IPv4";
        } else {

            if (IP.startsWith(":") || IP.endsWith(":")) return "Neither";

            String[] ipv6 = IP.split(":");
            if (ipv6.length != 8) return "Neither";

            for (String ip : ipv6) {
                if (!isValidIpv6(ip)) return "Neither";
            }

            return "IPv6";
        }
    }

    public static boolean isValidIpv4 (String s) {
        if (s.isEmpty() || s.length() > 3) return false;

        //not valid if starts with 0
        if (s.startsWith("0") && s.length() > 1) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        int address = Integer.parseInt(s);

        return address >= 0 && address <= 255;
    }

    public static boolean isValidIpv6 (String s) {
        if (s.isEmpty() || s.length() > 4) return false;

        for (char c: s.toCharArray()) {
            if (!Character.isDigit(c)) {
                if ((c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f') ||
                    (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F')) {
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
