package math;

public class AddDigits {
    public static int addDigits(int num) {
        int currentNum = 0;
        while (num > 0) {
            currentNum += num%10;
            num /= 10;

            if (num == 0 && currentNum > 9) {
                num = currentNum;
                currentNum = 0;
            }
        }

        return currentNum;
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
}
