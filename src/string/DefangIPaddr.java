package string;

public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String s = "1.1.1.1";
        System.out.println(defangIPaddr(s));
    }
}
