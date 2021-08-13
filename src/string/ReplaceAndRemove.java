package string;

public class ReplaceAndRemove {
    public static int replaceAndRemove (int size, char[] s) {
        int writeIdx = 0, aCount = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] != 'b') {
                s[writeIdx++] = s[i];
            }

            if (s[i] == 'a')
                aCount++;
        }

        int currIdx = writeIdx - 1;
        writeIdx = writeIdx + aCount - 1;

        final int finalSize = writeIdx + 1;

        while (currIdx >= 0) {
            if (s[currIdx] == 'a') {
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                s[writeIdx--] = s[currIdx];
            }
            currIdx--;
        }

        for (char c : s) System.out.print(c + " ");

        return finalSize;
    }

    public static void main(String[] args) {
        char[] c = new char[]{'a', 'c', 'd', 'b', 'b', 'c', 'a'};
        System.out.println(replaceAndRemove(7, c));
    }
}
