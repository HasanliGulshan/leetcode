package binary_search;

public class MaxDepthAfterSplit {
    public static int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.isEmpty())
            return null;

        int currLevel = 0;
        int maxLevel = 0;
        int n = seq.length();
        int[] seqArr = new int[seq.length()];
        for (int i = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                seqArr[i] = currLevel;
                currLevel++;
            } else {
                currLevel--;
                seqArr[i] = currLevel;
            }
            maxLevel = Math.max(maxLevel, currLevel);
        }

        int threshold = maxLevel / 2;
        //level[i] >= threshold then it belongs to B else A
        for (int i = 0; i < seqArr.length; ++i) {
            if (seqArr[i] >= threshold)
                seqArr[i] = 1;
            else
                seqArr[i] = 0;
        }

        for (int s : seqArr) System.out.print(s + " ");
        return seqArr;
    }

    public static void main(String[] args) {
        maxDepthAfterSplit("()(((())))()");
    }
}
