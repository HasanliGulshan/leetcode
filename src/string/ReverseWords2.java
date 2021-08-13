package string;

public class ReverseWords2 {
    public static String reverseWords(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        while (j >= 0 && s.charAt(j) == ' ') {
                j--;
        }

        System.out.println("i = " + i + " " + j);
        while (i <= j) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));

                i++;
            } else {
                sb.append(s.charAt(i));
                while (i < s.length() && s.charAt(i) == ' ') i++;
            }
        }


        char[] arr = sb.toString().toCharArray();

        int end, start = 0;
       //reverse array
       reverse(arr, 0, arr.length);

       while ((end = findLastIndex(arr, ' ', start)) != -1) {
           reverse(arr, start, end);

           //to get start of next word
           start = end + 1; // +1 is to pass whitespace
       }
       //reverse last word
       reverse(arr, start, arr.length);

       return new String(arr);
    }

    public static void reverse (char[] arr, int start, int end) {
        if (start >= end) return;

        int last = end - 1; // -1 is whitespace
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[last - i + start];
            arr[last - i + start] = temp;
        }
    }

    public static int findLastIndex (char[] arr, char c, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == c) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" a good   example  "));
        System.out.print("ddd");
    }
}
