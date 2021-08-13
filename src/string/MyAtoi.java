package string;


public class MyAtoi {
    public static int myAtoi(String s) {
         if (s.length() == 0) return 0;
         int result = 0;
         int sign = 1, i = 0;

         //first remove whitespaces
         while (i < s.length() && s.charAt(i) == ' ') i++;

         //then get the sign
         if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+'))
             sign = s.charAt(i++) == '-' ? -1 : 1;

         //loop only numbers, from number started then any sign or letter can not be in loop
         while (i < s.length() && (s.charAt(i) >= 48 && s.charAt(i) <=57)) {
             if ((result == (Integer.MAX_VALUE / 10) && s.charAt(i) > 55) || (result > (Integer.MAX_VALUE / 10))) {
                 return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
             }

             result = result * 10 + (s.charAt(i++) - '0');
         }

         return sign *result;
    }

    public static void main(String[] args) {
       /* System.out.println(myAtoi("     -42"));
        System.out.println(myAtoi("4193 with words"));*/
       /* System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));

        System.out.println(myAtoi("-00032"));*/
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("-3.14159"));


        System.out.println(myAtoi("00000-42"));


        System.out.println(myAtoi("-001"));
        System.out.println(myAtoi("00032"));
        System.out.println(myAtoi("00000+42"));

        System.out.println(myAtoi("-13-8"));
    }
}
