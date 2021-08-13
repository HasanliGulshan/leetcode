package string;

public class Halves {
    public static boolean halvesAreAlike(String s) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int i = 0, j = s.length() - 1, len = s.length() / 2, count = 0;

        while (i < len && j >= len) {

            if (contain(s.charAt(i), vowels)) count++;

            if (contain(s.charAt(j), vowels)) count--;

            i++;
            j--;
        }

        return count == 0;
    }

    static boolean contain(char c, char[] vowels) {
        for (char v : vowels) {
            if (v == c) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("MerryChristmas"));
    }
}
