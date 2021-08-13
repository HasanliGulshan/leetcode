package math;

public class UglyNumber {
    public static boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return false;

        return factor(num);
    }

    static boolean factor(int num) {
        if (num == 1) return true;

        if (num % 2 == 0)
            return factor(num/=2);
        if (num % 3 == 0)
            return factor(num/=3);
        if (num % 5 == 0)
            return factor(num/=5);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}
