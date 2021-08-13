package sorting;

public class CustomSortString {
    public static String customSortString(String order, String str) {
        int[] count = new int[26];

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            int value = count[c - 'a'];

            while (value -- > 0) {
                sb.append(c);
            }

            count[c - 'a'] = 0;
        }

        for (char c : str.toCharArray()) {
            int value = count[c - 'a'];

            if (value != 0) {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
           customSortString("cba", "abcd");
    }
}
