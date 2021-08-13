package bits;

public class Power {
    public static double power(double x, int y){
        double result = 1.0;
        long power = y;
        if (y < 0) {
            power = -power;
            x = 1.0 / x ;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x ;
            power >>= 1 ;
        }
        return result ;
    }

    public static void main(String[] args) {
        //2^11 x=2, y = 11 = (1011) getting square is equal in binary form counting. 2^11 = 2^8 * 2^2 * 2^1 and also in 11 = 2^3 + 2^2 + 2^1
        //here 2^8 here 8 also in binary 2^3 = 8, 2^2 in binary 2, 2^1 in binary 1
        System.out.println(power(5, 6));
    }
}
