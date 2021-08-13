package bits;

public class Decode {
    public static int[] decode(int[] encoded) {
        int[] res = new int[encoded.length + 1];
        int f = (encoded.length + 2 >>1) % 2;

        for (int i = 1; i < encoded.length; i += 2)
            f ^= encoded[i];

        //f is perm[0], we an ind perm[1] = perm[0] ^ encoded[0] and so.on
        // x^y=z here x is equal y^z
        res[0] = f;
        for (int i = 0; i<res.length-1; i++) {
            res[i+1] = encoded[i] ^ res[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3, 1};
int[] r = decode(n);
        for (int h : r)
          System.out.print(h + " ");
    }
}
