package string;

public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;
        if (typed.length() < name.length()) return false;

        int i = name.length() - 1, j = typed.length() - 1;

        while (i >=0 && j >=0 ) {
            if (name.charAt(i) == typed.charAt(j)) {
                int amountN = 0;
                int amountT = 0;

                while (i >=1 && name.charAt(i) == name.charAt(i - 1)) {
                    amountN++;
                    i--;
                }

                while (j >=1 && typed.charAt(j) == typed.charAt(j - 1)) {
                    amountT++;
                    j--;
                }

                if (amountT < amountN) return false;

                i--;j--;

            } else {
                return false;
            }
        }

        System.out.println(i + " " + j);
        //if are positive , means does not reach end of word so false
        if (i >=0 || j>=0) return false;
        return true;
    }

    public static void main(String[] args) {
       //""""
        //""""
        //""""
        //""
        //""""
        //""
        System.out.println(isLongPressedName("zlexya", "aazlllllllllllllleexxxxxxxxxxxxxxxya"));
    }
}
