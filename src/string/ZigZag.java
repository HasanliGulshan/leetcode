package string;

import java.util.Arrays;

public class ZigZag {
    public static String convert(String s, int numRows) {
          if (numRows == 1) {
              return s;
          } else {
              String[] ss = new String[numRows];
              Arrays.fill(ss, "");
              boolean down = true;
              int row = 0;

              for (int i = 0; i < s.length(); i++) {
                  ss[row] += (s.charAt(i));

                  if (row == numRows - 1) {
                      down = false;
                  } else if (row == 0) {
                      down = true;
                  }

                  if (down) {
                      row++;
                  } else {
                      row--;
                  }
              }

              StringBuilder res = new StringBuilder();
              for (String a : ss) {
                  res.append(a);
              }
              return res.toString();
          }
    }

    public static void main(String[] args) {
        String s= "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }
}
