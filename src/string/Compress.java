package string;

import java.util.Scanner;

public class Compress {

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        } else if (chars.length == 1) {
            return 1;
        } else {
            int start = 0;
            int count = 0;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                System.out.println("i = " + i);

                while (start < chars.length && chars[start] == chars[i]) {
                    count++;
                    start++;
                }
                System.out.println("index = " + index + "count=" + count);
                chars[index++] = chars[i];

                //where index begins to put count in
                int  p = index;
                if (count > 1) {
                    while (count > 0) {
                        int temp = count % 10;
                        chars[index++] = (char) (temp + '0');
                        count = count / 10;

                    }
                }

                if (start - i >= 10) {
                    reverse(chars, p, index - 1);
                }
                i = start;
                i-=1;
                count = 0;
            }

            System.out.println("here");
            for (int i = 0; i < index; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
            return index;
        }
    }

    public static void reverse(char[] chars, int start, int index) {
        while (start < index) {
            char temp = chars[start];
            chars[start] = chars[index];
            chars[index] = temp;

            start++;
            index--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};

        System.out.println(compress(c));
    }
}

