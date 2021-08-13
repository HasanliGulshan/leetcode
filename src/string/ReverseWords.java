package string;

public class ReverseWords {

    public static void reverseWords(char[] input) {
        // Reverses the whole string first.
        reverse(input, 0, input.length);

        int start = 0, end;
        while ((end = find(input, ' ', start)) != -1) {
            // Reverses each word in the string.
            reverse(input, start, end);
            start = end + 1;
        }

        // Reverses the last word.
        reverse(input, start, input.length);

        for (char c : input) System.out.print(c);
    }

    public static void reverse(char[] array, int start, int stoplndex) {
        if (start >= stoplndex) {
            return;
        }
        int last = stoplndex - 1;
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char tmp = array[i];
            array[i] = array[last - i + start];
            array[last - i + start] = tmp;
        }
    }

    public static int find(char[] array, char c, int start) {
        for (int i = start; i < array.length; i++) {
            if (array[i] == c) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        char[] input = new char[]{'A', 'l', 'i', 'c', 'e', ' ', 'l', 'i', 'k', 'e', 's', ' ', 'B', 'o', 'b'};
        reverseWords(input);
    }
}
