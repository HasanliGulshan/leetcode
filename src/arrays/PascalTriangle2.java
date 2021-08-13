package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public static List<Integer> getRow(int rowIndex) {
        //S C O(N)
        List<Integer> ans = new ArrayList<>();
        int prevValue = 0;

        for (int i = 0; i <= rowIndex; i++) {
            if (ans.isEmpty() || ans.size() == 1) {
                ans.add(1);
            }else {
                for (int j = 1; j <= i; j++) {
                    if (j == 1) {
                        prevValue = ans.set(j, ans.get(i - 2) + ans.get(i - 1));
                    } else if (j == i) {
                        ans.add(1);
                    } else {
                        //prevValue means list.get(j - 1)
                        prevValue = ans.set(j, prevValue + ans.get(j));
                    }
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
       getRow(4);
    }
}
